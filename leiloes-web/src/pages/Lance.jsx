import { useContext, useEffect, useState } from 'react'
import { UserContext } from "../context/UserContext"
import { Link, useNavigate } from 'react-router-dom'

import Nav from './modules/Nav'

import stylesHome from "./css/home.module.css"
import styles from "./css/lance.module.css"
import Unautorized from './Unautorized'

const Lance = () => {

    const { handleUser, auth, data:dataUser, aux, usuario } = useContext(UserContext)

    const navigate = useNavigate()

    const [data, setData] = useState()
    const [lance, setLance] = useState()
    // const [load, setLoad] = useState()
    const [historyc, setHistoryc] = useState()
 
    const url = `http://localhost:8080/leilao/${aux}`

    const logOut = () =>{
        handleUser(false, "")
        navigate("/")
    }

    const backPage = () => {
        navigate("/")
    }

    // const search = async() =>{
        
    //     const res = await fetch(url)
        
    //     const data = await res.json()
    //     console.log("search")
    //     console.log(data)
    //     setData(data.content)
    //     setLance(data.price)
    //     setHistoryc(data.lances)
        
    // }

    useEffect(() =>{
        async function fetchData(){
        const res = await fetch(url)
        
        const data = await res.json()
        console.log(data)
        setData(data)
        setLance(data.price)
        setHistoryc(data.lances)
        }
        
        fetchData()
        
    },[url])

    const handleSubmit = async(e) =>{
        e.preventDefault();

        // const hoje = new Date()

        // const dataPost = `${hoje.getDate()}/${hoje.getMonth()}/${hoje.getFullYear()}`
        
        const lanceData = {
            "idleilao" : parseInt(aux),
            "iduser" : parseInt(dataUser.id),
            "lance" : parseInt(lance),
            // dataPost
        }
        console.log(lanceData)
        console.log(historyc)
        await fetch("http://localhost:8080/lance",{
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
        //   search()
    }

    const deleteItem = async() =>{
        console.log(aux)
        const deleteUrl = `http://localhost:8080/leilao/${aux}`
        await fetch(deleteUrl,{
            method: "DELETE",
            headers: {
              "Content-Type": "application/json",
            },
          }).then((res) => {
            if(res.status === 200 || res.status === 204) {
                alert("Deletado com sucesso")
                navigate("/")
            }
            return res.json()
          }).catch((error) => {
            console.log(error)
          })
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
                    {data && 
                        <div>
                        <h1>{data.name}</h1>
                        <p>{data.price},00</p>
                        <p>{data.nameUser}, {data.data}</p>
                    </div>}
                </section>
            </div>
            {data && data.nameUser === usuario ? <>
            </> : <>
            <form onSubmit={handleSubmit} className={styles.form}>
                <label>
                    <span>Novo Lance:</span>
                    <input type="number" required min={lance} onChange={(e) =>{setLance(e.target.value)}} />
                </label>
                <input type="submit" value="Enviar" className={styles.btn_lance} />
            </form>
            </>}
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
                            <li className={styles.info_lance_li_bottom}>{itens.dataLance}</li>
                            <li className={styles.info_lance_li_bottom}>{itens.usuario.name}</li>
                            <li className={styles.info_lance_li_bottom}>R${itens.lance},00</li>
                        </ul>
                    ))}    
                </section>:
                <section>
                    <p>Seja o primeiro a fazer um lance</p>
                </section>}
            </div>
            <div className={styles.div_back}>
                <input type="button" value="Voltar" onClick={backPage} className={styles.btn_submit} />
                {data && data.nameUser === usuario ? <input type="button" value="Excluir" onClick={deleteItem} className={styles.btn_submit} />
                :
                <></>}
                
            </div>
        </main>
        </>
        :<Unautorized />}
    </div>
  )
}

export default Lance