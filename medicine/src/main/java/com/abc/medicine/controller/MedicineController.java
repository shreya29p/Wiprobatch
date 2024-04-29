package com.abc.medicine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.medicine.entity.Medicine;
import com.abc.medicine.service.MedicineService;

@RestController
@RequestMapping("/medicine")
public class MedicineController {
	
	@Autowired
	private MedicineService medicineService;

	@GetMapping("/all")
	public List<Medicine> fetchAllMedicines() {
		List<Medicine> medicines = medicineService.getAllMedicines();
		return medicines;
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Medicine> fetchMedicineDetails(@PathVariable("id") int medieId) {
		Medicine medicine = medicineService.getMedicineById(medieId);
			return new ResponseEntity<>(medicine,HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Medicine> addMedicine(@RequestBody Medicine medicine) {
		medicineService.saveMedicine(medicine);
		ResponseEntity<Medicine> responseEntity = new ResponseEntity<>(medicine,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PutMapping("/update")
	public  ResponseEntity<Medicine> editMedicine(@RequestBody Medicine medicine) {
		medicineService.updateMedicine(medicine);
		ResponseEntity<Medicine> responseEntity = new ResponseEntity<>(medicine,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMedicine(@PathVariable("id") int medieId) {
		medicineService.deleteMedicine(medieId);
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;	
	}
}

