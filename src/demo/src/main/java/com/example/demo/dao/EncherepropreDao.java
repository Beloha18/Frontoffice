package com.example.demo.dao;

import com.example.demo.Connection.Connexion;
import com.example.demo.model.Historique;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EncherepropreDao {
    public ArrayList<Historique> getEncherepropreencours(String client) throws Exception {
        ArrayList<Historique> historiques=new ArrayList<Historique>();
        Connection connectpg=null;
        Statement statement=null;
        Connexion con=new Connexion();
        ResultSet result=null;
        try{
            connectpg=con.getConnect();
            statement=connectpg.createStatement();
            String sql="SELECT enchere_name,enchere_date,enchere_desc,client_id_enchere,enchere_prix_depart,enchere_status,duree FROM enchereencours where client_id_enchere='"+client+"' group by client_id_enchere,enchere_name,enchere_date,enchere_desc,enchere_prix_depart,enchere_status,duree";
            result= statement.executeQuery(sql);
            while(result.next())
            {
                Historique hito=new Historique();

                hito.setEnchere_name(result.getString("enchere_name"));
                hito.setEnchere_date(result.getString("enchere_date"));hito.setEnchere_desc(result.getString("enchere_desc"));hito.setClient_id_enchere(result.getString("client_id_enchere"));
                hito.setEnchere_prix_depart(result.getDouble("enchere_prix_depart"));
                hito.setEnchere_status(result.getInt("enchere_status"));hito.setDuree(result.getDouble("duree"));

                historiques.add(hito);
            }
        }
        catch(Exception e)
        {
            throw e;
        }
        finally{
            if(!statement.isClosed()){
                statement.close();
            }
            if(!result.isClosed()){
                result.close();
            }
            if(!connectpg.isClosed()){
                connectpg.close();
            }
        }
        return historiques;
    }
    public ArrayList<Historique> getEnchereproprefait(String client) throws Exception {
        ArrayList<Historique> historiques=new ArrayList<Historique>();
        Connection connectpg=null;
        Statement statement=null;
        Connexion con=new Connexion();
        ResultSet result=null;
        try{
            connectpg=con.getConnect();
            statement=connectpg.createStatement();
            String sql="SELECT enchere_name,enchere_date,enchere_desc,client_id_enchere,enchere_prix_depart,enchere_status,duree,client_name,rencherir FROM encherefait where client_id_enchere='"+client+"' group by client_id_enchere,enchere_name,enchere_date,enchere_desc,enchere_prix_depart,enchere_status,duree,client_name,rencherir";
            result= statement.executeQuery(sql);
            while(result.next())
            {
                Historique hito=new Historique();

                hito.setRencherir(result.getDouble("rencherir"));hito.setEnchere_name(result.getString("enchere_name"));
                hito.setEnchere_date(result.getString("enchere_date"));hito.setEnchere_desc(result.getString("enchere_desc"));hito.setClient_id_enchere(result.getString("client_id_enchere"));
                hito.setEnchere_prix_depart(result.getDouble("enchere_prix_depart"));
                hito.setEnchere_status(result.getInt("enchere_status"));hito.setDuree(result.getDouble("duree"));
                hito.setClient_name(result.getString("client_name"));
                historiques.add(hito);
            }
        }
        catch(Exception e)
        {
            throw e;
        }
        finally{
            if(!statement.isClosed()){
                statement.close();
            }
            if(!result.isClosed()){
                result.close();
            }
            if(!connectpg.isClosed()){
                connectpg.close();
            }
        }
        return historiques;
    }
}
