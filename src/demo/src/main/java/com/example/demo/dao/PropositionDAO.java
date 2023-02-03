package com.example.demo.dao;

import com.example.demo.Connection.Connexion;
import com.example.demo.model.Proposition;
import com.example.demo.model.Transactions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PropositionDAO extends bdd.BDD{
    public Proposition getPropositionFinal() throws Exception {

        Proposition proposition=null;
        Connection connectpg=null;
        Statement statement=null;
        Connexion con=new Connexion();
        ResultSet result=null;
        try{
            connectpg=con.getConnect();
            statement=connectpg.createStatement();
            String sql="SELECT*FROM proposition order by prop_date limit 1";
            result= statement.executeQuery(sql);
            while(result.next())
            {
                proposition=new Proposition();
                proposition.setClient_id_prop(result.getString("client_id_prop"));
                proposition.setEnchere_id_prop(result.getString("enchere_id_prop"));
                proposition.setRencherir(result.getDouble("rencherir"));
                proposition.setProp_date(result.getString("prop_date"));
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
        return proposition;
    }
    public Boolean testrencherir(String idclient, String idenchere, double newprice) throws Exception {
        Proposition proposition=this.getPropositionFinal();
        String clientprop=proposition.getClient_id_prop();
        Double  rencherir=proposition.getRencherir();
        Proposition newprop=new Proposition();
        TransactionsDao transactionsDao=new TransactionsDao();
        Transactions transaction=new Transactions();
        Transactions transaction1=new Transactions();
        if(proposition.getRencherir() < newprice){
            newprop.setClient_id_prop(idclient);newprop.setEnchere_id_prop(idenchere);newprop.setRencherir(newprice);
            this.insertionproposition(newprop);
            transaction.setClient_id_trans(clientprop);transaction.setTrans_montant(rencherir);transaction.setTrans_method("plus");
            transaction1.setClient_id_trans(idclient);transaction1.setTrans_montant(newprice);transaction1.setTrans_method("moins");
            transactionsDao.inserttransact(transaction);
            transactionsDao.inserttransact(transaction1);
            return true;
        }
        else {
            System.out.println("augmenter votre prix");
            return false;
        }

    }
    public void insertionproposition(Proposition proposition) throws Exception
    {
        Connection connectpg=null;
        Statement statement=null;
        Connexion con=new Connexion();
        try
        {
            connectpg=con.getConnect();
            statement=connectpg.createStatement();
            String sql="INSERT INTO proposition(client_id_prop,enchere_id_prop,rencherir, prop_date) "
                    + "VALUES('"+proposition.getClient_id_prop()+"','"+proposition.getEnchere_id_prop()+"','"+proposition.getRencherir()+"',default);";
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

    }

