package com.hcl.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class VaccinationCenter {

	@Id
	private int id;
	
	private String centerName;
	
	private String centerAddress;

	
	public VaccinationCenter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCenterAddress() {
		return centerAddress;
	}

	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}
	
	
}
