import { useState, useContext } from 'react'
import { UserContext } from "../context/UserContext"

import Nav from './modules/Nav'

import styles from "./css/leilao.modules.css"
import stylesLogin from "./css/login.module.css"
import stylesHome from "./css/home.module.css"
import stylesLance from "./css/lance.module.css"


import { Link, useNavigate } from 'react-router-dom'
import Unautorized from './Unautorized'

const Leilao = () => {

    const [name, setname] = useState("")
    const [data, setData] = useState("")
    const [price, setPrice] = useState("")
    

    const logOut = () =>{
        handleUser(false, "")
        navigate("/")
    }

    const backPage = () => {
        navigate("/")
    }

    const { handleUser, auth, usuario, data: dataUser } = useContext(UserContext)

    const handleSubmit = async(e) =>{
        e.preventDefault()

        const url = "http://localhost:8080/leilao"

        const info = {
            name,
            data,
            price,
            "iduser" : dataUser.id
        }
        console.log(info)
        await fetch(url,{
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify(info),
          }).then((res) => {
            if(res.status === 201){
                alert("Seu objeto já foi criado e postado, vá até a aba principal para ver ou crie outro")
            }
            return res.json()
          }).catch((error) => {
            alert("Houve algum erro na hora da criação do do objeto, tente mais tarde")
          })
          setname("")
          setData("")
          setPrice("")
    }

    

    const navigate = useNavigate()
    
  return (
    <div>
        {auth === true ? <>
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
        <main className={stylesHome.main}>
            <header className={stylesHome.container_head}>
                <h1>Novo Leilão</h1>
            </header>
            <form onSubmit={handleSubmit} className={stylesLogin.section_login}>
                <div className={styles.div_input}>
                    <label className={stylesLogin.label_login}>
                        <span className={styles.span}>Item Leiloado</span>
                        <input type="text" onChange={(e) => setname(e.target.value)} required className={styles.inputs} />
                    </label>
                </div>
                <div className={styles.div_input}>
                    <label className={stylesLogin.label_login}>
                        <span className={styles.span}>Valor Inicial</span>
                        <input type="number" onChange={(e) => setPrice(e.target.value)} required className={styles.inputs} />
                    </label>
                </div>
                <div className={styles.div_input}>
                    <label className={stylesLogin.label_login}>
                        <span className={styles.span}>Data do leilão</span>
                        <input type="date" onChange={(e) => setData(e.target.value)} required placeholder='Insira a data no formato dd/mm/aa' className={styles.inputs} />
                    </label>
                </div>
                <div className={styles.div_input}>
                    <label className={stylesLogin.label_login}>
                        <span className={styles.span}>Usuário</span>
                        <input disabled type="text" value={usuario} className={styles.inputs} />
                    </label>
                </div>
                <div className={styles.submit}>
                    <button onClick={handleSubmit} className={stylesHome.btn_submit}>Enviar</button>
                </div>
            </form>
            <div className={stylesLance.div_back}>
                <section>

                    <input type="button" value="Voltar" onClick={backPage} className={styles.btn_submit} />
                </section>
            </div>
        </main>
        </>: <Unautorized/>}
    </div>
  )
}

export default Leilao