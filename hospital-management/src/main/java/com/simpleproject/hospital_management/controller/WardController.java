package com.simpleproject.hospital_management.controller;


import com.simpleproject.hospital_management.model.Ward;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
@RestController
@RequestMapping("/ward/apis")
public class WardController {
    // Assignment
    HashMap<Integer, Ward> wardDb=new HashMap<>();

     @RequestMapping("/save")
    public String SaveWardDetails(@RequestBody Ward inputWardRequest){
        wardDb.put(inputWardRequest.getWardNo(),inputWardRequest);
        return "Ward information save successfully";
    }

    @RequestMapping("/findAll")
    public HashMap<Integer, Ward> allWardInfo(){
         return wardDb;
    }
   @RequestMapping("/wardInfo/{wardNo}")
    public Ward getWardInfoByWardNo(@PathVariable int wardNo){
         Ward ward=wardDb.get(wardNo);
         return ward;
    }
    @RequestMapping("/delete/{wardNo}")
    public String deleteWardByWardNo(@PathVariable int wardNo){
         wardDb.remove(wardNo);
         return "ward Information deleted Successfully By wardNo :"+wardNo;
    }
}
