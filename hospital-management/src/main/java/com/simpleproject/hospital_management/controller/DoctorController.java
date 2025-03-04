package com.simpleproject.hospital_management.controller;

import com.simpleproject.hospital_management.model.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/doctor/apis")
public class DoctorController {
    // here we are using hashmap to perform database operations
    HashMap<Integer, Doctor> doctorDb=new HashMap<>();

    // 1:{1,ajay,ajay@gmail.com,9989899833,cardiologist}
    // 2:{2,vijay,vijay@gmail.com,98342233,cardiologist}
    // 3:{3,sanjay,sanjay@gmail.com,9877622,cardiologist}

//    @RequestBody - takes the input or request from the postman and assigns it to doctor object

    @PostMapping("/save")
    public String saveDoctor(@RequestBody Doctor inputDoctorRequest){
        // take the input request coming and add it inside hashmap
         doctorDb.put(inputDoctorRequest.getId(),inputDoctorRequest) ;
         return "Doctor saved successfully";

    }

    @GetMapping("/findAll")
    public HashMap<Integer, Doctor> findAllDoctors(){
        return doctorDb;
    }

    // @PathVariable - input is sent in url path or endpoint
    @GetMapping("/find/{id}")
    public Doctor findDoctorById(@PathVariable int id){
        Doctor doctor= doctorDb.get(id);
        return doctor;
    }
    @DeleteMapping("/delete/{id}")
    public String deleteDoctorById(@PathVariable int id){
     doctorDb.remove(id);
     return "Doctor deleted successfully with id : "+id;
    }
    @PutMapping("/update/{id}")
    public String updateDoctor(@PathVariable int id , @RequestBody Doctor updateDoctorRequest){
        // check if the doctor is present or not
        // if doctor is present update else do not update
        Doctor doctor= doctorDb.get(id);
        if(doctor!=null){
            doctorDb.put(updateDoctorRequest.getId(),updateDoctorRequest);
            return "Doctor id found and updated";
        }else {
            return "Doctor is not found to update";
        }
    }
}
