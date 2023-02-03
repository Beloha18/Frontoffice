package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Proposition extends bdd.BDD {
    String client_id_prop;
    String enchere_id_prop;
    double rencherir;
    String prop_date;

    public Proposition(String client_id_prop, String enchere_id_prop, double rencherir) {
        this.client_id_prop = client_id_prop;
        this.enchere_id_prop = enchere_id_prop;
        this.rencherir = rencherir;
    }
    public ArrayList<Proposition> getPropositionsOf(String enchere_id){
        String condition = "enchere_id_prop='"+enchere_id+"'";
        ArrayList<String[]> sql = select(condition);
        ArrayList<Proposition> newlist = new ArrayList<Proposition>();
        for (String[] data : sql) {
            Proposition prop = new Proposition(data[0], data[1], Double.parseDouble(data[2]), data[3]);
            newlist.add(prop);
        }
        return newlist;
    }
}
