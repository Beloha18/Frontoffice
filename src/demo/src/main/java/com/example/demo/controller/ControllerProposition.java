package com.example.demo.controller;

import com.example.demo.dao.PropositionDAO;
import com.example.demo.model.Proposition;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/propos")
@CrossOrigin
public class ControllerProposition {
    PropositionDAO propositionDAO= new PropositionDAO();
    Proposition proposition= new Proposition();
    @GetMapping ("/getpropfinal")
    public ResponseEntity<Proposition> getPropo() throws Exception {
        Proposition proposition=propositionDAO.getPropositionFinal();
        return ResponseEntity.ok(proposition);
    }
    @PostMapping("/rencherir/{idclient}/{idenchere}/{newprice}")
    public ResponseEntity<Boolean> rencherir(@PathVariable String idclient,@PathVariable String idenchere ,@PathVariable double newprice) throws Exception {
        Boolean testrencherir = propositionDAO.testrencherir(idclient,idenchere,newprice);
        return ResponseEntity.ok(testrencherir);
    }
    @GetMapping("/getpropof/{enchere_id}")
    public ResponseEntity<ArrayList<Proposition>> getPropositionsOf(@PathVariable String enchere_id){
        ArrayList<Proposition> list= proposition.getPropositionsOf(enchere_id);
        return ResponseEntity.ok(list);
    }
}