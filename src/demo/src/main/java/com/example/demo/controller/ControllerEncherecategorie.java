package com.example.demo.controller;

import com.example.demo.dao.EncherecategorieDAO;
import com.example.demo.model.Categorie;
import com.example.demo.model.Encherecategorie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/enchere")
public class ControllerEncherecategorie {


    EncherecategorieDAO encherecategorieDAO =new EncherecategorieDAO();

    @PostMapping("/enchers")
    public ResponseEntity<ArrayList<Encherecategorie>> listenchere(@RequestBody ArrayList<Categorie> list) throws Exception {
                System.out.println("tonga");
                ArrayList<Encherecategorie> encherecategories= encherecategorieDAO.getEnchereby(list);
                return ResponseEntity.ok(encherecategories);
    }
}
