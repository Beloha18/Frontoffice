package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String client_id;
    @Column(name = "client_email")
    public String client_email;
    @Column(name = "client_mdp")
    public String client_mdp;
    @Column(name = "client_name")
    public String client_name;
    @Column(name = "client_forname")
    public String client_forname;
    @Column(name = "client_num")
    public double client_num;
    @Column(name = "client_dtn")
    public Date client_dtn;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Utilisateur(String token) {
        this.token = token;
    }

    @Column(name = "token")
    public String token;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_email() {
        return client_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    public String getClient_mdp() {
        return client_mdp;
    }

    public void setClient_mdp(String client_mdp) {
        this.client_mdp = client_mdp;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_forname() {
        return client_forname;
    }

    public void setClient_forname(String client_forname) {
        this.client_forname = client_forname;
    }

    public double getClient_num() {
        return client_num;
    }

    public void setClient_num(double client_num) {
        this.client_num = client_num;
    }

    public Date getClient_dtn() {
        return client_dtn;
    }

    public void setClient_dtn(Date client_dtn) {
        this.client_dtn = client_dtn;
    }
}
