package com.example.demo.dao;

import com.example.demo.Connection.Connexion;
import com.example.demo.model.Recharge;
import com.example.demo.model.Recharge2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RechargeDao extends bdd.BDD{
    public void insertrecharge(Recharge recharge) throws Exception
    {
        Connection connectpg=null;
        Statement statement=null;
        Connexion con=new Connexion();
        try
        {
            connectpg=con.getConnect();
            statement=connectpg.createStatement();

            String sql="INSERT INTO recharge(client_id_recharge,recharge_montant,recharge_date, recharge_etat) "
                    + "VALUES('"+recharge.getClient_id_recharge()+"','"+recharge.getRecharge_montant()+"',default,default);";
            System.out.println(sql);
            statement.executeUpdate(sql);

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            if(!statement.isClosed()){
                statement.close();
            }
            if(!connectpg.isClosed()){
                connectpg.close();
            }
        }
    }
    public ArrayList<Recharge2> getrecharge(String etat) throws Exception {
        ArrayList<Recharge2> recharges= new ArrayList<>();
        Recharge2 recharge= new Recharge2();
        Connection connectpg=null;
        Statement statement=null;
        Connexion con=new Connexion();
        ResultSet result=null;
        try{
            connectpg=con.getConnect();
            statement=connectpg.createStatement();
            String sql="SELECT*FROM recharge where recharge_etat='"+etat+"'";

            result= statement.executeQuery(sql);
            while(result.next())
            {

                recharge.setRecharge_id(result.getInt("recharge_id"));
                recharge.setRecharge_date(result.getString("recharge_date"));
                recharge.setClient_id_recharge(result.getString("client_id_recharge"));
                recharge.setRecharge_montant(result.getDouble("recharge_montant"));
                recharge.setRecharge_etat(result.getInt("recharge_etat"));
                recharges.add(recharge);
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
        return recharges;
    }
    public Boolean recharge(String client,Double montant){
        try{
            Recharge recharge=new Recharge();
            recharge.setClient_id_recharge(client);
            recharge.setRecharge_montant(montant);
            this.insertrecharge(recharge);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean confirmeRecharge(String recharge_id,String client_id,String montant){
        open();
        String sql = "update recharge set recharge_etat=1 where recharge_id='"+recharge_id+"'";
        String sql2 = "insert into transactions values ('"+client_id+"','"+montant+"',default,'recharge')";
        confirme(sql);
        confirme(sql2);
        return true;
    }
    public boolean AnnulerRecharge(String recharge_id){
        open();
        String sql = "update recharge set recharge_etat=-1 where recharge_id='"+recharge_id+"'";
        confirme(sql);
        return true;
    }

}
