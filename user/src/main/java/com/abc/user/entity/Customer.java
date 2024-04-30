package com.abc.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="custom_tbl")
public class Customer extends User{
	
	@Id
	@Column(name="cus_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int cusId;
	
	@Column(name="firstName", length = 20)
	private String fName;
	
	@Column(name="lastName", length = 20)
	private String lName;
	
	private String Email;
	
	@Column(length = 10)
	private String Mobile;
	
	@Column(length = 50)
	private String Address;
	
	
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}

}
