package com.example.demo.dao;

public class AdminDAO {

   /* public int TestLogin(String login,String mdp)throws Exception{
        Admin admin=new Admin()
        String req="SELECT count(*) FROM Admin where login='"+login+"' AND mdp ='"+mdp+"'";

        Connexion con=new Connexion();
        Connection c=con.getConnect();
        Statement stm =c.createStatement();
        ResultSet rs=stm.executeQuery(req);
        rs.next();

        int nbr= rs.getInt(1);
        return nbr;
    }*/
    /*public Admin TestLogin(String login,String mdp)throws Exception{
        Admin admin=new Admin();

        String req="SELECT * FROM Admin where login='"+login+"' AND mdp ='"+mdp+"'";

        Connexion con=new Connexion();
        Connection c=con.getConnect();
        Statement stm =c.createStatement();
        ResultSet rs=stm.executeQuery(req);
        while (rs.next()){
                admin.setId(rs.getLong("id"));
                admin.setLogin(rs.getString("login"));
                admin.setMdp(rs.getString("mdp"));

        }
        return admin;
    }*/
}
