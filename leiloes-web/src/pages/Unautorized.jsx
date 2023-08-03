import stylesHome from "./css/home.module.css"

import Nav from './modules/Nav'

import unauthorized from "./images/unauthorized.png"

const Unautorized = () => {
  return (
    <div>
      <header className={stylesHome.head}>
            <div className={stylesHome.div_h1}>
                <h1>Leilão</h1>
            </div>
            <ul className={stylesHome.navbar}>
                <Nav PageName="Login" link="/login" />
                <Nav PageName="Cadastre-se" link="/cadastro" />
            </ul>
        </header>
        <main className={stylesHome.main}>
            <header className={stylesHome.container_head}>
                <h1>Error 401</h1>
                <p>Parece que você perdeu o acesso a pagina tente fazer login novamente </p>
            </header>
            <div>
              <img src={unauthorized} alt="Não autorizado" />
            </div>
        </main>
    </div>
  )
}

export default Unautorized