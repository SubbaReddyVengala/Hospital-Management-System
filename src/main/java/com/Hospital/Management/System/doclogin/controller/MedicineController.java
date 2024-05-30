package com.Hospital.Management.System.doclogin.controller;

import com.Hospital.Management.System.doclogin.entity.Medicine;
import com.Hospital.Management.System.doclogin.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3")
public class MedicineController {
  @Autowired
   private MedicineRepository medicineRepository;
  @PostMapping("/insert")
  public Medicine createMedicine(@RequestBody Medicine medicine){
      return medicineRepository.save(medicine);
  }
  @GetMapping()
  public List<Medicine> getAllMedicines(){
      return medicineRepository.findAll();
  }

}
