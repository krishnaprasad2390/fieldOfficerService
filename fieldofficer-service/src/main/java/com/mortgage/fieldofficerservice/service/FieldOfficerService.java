package com.mortgage.fieldofficerservice.service;

import com.mortgage.fieldofficerservice.entity.EnquiryDetails;

public interface FieldOfficerService {

	public EnquiryDetails saveEnquiryDetails(EnquiryDetails enquiryDetails);

	public EnquiryDetails getCustomerById(int customerId);

	public EnquiryDetails updateEnquiryDetails(EnquiryDetails enquiryDetails);

}
