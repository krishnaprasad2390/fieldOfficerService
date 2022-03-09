package com.mortgage.fieldofficerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mortgage.fieldofficerservice.entity.EnquiryDetails;
import com.mortgage.fieldofficerservice.service.FieldOfficerService;

@RestController
@RequestMapping("/EnquiryDetailsTable")
public class FieldOfficerController {
	
	@Autowired
	private FieldOfficerService fieldOfficerService;
	
	
	@PostMapping("/Save")
	public ResponseEntity<EnquiryDetails> saveenquiryDetails(@RequestBody EnquiryDetails enquiryDetails) {
	
		EnquiryDetails enquiry = fieldOfficerService.saveEnquiryDetails(enquiryDetails);
		ResponseEntity<EnquiryDetails> responseEntity = new ResponseEntity<>(enquiry, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/get/{cid}")
	public ResponseEntity<?> fetchCustomerDetails(@PathVariable("cid") int customer_id) {
		EnquiryDetails customer = fieldOfficerService.getCustomerById(customer_id);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<EnquiryDetails> modifyenquiryDetails1(@RequestBody EnquiryDetails enquiryDetails) {

		EnquiryDetails updatedEnquiryDetails = fieldOfficerService.updateEnquiryDetails(enquiryDetails);
		return new ResponseEntity<>(updatedEnquiryDetails, HttpStatus.OK);
	}

}
