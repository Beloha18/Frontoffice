package com.example.demo.dao;

import com.example.demo.Connection.Connexion;
import com.example.demo.model.Historique;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class HistoriqueDao {
    public ArrayList<Historique> getEnchereOencoursf(String client) throws Exception {
        ArrayList<Historique> historiques=new ArrayList<Historique>();
        Connection connectpg=null;
        Statement statement=null;
        Connexion con=new Connexion();
        ResultSet result=null;
        try{
            connectpg=con.getConnect();
            statement=connectpg.createStatement();
            String sql="SELECT*FROM enchereencours where client_id_prop='"+client+"'order by prop_date ";
            result= statement.executeQuery(sql);
            while(result.next())
            {
                Historique hito=new Historique();
                hito.setClient_id_prop(result.getString("client_id_prop"));hito.setEnchere_id_prop(result.getString("enchere_id_prop"));
                hito.setRencherir(result.getDouble("rencherir"));hito.setProp_date(result.getString("prop_date"));hito.setEnchere_name(result.getString("enchere_name"));
                hito.setEnchere_date(result.getString("enchere_date"));hito.setEnchere_desc(result.getString("enchere_desc"));hito.setClient_id_enchere(result.getString("client_id_enchere"));
                hito.setEnchere_prix_depart(result.getDouble("enchere_prix_depart"));
                hito.setEnchere_status(result.getInt("enchere_status"));hito.setDuree(result.getDouble("duree"));
                hito.setClient_name(result.getString("client_name")); hito.setClient_forname(result.getString("client_forname"));
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

    public ArrayList<Historique> gettousenchere(String client) throws Exception {
        ArrayList<Historique> historiques=new ArrayList<Historique>();
        Connection connectpg=null;
        Statement statement=null;
        Connexion con=new Connexion();
        ResultSet result=null;
        try{
            connectpg=con.getConnect();
            statement=connectpg.createStatement();
            String sql="SELECT*FROM tousenchere where client_id_prop='"+client+"'order by prop_date ";
            result= statement.executeQuery(sql);
            while(result.next())
            {
                Historique hito=new Historique();
                hito.setClient_id_prop(result.getString("client_id_prop"));hito.setEnchere_id_prop(result.getString("enchere_id_prop"));
                hito.setRencherir(result.getDouble( "rencherir"));hito.setProp_date(result.getString("prop_date"));hito.setEnchere_name(result.getString("enchere_name"));
                hito.setEnchere_date(result.getString("enchere_date"));hito.setEnchere_desc(result.getString("enchere_desc"));hito.setClient_id_enchere(result.getString("client_id_enchere"));
                hito.setEnchere_prix_depart(result.getDouble("enchere_prix_depart"));
                hito.setEnchere_status(result.getInt("enchere_status"));hito.setDuree(result.getDouble("duree"));
                hito.setClient_name(result.getString("client_name")); hito.setClient_forname(result.getString("client_forname"));
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
    public ArrayList<Historique> getEncherefaitof(String client) throws Exception {
        ArrayList<Historique> historiques=new ArrayList<Historique>();
        Connection connectpg=null;
        Statement statement=null;
        Connexion con=new Connexion();
        ResultSet result=null;
        try{
            connectpg=con.getConnect();
            statement=connectpg.createStatement();
            String sql="SELECT*FROM encherefait where client_id_prop='"+client+"'order by prop_date ";
            result= statement.executeQuery(sql);
            while(result.next())
            {
                Historique hito=new Historique();
                hito.setClient_id_prop(result.getString("client_id_prop"));hito.setEnchere_id_prop(result.getString("enchere_id_prop"));
                hito.setRencherir(result.getDouble("rencherir"));hito.setProp_date(result.getString("prop_date"));hito.setEnchere_name(result.getString("enchere_name"));
                hito.setEnchere_date(result.getString("enchere_date"));hito.setEnchere_desc(result.getString("enchere_desc"));hito.setClient_id_enchere(result.getString("client_id_enchere"));
                hito.setEnchere_prix_depart(result.getDouble("enchere_prix_depart"));
                hito.setEnchere_status(result.getInt("enchere_status"));hito.setDuree(result.getDouble("duree"));
                hito.setClient_name(result.getString("client_name")); hito.setClient_forname(result.getString("client_forname"));
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
