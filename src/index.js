import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import  {BrowserRouter,Routes,Route} from "react-router-dom";  


import Home from './home';
import Detail from './detail';
import Login from './Login';
import Historique from './historique';
import Recherche from './recherche';
import Rencherir from './rencherir';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <Routes>
      <Route path={'/'} element={<Home/>} ></Route>
      <Route path={'/login'} element={<Login/>} ></Route>
      <Route path={'/detail/:enchereID'} element={<Detail/>} ></Route>
      <Route path={'/historique/:clientID'} element={<Historique/>} ></Route>
      <Route path={'/recherche/'} element={<Recherche/>} ></Route>
      <Route path={'/rencherir/:enchereID'} element={<Rencherir/>} ></Route>
    </Routes>
  </BrowserRouter>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
