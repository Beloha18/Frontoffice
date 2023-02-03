package com.example.demo.dao;

import com.example.demo.Connection.Connexion;
import com.example.demo.model.Transactions;

import java.sql.Connection;
import java.sql.Statement;

public class TransactionsDao {
    public void inserttransact(Transactions trans) throws Exception
    {
        Connection connectpg=null;
        Statement statement=null;
        Connexion con=new Connexion();
        try
        {
            connectpg=con.getConnect();
            statement=connectpg.createStatement();

            String sql="INSERT INTO transactions(client_id_trans,trans_montant,trans_date, trans_method) "
                    + "VALUES('"+trans.getClient_id_trans()+"','"+trans.getTrans_montant()+"',default,'"+trans.getTrans_method()+"');";
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
}
