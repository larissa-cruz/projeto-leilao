import { createContext, useState } from "react";

export const UserContext = createContext();

export const UserProvider = ({children}) =>{
    
    const [usuario, setUsuario] = useState();
    const [data, setData] = useState();
    const [aux, setAux] = useState()
    const [auth, setAuth] = useState(false)

    const handleUser = (auth ,name) =>{
        setUsuario(name)
        setAuth(auth)
    }

    return (
        <UserContext.Provider value={{usuario, handleUser, auth, setData, data, aux, setAux}}>{children}</UserContext.Provider>
    )
}