package com.abc.medicine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.medicine.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer>{

}
