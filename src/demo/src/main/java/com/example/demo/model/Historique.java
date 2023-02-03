package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Historique {
    String client_id_prop;
    String enchere_id_prop;
    double rencherir;
    String prop_date;
    String enchere_name;
    String enchere_date;
    String enchere_desc;
    String client_id_enchere;
    double enchere_prix_depart;
    int enchere_status;
    double duree;
    String client_name;
    String client_forname;
}
