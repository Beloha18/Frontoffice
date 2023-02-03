package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Client {

    String client_id;

    String client_email;

    String client_mdp;

    String client_name;

    String client_forname;

    String client_num;

    String client_dtn;
}
