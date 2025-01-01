package com.simpleproject.hospital_management.controller;


import com.simpleproject.hospital_management.model.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/patient/apis")
public class PatientController {
    // Assignment
    HashMap<Integer, Patient> patientDb=new HashMap<>();
    @PostMapping("/save")
    public String savePatient(@RequestBody Patient inputPatientRequest){
        patientDb.put(inputPatientRequest.getId(),inputPatientRequest);
        return "patient save successfully";
    }

    @GetMapping("/findAll")
    public HashMap<Integer, Patient> findAllPatient(){
        return patientDb;
    }

    @GetMapping("/find/{id}")
    public Patient findPatientById(@PathVariable int id){
        Patient patient=patientDb.get(id);
        return  patient;
    }
}
