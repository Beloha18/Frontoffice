package com.example.demo.service;

import com.example.demo.model.Utilisateur;
import com.example.demo.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@CrossOrigin
@Controller
public class UtilisateurService {
    @Autowired
    UtilisateurRepository ur;

    public ArrayList<Utilisateur> getAll() {
        ArrayList<Utilisateur> list = new ArrayList<>();
        for(Utilisateur u: ur.findAll()) {
            list.add(u);
        }
        return list;
    }
    private static String Sha1(String password) throws UnsupportedEncodingException {
        String sha1 = "";
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sha1;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    public  static String genererToken(String user){
        String name=user;
        LocalDateTime ajd=LocalDateTime.now();
        Integer Y=ajd.getYear();
        String taona=Y.toString();
        Integer m=ajd.getMonthValue();
        String volana=m.toString();
        Integer d=ajd.getDayOfMonth();
        String andro=d.toString();
        Integer min=ajd.getHour();
        String lera=min.toString();
        String hash="";
        try {
            String hash1=UtilisateurService.Sha1(name);
            String h2=UtilisateurService.Sha1(taona+volana+andro+lera);
            hash=UtilisateurService.Sha1(hash1+h2);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hash;
    }

    public Boolean check_token_si_valide(String nom){
        Boolean v=false;
        String token=this.genererToken(nom);
        ArrayList<Utilisateur> liste = this.getAll();
        for(int i=0; i<liste.size(); i++){
            if((liste.get(i).getClient_name().equals(nom)&&(liste.get(i).getToken().equals(token)))){
                v=true;
                break;
            }
        }
        return v;
    }

    public String log(String mail, String mdp){
        ArrayList<Utilisateur> liste=this.getAll();
        Boolean v=false;
        String t="null";
        for(int i=0; i<liste.size(); i++){
            if((liste.get(i).getClient_email().equals(mail))&&(liste.get(i).getClient_mdp().equals(mdp))){
                v=true;
                Utilisateur u=new Utilisateur();
                u.setClient_id(liste.get(i).getClient_id());
                u.setClient_name(liste.get(i).getClient_name());
                u.setClient_forname(liste.get(i).getClient_forname());
                u.setClient_dtn(liste.get(i).getClient_dtn());
                u.setClient_email(mail);
                u.setClient_mdp(mdp);
                String token=this.genererToken(mail);
                u.setToken(token);
                t=u.getToken();
                //urepo.save(u);
            }
        }
        return t;
    }



    public Boolean deco(String mail,String mdp){
        ArrayList<Utilisateur> liste=this.getAll();
        Boolean bool=false;
        for(int i=0; i<liste.size(); i++){
            if((liste.get(i).getClient_email().equals(mail)&&(liste.get(i).getClient_mdp().equals(mdp)))){
                bool=true;
                Utilisateur user=new Utilisateur();
                user.setClient_id(liste.get(i).getClient_id());
                user.setClient_name(liste.get(i).getClient_name());
                user.setClient_forname(liste.get(i).getClient_forname());
                user.setClient_dtn(liste.get(i).getClient_dtn());
                user.setClient_email(mail);
                user.setClient_mdp(mdp);
                ur.save(user);
            }
        }
        return bool;
    }


    public void inscription(Utilisateur v){
        ur.save(v);
    }





    public Connection getConnex() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://containers-us-west-51.railway.app:7850/railway?user=postgres&password=UTWKZH6lMlGhqO4BW2xB&ssl=false");
    }
    public Utilisateur logi(String mail, String mdp) throws SQLException{
        Utilisateur user = new Utilisateur();
        Boolean bool=false;
        String str="null";
        ResultSet rs=null;
        Connection conn =null;
        PreparedStatement ps=null;
        try {
            conn = getConnex();
            String sql = "select * from client where client_email = ? and client_mdp = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,mail);
            ps.setString(2,mdp);
            System.out.println(ps.toString());
            rs=ps.executeQuery();
            if(rs!=null) {
                bool=true;
                while(rs.next()) {
                    user.setClient_id(rs.getString("client_id"));
                    user.setClient_name(rs.getString("client_forname"));
                    user.setClient_forname(rs.getString("client_forname"));
                    String token=this.genererToken(mail);
                    user.setToken(token);
                    str=user.getToken();

                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(user.getClient_name());
        conn.close();
        return user;
    }

}
