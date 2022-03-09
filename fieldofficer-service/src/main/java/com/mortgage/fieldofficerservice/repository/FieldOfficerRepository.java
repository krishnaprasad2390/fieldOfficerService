package com.mortgage.fieldofficerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mortgage.fieldofficerservice.entity.EnquiryDetails;

public interface FieldOfficerRepository extends JpaRepository<EnquiryDetails,Integer>{

}
