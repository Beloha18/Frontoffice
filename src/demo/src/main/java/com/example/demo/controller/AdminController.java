package com.example.demo.controller;

import com.example.demo.model.Admin;
import org.springframework.web.bind.annotation.*;
import bdd.BDD;

@RestController
@CrossOrigin
@RequestMapping("/Admin")
public class AdminController {
    @GetMapping("/loginbackoff")
    public boolean logAdmin(@RequestParam(name = "admin_email") String email, @RequestParam(name = "admin_mdp") String mdp) throws Exception {
        Admin a =new Admin();
        boolean b = a.login(email, mdp);
        return b;
    }

    @GetMapping("/insertdurre")
    public void insertdurre(@RequestParam(name = "durre") String durre){
        String requete = "insert into duree values (default,'"+durre+"')";
        BDD bdd = new BDD();
        bdd.confirme(requete);
    }
    @GetMapping("/insertcatecorie")
    public void insertcatecorie(@RequestParam(name = "categorie") String categorie){
        String requete = "insert into categorie values (default,'"+categorie+"')";
        BDD bdd = new BDD();
        bdd.confirme(requete);
    }
}

