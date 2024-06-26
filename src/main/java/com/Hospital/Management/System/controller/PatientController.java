package com.Hospital.Management.System.controller;

import com.Hospital.Management.System.entity.Patient;
import com.Hospital.Management.System.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/patient")
    public Patient createPatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }

    @GetMapping("/patient")
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }
   @DeleteMapping("/patient/{id}")
    public ResponseEntity<Map<String,Boolean>> deletePatient(@PathVariable long id) throws AttributeNotFoundException{
        Patient patient = patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient not found with id "+id));
        patientRepository.delete(patient);
        Map<String,Boolean> response = new HashMap<String,Boolean>();
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/patient/{id}")
    public ResponseEntity<Patient> updatePatientByID(@PathVariable long id,@RequestBody Patient patientDetails) throws AttributeNotFoundException {
     Patient patient = patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient not found with id "+id));

     patient.setAge(patientDetails.getAge());
      patient.setBlood(patientDetails.getBlood());
      patient.setDose(patientDetails.getDose());
      patient.setFees(patientDetails.getFees());
      patient.setUrgency(patientDetails.getUrgency());
      patient.setPrescription(patientDetails.getPrescription());
      patient.setName(patientDetails.getName());
      Patient savedPatient = patientRepository.save(patient);
      return ResponseEntity.ok(savedPatient);
    }
    @GetMapping("/patient/{id}")
    public ResponseEntity<Patient> getPatientsById(@PathVariable long id) throws AttributeNotFoundException {
        Patient patient =patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient not found with id "+id));
        return ResponseEntity.ok(patient);
    }
}
