package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table (name  = "enchere" )
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Enchere{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String enchere_id;
    @Column(name = "enchere_name")
    public String enchere_name;
    @Column(name = "enchere_date")
    public Timestamp enchere_date;
    @Column(name = "enchere_desc")
    public String enchere_desc;
    @Column(name = "client_id_enchere")
    public String client_id_enchere;
    @Column(name = "enchere_prix_depart")
    public double enchere_prix_depart;
    @Column(name = "duree_id_enchere")
    public int duree_id_enchere;
    @Column(name = "enchere_status")
    public int enchere_status;
    public Enchere(String enchere_name, Timestamp enchere_date, String enchere_desc, String client_id_enchere, double enchere_prix_depart, int duree_id_enchere, int enchere_status) {
        this.enchere_name = enchere_name;
        this.enchere_date = enchere_date;
        this.enchere_desc = enchere_desc;
        this.client_id_enchere = client_id_enchere;
        this.enchere_prix_depart = enchere_prix_depart;
        this.duree_id_enchere = duree_id_enchere;
        this.enchere_status = enchere_status;
    }
}
