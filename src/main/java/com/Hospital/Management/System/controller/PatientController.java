package com.Hospital.Management.System.controller;

import com.Hospital.Management.System.entity.Patient;
import com.Hospital.Management.System.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/insert")
    public Patient createPatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }

    @GetMapping()
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

}
