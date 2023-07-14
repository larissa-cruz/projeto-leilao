import React from 'react'
import Nav from './modules/Nav'

const Login = () => {
  return (
    <div>
        <header>
            <h1>Leilão</h1>
            <Nav PageName="Home" link="/" />
            <Nav PageName="Cadastre-se" link="/cadastro" />
        </header>
    </div>
  )
}

export default Login