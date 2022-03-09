package com.mortgage.fieldofficerservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.mortgage.fieldofficerservice.entity.EnquiryDetails;
import com.mortgage.fieldofficerservice.exception.CustomerNotFoundException;
import com.mortgage.fieldofficerservice.repository.FieldOfficerRepository;

public class FieldOfficerTest {
	
	@InjectMocks
	private FieldOfficerService fieldOfficerService = new FieldOfficerServiceImpl();
	
	@Mock
	private FieldOfficerRepository fieldOfficerRepository;
	
	@Test
	public void testGetCustomerById() {
		EnquiryDetails enquiryDetails = new EnquiryDetails();
		enquiryDetails.setCustomerId(1);
		enquiryDetails.setCustomerName("krishna");
		enquiryDetails.setCustomerStatus("approved");
				
		Optional<EnquiryDetails> optionalenquiryDetails1 = Optional.of(enquiryDetails);
		int customerId = 1 ;
		
		when(fieldOfficerRepository.findById(1)).thenReturn(optionalenquiryDetails1);
		
		EnquiryDetails existingEnquiryDetails1 = fieldOfficerService.getCustomerById(customerId);
		
		assertEquals(enquiryDetails.getCustomerId(),existingEnquiryDetails1.getCustomerId());
		assertEquals(enquiryDetails.getCustomerName(),existingEnquiryDetails1.getCustomerName());
		assertEquals(enquiryDetails.getCustomerStatus(),existingEnquiryDetails1.getCustomerStatus());
		
	}

	
	@Test
	public void testGetProductByIdNotFound() {
		
		int customerId = 5;
		when(fieldOfficerRepository.findById(customerId)).thenThrow(CustomerNotFoundException.class);
		assertThrows(CustomerNotFoundException.class,()->fieldOfficerService.getCustomerById(customerId));
		
	}
	
	@Test
	public void testSaveEnquiryDetails1() {
		
		EnquiryDetails enquiryDetails = new EnquiryDetails();
		enquiryDetails.setCustomerId(2);
		enquiryDetails.setCustomerName("prasad");
		enquiryDetails.setCustomerStatus("Approved");
		
		when(fieldOfficerRepository.save(enquiryDetails)).thenReturn(enquiryDetails);
		
		EnquiryDetails newEnquiryDetails = fieldOfficerService.saveEnquiryDetails(enquiryDetails);
		
		
		verify(fieldOfficerRepository,times(1)).save(enquiryDetails);
	}

}
