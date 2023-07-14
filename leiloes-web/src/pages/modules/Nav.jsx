import { Link } from "react-router-dom"

import styles from "../css/nav.module.css"

const Nav = ({PageName, link}) => {
  return (
    <>
        <li className={styles.anchor}><Link to={link}>{PageName}</Link></li>
    </>
  )
}

export default Nav