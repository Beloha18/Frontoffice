package com.example.demo.controller;

import com.example.demo.dao.RechargeDao;
import com.example.demo.model.Recharge2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/recharge")
public class ControllerRecharge {
    RechargeDao rechargeDao=new RechargeDao();
    @PostMapping("/arecharger")
    public ResponseEntity<Boolean> recharge(@RequestParam(name = "client_id_recharge") String idclient, @RequestParam (name = "recharge_montant") Double montant) throws Exception {
        Boolean test=rechargeDao.recharge(idclient,montant);
            return ResponseEntity.ok(test);
    }

    @GetMapping("/liste_recharger/{etat}")
    public ArrayList<Recharge2> recharge(@PathVariable String etat) throws Exception {
        ArrayList<Recharge2> list = rechargeDao.getrecharge(etat);
        return list;
        //return ResponseEntity.ok(list);
    }
    @PostMapping("/confirm/{recharge_id}/{client_id_recharge}/{recharge_montant}")
    public ResponseEntity<Boolean> confirm(@PathVariable String recharge_id,@PathVariable String client_id_recharge,@PathVariable String recharge_montant){
        Boolean test=rechargeDao.confirmeRecharge(recharge_id,client_id_recharge,recharge_montant);
        return  ResponseEntity.ok(test);
    }
    @PostMapping("/decline/{recharge_id}")
    public ResponseEntity<Boolean> decliner(@PathVariable String recharge_id){
        Boolean test=rechargeDao.AnnulerRecharge(recharge_id);
        return  ResponseEntity.ok(test);
    }
}
