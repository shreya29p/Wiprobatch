package com.abc.medicine.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.medicine.entity.Category;
import com.abc.medicine.entity.Medicine;
import com.abc.medicine.exception.ResourceNotFoundException;
import com.abc.medicine.repository.MedicineRepository;



@SpringBootTest
public class MedicineServiceTest {
	
	@InjectMocks
	private MedicineServiceImpl medicineService;
	
	@Mock
	MedicineRepository medicineRepository;
	
	
	@Test
	public void testGetMedicineDetails() {
		
		Medicine medicine = new Medicine();
		Category category = new Category();
		medicine.setMedieId(2);
		medicine.setMediName("LXP");
		medicine.setMediPrice(90);
		medicine.setMfd(LocalDate.of(2024, 01, 01));
		medicine.setEfd(LocalDate.of(2027, 05, 01));
		medicine.setDescription("Use for cough");
		medicine.setCategory(null);
		category.setCategoryId(1);
		category.setCategoryName("Cough");
		
		when(medicineRepository.findById(1)).thenReturn(Optional.of(medicine));
		
		Medicine actualObj = medicineService.getMedicineById(111);
		
		assertEquals("LXP",actualObj.getMediName());
	}
	
	@Test
	public void testGetMedicineDetailsException() {
		
		when(medicineRepository.findById(2)).thenThrow(new ResourceNotFoundException("Resource not existing with id: 100"));
		assertThrows(ResourceNotFoundException.class, ()->medicineService.getMedicineById(1));
	}
	
	@Test
	public void testGetAllMedicines() {
		
		Medicine medicine = new Medicine();
		Category category = new Category();
		medicine.setMedieId(2);
		medicine.setMediName("LXP");
		medicine.setMediPrice(90);
		medicine.setMfd(LocalDate.of(2024, 01, 01));
		medicine.setEfd(LocalDate.of(2027, 05, 01));
		medicine.setDescription("Use for cough");
		medicine.setCategory(null);
		category.setCategoryId(1);
		category.setCategoryName("Cough");
		
		
		Medicine medicine1 = new Medicine();
		Category category1 = new Category();
		medicine1.setMedieId(3);
		medicine1.setMediName("DLSYM");
		medicine1.setMediPrice(90);
		medicine1.setMfd(LocalDate.of(2023, 01, 01));
		medicine1.setEfd(LocalDate.of(2027, 05, 31));
		medicine1.setDescription("Use for cough");
		medicine1.setCategory(null);
		category1.setCategoryId(1);
		category1.setCategoryName("Cough");
		
		
		Medicine medicine2 = new Medicine();
		Category category2 = new Category();
		medicine2.setMedieId(4);
		medicine2.setMediName("Cipla");
		medicine2.setMediPrice(90);
		medicine2.setMfd(LocalDate.of(2024, 11, 21));
		medicine2.setEfd(LocalDate.of(2027, 05, 31));
		medicine2.setDescription("Use for cold");
		medicine2.setCategory(null);
		category2.setCategoryId(2);
		category2.setCategoryName("Cold");
		
		
		Medicine medicine3 = new Medicine();
		Category category3 = new Category();
		medicine3.setMedieId(5);
		medicine3.setMediName("Dolo");
		medicine3.setMediPrice(35);
		medicine3.setMfd(LocalDate.of(2024, 8, 9));
		medicine3.setEfd(LocalDate.of(2027, 11, 27));
		medicine3.setDescription("Use for fever");
		medicine3.setCategory(null);
		category3.setCategoryId(1);
		category3.setCategoryName("Fever");
		
		
		List<Medicine> medicines = new ArrayList<>();
		medicines.add(medicine);
		medicines.add(medicine1);
		medicines.add(medicine2);
		medicines.add(medicine3);
		
		when(medicineRepository.findAll()).thenReturn(medicines);
		
		List<Medicine> medicineList = medicineService.getAllMedicines();
		assertEquals(3,medicineList.size());
		}
	
	@Test
	void testDeleteMedicine() {
		
		Medicine medicine3 = new Medicine();
		medicine3.setMedieId(5);
		medicine3.setMediName("Dolo");
		medicine3.setMediPrice(35);
		medicine3.setMfd(LocalDate.of(2024, 8, 9));
		medicine3.setEfd(LocalDate.of(2027, 11, 27));
		medicine3.setDescription("Use for fever");
		medicine3.setCategory(null);
		
		
		when(medicineRepository.findById(5)).thenReturn(Optional.of(medicine3));
		
		doNothing().when(medicineRepository).delete(medicine3);
		
		medicineService.deleteMedicine(5);
		
		verify(medicineRepository,times(1)).findById(5);
		verify(medicineRepository,times(1)).delete(medicine3);	
	}
	
	@Test
	void testDeleteMedicineWithException() {
		
		Medicine medicine3 = new Medicine();
		medicine3.setMedieId(5);
		medicine3.setMediName("Dolo");
		medicine3.setMediPrice(35);
		medicine3.setMfd(LocalDate.of(2024, 8, 9));
		medicine3.setEfd(LocalDate.of(2027, 11, 27));
		medicine3.setDescription("Use for fever");
		medicine3.setCategory(null);
		
		when(medicineRepository.findById(5)).thenThrow(new ResourceNotFoundException("Resource not existing with id: 5"));
		
		assertThrows(ResourceNotFoundException.class, ()->medicineService.deleteMedicine(5));
		
		verify(medicineRepository,times(0)).delete(medicine3);	
	}

}


