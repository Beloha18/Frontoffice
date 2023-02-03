package com.example.demo.controller;

import com.example.demo.model.Enchere;
import com.example.demo.repository.AjoutEnchere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enregistrer")
public class NewEnchereController {
    @Autowired
    AjoutEnchere ajoutEnchereRepo;
    @PostMapping("/enregistrerenchere")
    public String registerenchere( @RequestBody Enchere enchere) {
        ajoutEnchereRepo.save(enchere);
        return "succes";
    }
}
