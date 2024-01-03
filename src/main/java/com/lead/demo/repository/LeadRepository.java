package com.lead.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lead.demo.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long>{
	
	public Lead findByLeadId(String leadId);
	
	public List<Lead> findByMobileNumber(String mobileNumber);
	

}
