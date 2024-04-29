package com.abc.medicine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.medicine.entity.Medicine;
import com.abc.medicine.exception.ResourceNotFoundException;
import com.abc.medicine.repository.MedicineRepository;


@Service
public class MedicineServiceImpl implements MedicineService{

	@Autowired
	private MedicineRepository medicineRepository;
    

	@Override
	public Medicine saveMedicine(Medicine medicine) {
		medicineRepository.save(medicine);
		return medicine;
	}

	@Override
	public Medicine getMedicineById(int medieId) {
		Optional<Medicine> optionalMedicine = medicineRepository.findById(medieId);
        if(optionalMedicine.isEmpty()) {
        	throw new ResourceNotFoundException("Medicine not existing with id: "+medieId);
        }
        Medicine medicine = optionalMedicine.get();
        return medicine;
	}

	@Override
	public List<Medicine> getAllMedicines() {
		List<Medicine> medicines = medicineRepository.findAll();
		return medicines;
	}
	
	@Override
	public Medicine updateMedicine(Medicine medicine) {
		Optional<Medicine> optionalMedicine = medicineRepository.findById(medicine.getMedieId());
        if(optionalMedicine.isEmpty()) {
        	throw new ResourceNotFoundException("Medicine not existing with id: "+medicine.getMedieId());
        }
        medicineRepository.save(medicine);
        return medicine;
	}
	
	@Override
	public void deleteMedicine(int medieId) {
		Optional<Medicine> optionalMedicine = medicineRepository.findById(medieId);
        if(optionalMedicine.isEmpty()) {
        	throw new ResourceNotFoundException("Medicine not existing with id: "+medieId);
        }
        Medicine medicine = optionalMedicine.get();
        medicineRepository.delete(medicine);
	}
}