import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

import {createBrowserRouter, RouterProvider} from "react-router-dom"

import { UserProvider } from "./context/UserContext"

import Home from './pages/Home';
import Login from './pages/Login';
import Cadastro from './pages/Cadastro';
import Lance from './pages/Lance';
import Leilao from './pages/Leilao';
import Unautorized from './pages/Unautorized';

const router = createBrowserRouter([
  {
    path : "/",
    Element : <App />,
    children : [
      {
        path : "/",
        element : <Home />
      },
      {
        path : "login",
        element : <Login />
      },
      {
        path : "cadastro",
        element : <Cadastro />
      },
      {
        path : "dar-novo-lance",
        element : <Lance />
      },
      {
        path : "novo-leilao",
        element : <Leilao />
      },
      {
        path : "Erro-nao-autorizado",
        element : <Unautorized />
      },
    ]
  }
])

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <UserProvider>
     <RouterProvider router={router} />
    </UserProvider>
  </React.StrictMode>
);


reportWebVitals();
