package com.Hospital.Management.System.doclogin.controller;

import com.Hospital.Management.System.doclogin.entity.Appointment;
import com.Hospital.Management.System.doclogin.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2")
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @PostMapping("/appointments")
    public Appointment createAppointment(@RequestBody Appointment appointment){
        return appointmentRepository.save(appointment);
    }
    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments(){
        return  appointmentRepository.findAll();
    }
    @DeleteMapping("appointments/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteAppointment(@PathVariable long id) throws AttributeNotFoundException {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Appointment not found with id "+id));
        appointmentRepository.delete(appointment);
        Map<String,Boolean> response = new HashMap<String,Boolean>();
        response.put("Deleted ", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



}
