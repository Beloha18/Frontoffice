import React, { useState } from "react";
import {url} from './url.js';

import './assets/css/styles.css';
import './assets/js/scripts.js';

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const handleSubmit = async (event) => {
    event.preventDefault();
    const result = await login(username, password);
    if (!result) {
      setError("Informations d'identification incorrectes");
      alert("tsy mety");
    } else {
      // Naviguer vers la page d'accueil ou une autre page en cas de succès
    }
  };

  const login = async (username, password) => {
    const response = await fetch(url+"login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ username, password }),
    });
    if (response.ok) {
      return true;
    } else {
      return false;
    }
  };
  return (
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Login</h3></div>
                                    <div class="card-body">
                                        <form onSubmit={handleSubmit}>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" type="text"
                                                  id="username"
                                                  value={username}
                                                  onChange={(event) => setUsername(event.target.value)} placeholder="nom d utilisateur"/>
                                                <label for="username">nom d utilisateur</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" type="password"
                                                  id="password"
                                                  value={password}
                                                  onChange={(event) => setPassword(event.target.value)} placeholder="mot de passe"/>
                                                <label for="password">mot de passe</label>
                                            </div>
                                            <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                            <input type="submit" class="btn btn-primary" value="se connecter"/>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small"><a href="register.html">Need an account? Sign up!</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2022</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
    </body>

    
  );
}

export default Login;
