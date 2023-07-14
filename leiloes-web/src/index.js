import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

import {createBrowserRouter, RouterProvider} from "react-router-dom"

import Home from './pages/Home';
import Login from './pages/Login';

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
      }
    ]
  }
])

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);


reportWebVitals();
