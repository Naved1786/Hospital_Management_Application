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
    @DeleteMapping("/delete/{id}")
    public String deletePatientById(@PathVariable int id){
        patientDb.remove(id);
        return "Patient Deleted successfully By id : "+id;
    }
    @PutMapping("/update/{id}")
    public String updatePatient(@PathVariable int id,@RequestBody Patient updatePatientRequest){
        // if the patient is present or not
        // if patient is present the  update else not
        Patient patient=patientDb.get(id);
        if(patient!=null){
            patientDb.put(updatePatientRequest.getId(), updatePatientRequest);
            return "Patient is updated successfully";
        }else {
            return "Patient is not found to update";
        }
    }
}
