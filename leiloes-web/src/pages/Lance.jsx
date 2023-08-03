import { useContext, useEffect, useState } from 'react'
import { UserContext } from "../context/UserContext"
import { Link, useNavigate } from 'react-router-dom'

import Nav from './modules/Nav'

import stylesHome from "./css/home.module.css"
import styles from "./css/lance.module.css"
import Unautorized from './Unautorized'

const Lance = () => {

    const { handleUser, auth, usuario, aux } = useContext(UserContext)

    const navigate = useNavigate()

    const [data, setData] = useState()
    const [lance, setLance] = useState()
    // const [load, setLoad] = useState()
    const [historyc, setHistoryc] = useState()
 
    const url = `http://localhost:3000/objects/${aux}?_embed=lances`

    const logOut = () =>{
        handleUser(false, "")
        navigate("/")
    }

    const backPage = () => {
        navigate("/")
    }

    const search = () =>{
        async function fetchData(){
            const res = await fetch(url)
            
            const data = await res.json()
            setData(data)
            setLance(data.price)
            setHistoryc(data.lances)
            }
        
            fetchData()
    }

    useEffect(() =>{
        async function fetchData(){
        const res = await fetch(url)
        
        const data = await res.json()
        setData(data)
        setLance(data.price)
        setHistoryc(data.lances)
        }
        
        fetchData()
        
    },[url])

    const handleSubmit = async(e) =>{
        e.preventDefault();

        const hoje = new Date()

        const dataPost = `${hoje.getDate()}/${hoje.getMonth()}/${hoje.getFullYear()}`
        
        const lanceData = {
            "objectId" : parseInt(aux),
            "name" : usuario, 
            "lance" : parseInt(lance),
            dataPost
        }
        console.log(lanceData)
        console.log(historyc)
        await fetch("http://localhost:3000/lances",{
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify(lanceData),
          }).then((res) => {
            return res.json()
          }).catch((error) => {
            console.log(error)
          })
          search()
    }

  return (
    <div>
        {auth === true ?
        <>
        <header className={stylesHome.head}>
            <div className={stylesHome.div_h1}>
                <h1>Leilão</h1>
            </div>
            <ul className={stylesHome.navbar}>
                {auth === false ? <>
                <Nav PageName="Login" link="/login" />
                <Nav PageName="Cadastre-se" link="/cadastro" />
                </> : <> <li onClick={logOut}><Link>Sair</Link></li></>}
            </ul>
        </header>
        <main className={styles.main}>
            <header className={stylesHome.container_head}>
                <h1>Dados do Leilão</h1>
            </header>
            <div className={styles.container}>
                <section className={styles.details}>
                    {data && <div>
                        <h1>{data.name}</h1>
                        <p>{data.price},00</p>
                        <p>{data.username}, {data.date}</p>
                    </div>}
                </section>
            </div>
            <form onSubmit={handleSubmit} className={styles.form}>
                <label>
                    <span>Novo Lance:</span>
                    <input type="number" required min={lance} onChange={(e) =>{setLance(e.target.value)}} />
                </label>
                <input type="submit" value="Enviar" className={styles.btn_lance} />
            </form>
            <div className={styles.info_lance}>
                <h1>Lances Dados</h1>
                <hr />
                {historyc && historyc.length !== 0 ? <section>
                    <ul>
                        <li className={styles.info_lance_li_header}>Data</li>
                        <li className={styles.info_lance_li_header}>Usuário</li>
                        <li className={styles.info_lance_li_header}>Valor</li>
                    </ul>
                    {historyc.map((itens) => (
                        <ul>
                            <li className={styles.info_lance_li_bottom}>{itens.dataPost}</li>
                            <li className={styles.info_lance_li_bottom}>{itens.name}</li>
                            <li className={styles.info_lance_li_bottom}>{itens.lance}</li>
                        </ul>
                    ))}    
                </section>:
                <section>
                    <p>Seja o primeiro a fazer um lance</p>
                </section>}
            </div>
            <div className={styles.div_back}>
                <input type="button" value="Voltar" onClick={backPage} className={styles.btn_submit} />
            </div>
        </main>
        </>
        :<Unautorized />}
    </div>
  )
}

export default Lance