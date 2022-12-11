package com.example.complaintApp_Backend.controller;

import com.example.complaintApp_Backend.dao.Userdao;
import com.example.complaintApp_Backend.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class Usercontroller {
    @Autowired
    private Userdao dao;

    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public String HomePage(){
        return "Home Page";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userReg", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> UserRegistration(@RequestBody UserInfo u){
        HashMap<String, String> user = new HashMap<>();
        List<UserInfo> result = (List<UserInfo>) dao.FindUser(u.getUsername());
        if(result.size() !=0){
            user.put("status","failed");
        }else{
            dao.save(u);
            user.put("status","success");
        }
        return user;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userLogin", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> UserLogin(@RequestBody UserInfo u){
        List<UserInfo> result = (List<UserInfo>) dao.UserLogin(u.getUsername(), u.getPassword());
        HashMap<String, String> user = new HashMap<>();
        if(result.size() == 0){
            user.put("status","failed");
        }else{
            user.put("status","success");
        }
        return user;
    }



}
