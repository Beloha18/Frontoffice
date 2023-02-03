package com.example.demo.controller;

import com.example.demo.repository.EnchereDetailRepository;
import com.example.demo.model.Enchere;
import com.example.demo.repository.EnchereAllrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/enchere")
public class EnchereController {
    @Autowired
    EnchereAllrepository enchereAllrepository;
    @Autowired
    EnchereDetailRepository enchereDetailrepository;
    //Findall
    @GetMapping("/listenchere")
    public List<Enchere> getAllenchere(){

        return (List<Enchere>) enchereAllrepository.findAll();
    }
    //find by id
    @GetMapping("/{id}")
    public ResponseEntity<Enchere> getEnchereById(@PathVariable(value="id") String EnchereId){
        Enchere enchere = enchereDetailrepository.findById(EnchereId).orElse(null);
            if(enchere == null) {
                System.out.println("Tsy miexiste");
                }
            return ResponseEntity.ok().body(enchere);
            }
}