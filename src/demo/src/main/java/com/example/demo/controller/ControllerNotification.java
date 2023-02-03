package com.example.demo.controller;

import com.example.demo.dao.NotificationDao;
import com.example.demo.model.Notification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/notif")
public class ControllerNotification {
    NotificationDao notificationDao=new NotificationDao();
    @PostMapping("/sendmessage")
    public ResponseEntity<Boolean> sendMessage(@RequestParam (name = "client_id_notif") String idclient, @RequestParam (name = "message") String enchere) throws Exception {
        Boolean testsendMessage = notificationDao.sendMessage(idclient,enchere);
        return ResponseEntity.ok(testsendMessage);
    }
    @GetMapping("/getMessage/{client}")
    public ResponseEntity<ArrayList<Notification>> getMessage(@PathVariable String client) throws Exception {
        ArrayList<Notification> notifications= notificationDao.getNotifparcl(client);
        return ResponseEntity.ok(notifications);
    }
}
