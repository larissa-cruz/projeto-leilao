import { useState, useContext } from 'react'
import { UserContext } from "../context/UserContext"
import { useNavigate } from 'react-router-dom'

import Nav from './modules/Nav'
import Loading from './modules/Loading'

import stylesHome from "./css/home.module.css"
import styles from "./css/login.module.css"


const Login = () => {

  const [username, setUsername] = useState()
  const [password, setPassword] = useState()
  const [load, setLoading] = useState(false)

  const { handleUser, setData } = useContext(UserContext)

  const navigate = useNavigate()

  const handleSubmit = async(e) => {
    e.preventDefault();
    setLoading(true)
    const url = `http://localhost:8080/login`
    const user = {username, password}
    console.log(user)
    await fetch(url,{
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        body: JSON.stringify(user)}
    }).then((res) => {
      return res.json()
    }).then((res) =>{
      console.log(res)
      setData(res[0])
      if(res[0].username === username && res[0].password === password){
        handleUser(true, res[0].username)
        navigate("/")
      }
    }
    ).catch((error) => {
      alert("Ocorreu um erro interno no servidor tente novamente mais tarde")
    })
    setLoading(false)
  }

  return (
    <div>
        <header className={stylesHome.head}>
            <div className={stylesHome.div_h1}>
                <h1>Leilão</h1>
            </div>
            <ul className={stylesHome.navbar}>
                <Nav PageName="Home" link="/" />
                <Nav PageName="Cadastre-se" link="/cadastro" />
            </ul>
        </header>
        <main className={stylesHome.main}>
            <header className={stylesHome.container_head}>
                <h1>Login</h1>
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
        </main>
          {load && <Loading />}
    </div>
  )
}

export default Login