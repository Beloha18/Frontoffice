import React, { useState, useEffect } from 'react';
import { Link } from "react-router-dom";
import {url} from './url.js';

import './assets/css/styles.css';
import './assets/js/scripts.js';
import mainLogo from'./s.png';



const ListPage = () => {
  const [items, setItems] = useState([]);

  useEffect(() => {
    async function fetchData() {
      const response = await fetch(url+'enchere/listenchere');
      const data = await response.json();
      setItems(data);
    }
    fetchData();
  }, []);

  return (
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand ps-3" href="index.html">E-ezaka Enchere</a>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Interface</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Layouts
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                Pages
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">create with \/ by:</div>
                        E-ezaka
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Bienvenue</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">la liste des enchere en cours</li>
                        </ol>
                        <div class="row">

                        {items.map(item => {
                          if (item.enchere_status === 0) {
                            return (

                              <div class="col-xl-4">
                                <div class="card mb-4">
                                    <div class="card-header">
                                      <h3>{item.enchere_name}</h3>
                                    </div>
                                    <div class="card-body">
                                    <img  src={mainLogo} /><br></br>
                                      <label htmlFor="">description : </label>
                                        <p>{item.enchere_desc}</p>
                                        <label htmlFor="">origine : </label>
                                        <p>{item.client_id_enchere}</p>
                                        <label htmlFor="">prix de depart</label>
                                        <p>{item.enchere_prix_depart}</p>
                                        <label htmlFor="">durre de l enchere</label>
                                        <p>{item.duree_id_enchere} heure(s)</p>
                                        <p><Link to={`/rencherir/${item.enchere_id.toString()}`}><button class="btn btn-primary" router-link>voir details</button></Link></p>
                                    </div>
                                </div>
                              </div>
                              
                            );
                          }
                          return null;
                        })}

                            
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; E-ezaka 2023</div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
    </body>











    
  );
};

export default ListPage;