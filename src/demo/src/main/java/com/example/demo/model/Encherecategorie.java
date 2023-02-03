package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Encherecategorie {
    String enchere_id_catench;
    int categorie_id_catench;
    double duree;
    String enchere_name;
    String enchere_date;
    String enchere_desc;
    String client_id_enchere;
    String client_name;
    String client_forname;
    double enchere_prix_depart;
    int enchere_status;
    String label;

}
