import React, { useState, useEffect } from 'react';
import { Link } from "react-router-dom";
import {url} from './url.js';

const ListPage = () => {
    const [enchere_name, setenchere_name] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");  

  const [items, setItems] = useState([]);

  const requestBody = {
    'enchere_name': enchere_name,
  };

  useEffect(() => {
    async function fetchData() {
      const response = await fetch(url+'enchere/enchers', {
            method: "POST",
            headers: {
            "Content-Type": "application/json",
            },
            body: JSON.stringify(requestBody),
        });
      const data = await response.json();
      setItems(data);
    }
    fetchData();
  }, []);
   function aff(){
    return (
        <div>
            <form onSubmit={aff}>
                <div>
                    <label htmlFor="username">enchere_name:</label>
                    <input type="text" id="enchere_name" value={enchere_name} onChange={(event) => setenchere_name(event.target.value)} />
                </div>
                <button type="submit">Login</button>
            </form>
        <p>liste des enchere actif {url+'enchere/listenchere'} </p>
        <ul>
          {items.map(item => {
            if (item.enchere_status === 0) {
              return (
                <li key={item.enchere_id}>
                  <h3>{item.enchere_name}</h3>
                  <p>{item.enchere_desc}</p>
                  <p>{item.client_id_enchere}</p>
                  <p>{item.enchere_prix_depart}</p>
                  <p>{item.duree_id_enchere}</p>
                  <p><Link to={`/detail/${item.enchere_id.toString()}`}><button router-link>voir details</button></Link></p>
                </li>
              );
            }
            return null;
          })}
        </ul>
    
    
    </div>
      );
   };
  return aff();
};

export default ListPage;