package com.mortgage.fieldofficerservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EnquiryDetailsTable")
public class EnquiryDetails {
	
	@Id
	@Column(name="Customer_id")
	private int customerId;
	
	@Column(name="Customer_name")
	private String customerName;
	
	@Column(name="Status")
	private String customerStatus;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}
	

}
