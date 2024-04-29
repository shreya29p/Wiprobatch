package com.abc.medicine.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicine_tbl")
public class Medicine {
	
	@Id
	@Column(name="medi_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int medieId;
	
	@Column(name="medi_name", length = 20)
	private String mediName;
	
	@Column(name="medi_price")
	private double mediPrice;
	
	@Column(name="medi_mfd")
	private LocalDate mfd;
	
	@Column(name="medi_efd")
	private LocalDate efd;
	
	@Column(name="medi_des", length = 20)
	private String description;
	
	private String Category;
	
	@ManyToOne
	@JoinColumn(name="category_no")
	private Category category;
	
	
	public int getMedieId() {
		return medieId;
	}
	public void setMedieId(int medieId) {
		this.medieId = medieId;
	}
	public String getMediName() {
		return mediName;
	}
	public void setMediName(String mediName) {
		this.mediName = mediName;
	}
	public double getMediPrice() {
		return mediPrice;
	}
	public void setMediPrice(double mediPrice) {
		this.mediPrice = mediPrice;
	}
	public LocalDate getMfd() {
		return mfd;
	}
	public void setMfd(LocalDate mfd) {
		this.mfd = mfd;
	}
	public LocalDate getEfd() {
		return efd;
	}
	public void setEfd(LocalDate efd) {
		this.efd = efd;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
