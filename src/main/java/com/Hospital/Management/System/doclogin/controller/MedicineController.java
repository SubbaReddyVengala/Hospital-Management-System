package com.Hospital.Management.System.doclogin.controller;
import com.Hospital.Management.System.doclogin.entity.Medicine;
import com.Hospital.Management.System.doclogin.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//sample
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v3")
public class MedicineController {
  @Autowired
   private MedicineRepository medicineRepository;

  @PostMapping("/medicine")
  public Medicine createMedicine(@RequestBody Medicine medicine){
      return medicineRepository.save(medicine);
  }

  @GetMapping("/medicine")
  public List<Medicine> getAllMedicines(){
      return medicineRepository.findAll();
  }

  @GetMapping("/medicine/{id}")
  public ResponseEntity<Medicine> getMedicineById(@PathVariable long id) throws AttributeNotFoundException {
      Medicine medicine = medicineRepository.findById(id)
                                            .orElseThrow(()->new AttributeNotFoundException("Medicine Not Found with Id :"+id));
      return ResponseEntity.ok(medicine);
  }
 @PutMapping("/medicine/{id}")
 public ResponseEntity<Medicine> updateMedicineById(@PathVariable long id,@RequestBody Medicine medicineDetails) throws AttributeNotFoundException {

      Medicine medicine = medicineRepository.findById(id)
                                            .orElseThrow(()->new AttributeNotFoundException("Medicine Not Found with Id :"+id));

      medicine.setDrugName(medicineDetails.getDrugName());
      medicine.setStock(medicineDetails.getStock());
      Medicine savedMedicine = medicineRepository.save(medicine);

      return ResponseEntity.ok(savedMedicine);
}
@DeleteMapping("/medicine/{id}")
public ResponseEntity<Map<String,Boolean>> deleteMedicineById(@PathVariable long id) throws AttributeNotFoundException {
       Medicine medicine = medicineRepository.findById(id)
                                      .orElseThrow(()->new AttributeNotFoundException("Medicine Not Found with Id :"+id));

       medicineRepository.delete(medicine);
       Map<String,Boolean> response = new HashMap<String,Boolean>();
       response.put("Deleted",Boolean.TRUE);
       return ResponseEntity.ok(response);
  }
}
