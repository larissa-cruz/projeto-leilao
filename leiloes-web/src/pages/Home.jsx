import React from 'react'

import Nav from './modules/Nav'

import styles from "./css/home.module.css"

const Home = () => {
  return (
    <div>
        <header className={styles.head}>
            <div className={styles.div_h1}>
                <h1>Leilão</h1>
            </div>
            <ul className={styles.navbar}>
                <Nav PageName="Login" link="/login" />
                <Nav PageName="Cadastre-se" link="/cadastro" />
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
                        </tr>
                    </thead>
                    <tbody>
                        {/* aqui damos um map nas informações  ficara estatico por enquanto */}
                        <tr>
                            <td>Tablet Samsung</td>
                            <td>15/04/2023</td>
                            <td>R$ 500,00</td>
                            <td>Larissa</td>
                        </tr>
                        <tr>
                            <td>Iphone XR</td>
                            <td>09/05/2023</td>
                            <td>R$ 2000,00</td>
                            <td>Leonardo</td>
                        </tr >
                    </tbody>
                </table>
            </div>
        </main>
    </div>
  )
}

export default Home