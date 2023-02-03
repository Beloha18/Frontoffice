package com.example.demo.model;

import bdd.BDD;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
@NoArgsConstructor
public class Admin extends BDD {
    String id;
    String admin_email;
    String admin_mdp;

    public Admin(String id, String email, String mdp){
        this.id=id;
        this.admin_email=email;
        this.admin_mdp=mdp;
    }
    public Admin(String email, String mdp){
        this.admin_email=email;
        this.admin_mdp=mdp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public String getAdmin_mdp() {
        return admin_mdp;
    }

    public void setAdmin_mdp(String admin_mdp) {
        this.admin_mdp = admin_mdp;
    }

    public boolean login(String email,String mdp) throws SQLException,Exception{

        boolean val = false;
        String sql = "select * from Admin where admin_email='"+email+"' and admin_mdp='"+mdp+"'";
        ResultSet res = response(sql);
        int nnbr = 0;
        while(res.next()){
            nnbr++;
        }
        if (nnbr!=0){
            val = true;
        }

        return val;
    }
}

