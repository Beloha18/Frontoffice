package com.example.demo.dao;

import com.example.demo.Connection.Connexion;
import com.example.demo.model.Notification;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class NotificationDao {
    public void insertionnotif(Notification notf) throws Exception
    {
        Connection connectpg=null;
        Statement statement=null;
        Connexion con=new Connexion();
        try
        {
            connectpg=con.getConnect();
            statement=connectpg.createStatement();
            String sql="INSERT INTO notification(client_id_notif,date_notif,message, date_vue) "
                    + "VALUES('"+notf.getClient_id_notif()+"',default,'"+notf.getMessage()+"',default);";
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
    public Boolean sendMessage(String client,String enchaire){
        try{
            Notification nt=new Notification();
            nt.setClient_id_notif(client);
            nt.setMessage(enchaire);
            this.insertionnotif(nt);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public ArrayList<Notification> getNotifparcl(String client) throws Exception {

        ArrayList<Notification> notifications=new ArrayList<Notification>();
        Connection connectpg=null;
        Statement statement=null;
        Connexion con=new Connexion();
        ResultSet result=null;
        try{
            connectpg=con.getConnect();
            statement=connectpg.createStatement();
            String sql="SELECT*FROM notification where client_id_notif='"+client+"'";
            System.out.println(sql);
            result= statement.executeQuery(sql);
            while(result.next())
            {
               Notification notification=new Notification();
                notification.setClient_id_notif(result.getString("client_id_notif"));
                notification.setDate_notif(result.getString("date_notif"));
                notification.setMessage(result.getString("message"));
                notification.setDate_vue(result.getString("date_vue"));
                notifications.add(notification);
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
        return notifications;
    }
}
