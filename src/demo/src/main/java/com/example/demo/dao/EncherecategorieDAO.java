package com.example.demo.dao;

import com.example.demo.Connection.Connexion;
import com.example.demo.model.Categorie;
import com.example.demo.model.Encherecategorie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EncherecategorieDAO {
    public ArrayList<Encherecategorie> getEnchereby(ArrayList<Categorie> listcat) throws Exception {
        ArrayList<Encherecategorie> enchere=new ArrayList<Encherecategorie>();
        Connection connectpg=null;
        Statement statement=null;
        Connexion con=new Connexion();
        ResultSet result=null;
        try{
            connectpg=con.getConnect();
            statement=connectpg.createStatement();
            String sql="select distinct(enchere_id_catench),categorie_id_catench,duree,enchere_name,enchere_date,enchere_desc,client_id_enchere,client_name,client_forname,enchere_prix_depart,enchere_status,label from encherecategorieselect distinct(enchere_id_catench),enchere.* from encherecategorie join enchere on encherecategorie.enchere_id_catench = enchere.enchere_id where (";
        for (int i=0;i<listcat.size();i++){
             sql+="label='"+listcat.get(i).getLabel()+"'";
             if(i<listcat.size()-1){
                    sql+=" or ";
             }
        }
        sql+=")";
            System.out.println(sql);
            result= statement.executeQuery(sql);

            while(result.next())
            {
                Encherecategorie enc =new Encherecategorie();
                enc.setEnchere_id_catench(result.getString("enchere_id_catench"));
                enc.setCategorie_id_catench(result.getInt("categorie_id_catench"));
                enc.setDuree(result.getDouble("duree"));
                enc.setEnchere_name(result.getString("enchere_name"));
                enc.setEnchere_date(result.getString("enchere_date"));
                enc.setEnchere_desc(result.getString("enchere_desc"));
                enc.setClient_id_enchere(result.getString("client_id_enchere"));
                enc.setClient_name(result.getString("client_name"));
                enc.setClient_forname(result.getString("client_forname"));
                enc.setEnchere_prix_depart(result.getDouble("enchere_prix_depart"));
                enc.setEnchere_status(result.getInt("enchere_status"));
                enc.setLabel(result.getString("label"));
                enchere.add(enc);

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
        return enchere;
    }
}
