package com.example.demo.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    Connection con;
    public Connexion()throws Exception{
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://containers-us-west-51.railway.app:7850/railway","postgres","UTWKZH6lMlGhqO4BW2xB");

        }
        catch(Exception e){
            e.printStackTrace();

        }
    }
    public Connection getConnect()throws Exception{
        return con;
    }
}
