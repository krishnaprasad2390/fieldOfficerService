package com.mortgage.fieldofficerservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mortgage.fieldofficerservice.entity.EnquiryDetails;
import com.mortgage.fieldofficerservice.exception.CustomerNotFoundException;
import com.mortgage.fieldofficerservice.exception.ResourceNotFoundException;
import com.mortgage.fieldofficerservice.repository.FieldOfficerRepository;

@Service
public class FieldOfficerServiceImpl implements FieldOfficerService {
	
	@Autowired
	private FieldOfficerRepository fieldOfficerRepository;

	/******************************************
	 - Method Name      : saveEnquiryDetails
	 - Input Parameters : EnquiryDetails enquiryDetails
	 - Return type      : savedEnquiryDetails
	 - Author           : padavala krishna prasad
	 - Creation Date    : 06-03-2022
	 - Description      : Inserting the EnquiryDetailsOfCustomer information entered by fieldOfficer into the database.
	  ******************************************/
	@Override
	public EnquiryDetails saveEnquiryDetails(EnquiryDetails enquiryDetails) {
		EnquiryDetails savedEnquiryDetails= fieldOfficerRepository.save(enquiryDetails);
		return savedEnquiryDetails;
	}

	/******************************************
	 - Method Name      : getCustomerById
	 - Input Parameters : CustomerId 
	 - Return type      : int
	 - Author           : padavala krishna prasad
	 - Creation Date    : 06-03-2022
	 - Description      : Getting the EnquiryDetailsOfCustomer information entered by fieldOfficer into the database.
	  ******************************************/
	@Override
	public EnquiryDetails getCustomerById(int customerId) throws CustomerNotFoundException {
		Optional<EnquiryDetails> optionalEnquiryDetails = fieldOfficerRepository.findById(customerId);
		if (optionalEnquiryDetails.isEmpty()) {
			throw new CustomerNotFoundException("Sorry! Customer not found with this id" + customerId);
		}
		return optionalEnquiryDetails.get();
	}

	/******************************************
	 - Method Name      : updateEnquiryDetails
	 - Input Parameters : EnquiryDetails
	 - Return type      : String
	 - Author           : padavala krishna prasad
	 - Creation Date    : 06-03-2022
	 - Description      : Updating the EnquiryDetailsOfCustomer information entered by fieldOfficer into the database.
	  ******************************************/
	
	@Override
	public EnquiryDetails updateEnquiryDetails(EnquiryDetails enquiryDetails) {
		Optional<EnquiryDetails> optionalEnquiryDetails = fieldOfficerRepository
				.findById(enquiryDetails.getCustomerId());
		if (optionalEnquiryDetails.isEmpty()) {

			throw new ResourceNotFoundException("Sorry! Customer not found with id" + enquiryDetails.getCustomerId());

		}

		EnquiryDetails updatedEnquiryDetails = fieldOfficerRepository.save(enquiryDetails);
		return updatedEnquiryDetails;
	}


}
