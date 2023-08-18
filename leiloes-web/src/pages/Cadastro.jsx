import { useState, useContext } from 'react'
import { UserContext } from "../context/UserContext"

import Nav from './modules/Nav'
import Loading from './modules/Loading'

import stylesHome from "./css/home.module.css"
import styles from "./css/login.module.css"


const Cadastro = () => {

  const [name, setName] = useState('')
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')
  const [load, setLoad] = useState(false)
  const [info, setInfo] = useState()

  const { handleUser, setData } = useContext(UserContext)

  const handleSubmit = async(e) => {
    e.preventDefault();
    const url = "http://localhost:8080/usuario"
    setLoad(true)
    const user = {
      username,
      name,
      password
    }
    await fetch(url,{
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(user),
    }).then((res) => {
      return res.json()
    }).then((res) =>{
      setData(res)
      handleUser(true, res.username)
      setInfo("success")
    }).catch((error) => {
      setInfo("error")
    })
    setName('')
    setPassword('')
    setUsername('')
    setLoad(false)
  }

  return (
    <div>
        <header className={stylesHome.head}>
            <div className={stylesHome.div_h1}>
                <h1>Leilão</h1>
            </div>
            <ul className={stylesHome.navbar}>
                <Nav PageName="Home" link="/" />
                <Nav PageName="Login" link="/login" />
            </ul>
        </header>
        <main className={stylesHome.main}>
            <header className={stylesHome.container_head}>
                <h1>Cadastro</h1>
            </header>
            <section className={styles.section_login}>
              <form onSubmit={handleSubmit} className={styles.login}>
                <div>
                  <label className={styles.label_login}>
                    <span>Usuário</span>
                    <input type="text" required onChange={(e) => setUsername(e.target.value)} />
                  </label>
                </div>
                <div>
                  <label className={styles.label_login}>
                    <span>Nome</span>
                    <input type="text" required onChange={(e) => setName(e.target.value)} />
                  </label>
                </div>
                <div>
                  <label className={styles.label_login}>
                    <span>Senha</span>
                    <input type="password" required onChange={(e) => setPassword(e.target.value)} />
                  </label>
                </div>
                {load === true ?
                <> 
                  {/* <input type="submit" value="Enviar" disabled className={styles.submit} /> */}
                </>
                :<>
                  <input type="submit" value="Enviar" className={styles.submit} />
                </>}
              </form>
            </section>
            {info === "success" ?
            <p className={styles.p_succes}>Usuário criado com sucesso, agora você pode fazer Login na plataforma</p>
            :info === "error" ?
            <p className={styles.p_error}>Houve algum erro, tente novamente </p>:<></>}
            {load && <Loading />}
        </main>
    </div>
  )
}

export default Cadastro