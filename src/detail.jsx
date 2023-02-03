import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import {url} from './url.js';

import './assets/css/styles.css';
import './assets/js/scripts.js';




function EnchereDetailPage() {
    const [enchere, setEnchere] = useState(null);
    const { enchereID } = useParams();

    
    useEffect(() => {
        async function fetchEnchere() {
            
        const response = await fetch(url+`enchere/${enchereID}`);
        const data = await response.json();
        setEnchere(data);
        }
        fetchEnchere();
    }, [enchereID]);

    const [liste, setItems] = useState([]);

  useEffect(() => {
    async function fetchData() {
      const response = await fetch(url+`propos/getpropof/${enchereID}`);
      const data = await response.json();
      setItems(data);
    }
    fetchData();
  }, []);

    if (!enchereID) {
        console.error("enchereID is missing from the URL");
        return <div>Error: enchereID is missing from the URL</div>;
      }

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
                        <h1 class="mt-4">Dashboard</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Dashboard</li>
                        </ol>
                        <div class="row">
                            <div class="col-xl-4">
                             <div class="card mb-4">
                                    <div class="card-header">
                                      <h3>Infomration generale</h3>
                                    </div>
                                    <div class="card-body">
                                    {enchere && (
                            <>
                            <label htmlFor="">intituler :</label>
                            <h2>{enchere.enchere_name}</h2>
                            <label htmlFor="">description</label>
                            <p>{enchere.enchere_desc}</p>
                            <label htmlFor="">publieur : </label>
                            <p>{enchere.client_id_enchere}</p>
                            <label htmlFor="">prix de depart : </label>
                            <p>{enchere.enchere_prix_depart}</p>
                            <label htmlFor="">durre</label>
                            <p>{enchere.duree_id_enchere} heures</p>
                            </>
                            )}
                                    </div>
                                </div>
                              </div>
                        <div>
                    
                    </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                historique des proposition
                            </div>
                            <div class="card-body">
                                        <table class="table">
                                            <tr>
                                                <th>id personne</th>
                                                <th>prix</th>
                                                <th>date de proposition</th>
                                            </tr>
                                            {liste.map(item => {
                                                    return (
                                                        <tr>
                                                            <td>{item.client_id_prop}</td>
                                                            <td>{item.rencherir}</td>
                                                            <td>{item.prop_date}</td>
                                                        </tr>
                                                    );
                                                return null;
                                                })}

                                        </table>
                            </div>
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
        <div>
    </div>
    </body>
        
    );
}

export default EnchereDetailPage;