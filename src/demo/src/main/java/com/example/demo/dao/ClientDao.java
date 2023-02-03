package com.example.demo.dao;

import com.example.demo.model.Client;
import javax.persistence.*;
import java.util.List;

public class ClientDao {

    List<Client> getAllClient(){
        List<Client> clients=null;
        EntityManager entityManager = null;
        clients= entityManager.createNativeQuery("select * from client", Client.class)
                .getResultList();
        return clients;
    }
}
