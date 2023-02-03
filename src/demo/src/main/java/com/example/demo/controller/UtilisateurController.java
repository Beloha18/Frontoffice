package com.example.demo.controller;

import com.example.demo.model.Utilisateur;
import com.example.demo.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
@RestController
@CrossOrigin
@Controller
@Service
public class UtilisateurController {

    @Autowired
    UtilisateurService userv;

    @GetMapping("/login")
    public Utilisateur login(@RequestParam(value = "mail")String mail, @RequestParam(value = "motdepasse")String mdp) throws SQLException {
        return userv.logi(mail, mdp);

    }

    @GetMapping("/deco")
    public Boolean deco(@RequestParam (value = "mail")String mail,@RequestParam(value = "motdepasse")String mdp) {
        return userv.deco(mail, mdp);

    }
    @GetMapping("/token")
    public String genererTkn(@RequestParam(value = "mail")String mail){
        return userv.genererToken(mail);
    }

    @GetMapping("/check")
    public Boolean ckeck(@RequestParam(value = "nom")String mail){
        return userv.check_token_si_valide(mail);

    }

    @PostMapping("/inscrire")
    public void inscrire(@RequestBody Utilisateur e){
        userv.inscription(e);
    }
}
