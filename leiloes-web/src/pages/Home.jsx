import { useState, useContext, useEffect } from 'react'

import { UserContext } from "../context/UserContext"

import Nav from './modules/Nav'

import styles from "./css/home.module.css"
import stylesLance from "./css/lance.module.css"


import { Link, useNavigate } from 'react-router-dom'


const Home = () => {

    const { handleUser, auth, usuario, setAux } = useContext(UserContext)

    const url = "http://localhost:8080/leilao"

    const [data, setData] = useState([])

    const logOut = () =>{
        handleUser(false, "")
    }

    const navigate = useNavigate()

    const handleNavigate = (e) =>{
        setAux(e.target.value)
        console.log(e.target.value)
       navigate("/dar-novo-lance") 
    }

    const newLeilao = () =>{
        navigate("/novo-leilao")
    }

    // removido para entregar da funcionalidade

    useEffect(() =>{
        async function fetchData(){
        const res = await fetch(url)
        
        const dataJson = await res.json()
        console.log(dataJson.content)
        setData(dataJson.content)
        }
        fetchData()
        
    },[auth])


  return (
    <div>
        <header className={styles.head}>
            <div className={styles.div_h1}>
                <h1>Leilão</h1>
            </div>
            <ul className={styles.navbar}>
                {auth === false ? <>
                <Nav PageName="Login" link="/login" />
                <Nav PageName="Cadastre-se" link="/cadastro" />
                </> : <> <li onClick={logOut}><Link>Sair</Link></li></>}
            </ul>
        </header>
        <main className={styles.main}>
            <header className={styles.container_head}>
                <h1>Leilões</h1>
            </header>
            <div className={styles.container}>
                <table className={styles.table_info}>
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Data de Abertura</th>
                            <th>Valor Inicial</th>
                            <th>Usuário</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>

                            {data.map((itens) => (
                                <tr key={itens.id}>
                                <td>{itens.name}</td>
                                <td>{itens.data}</td>
                                <td>R$ {itens.price},00</td>
                                <td>{itens.nameUsuario}</td>
                                <td>
                                    {auth && itens.nameUsuario === usuario ?
                                    <>
                                    <button
                                        value={itens.id}
                                        className={styles.lance} 
                                        onClick={handleNavigate} >
                                        Meu leilão
                                    </button>
                                    </>: auth && itens.nameUsuario !== usuario ?
                                    <>
                                    <button
                                        value={itens.id}
                                        className={styles.lance} 
                                        onClick={handleNavigate} >
                                        Dar Lance
                                    </button>
                                    </>: <></>}
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
            {auth &&
                <div className={stylesLance.div_back}>
                    <input type="button" value="Novo Leilão" onClick={newLeilao} className={stylesLance.btn_submit} />
                </div>
            }
        </main>
    </div>
  )
}

export default Home