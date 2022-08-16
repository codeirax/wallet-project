package com.masai.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.model.Beneficiary;



@Service
public interface BenificiaryIntr {
	
	
	public Beneficiary addBenificiary(Beneficiary benificary,String key);
	
	
	
	public List<Beneficiary> viewAllBenificiary(String key);
	
	
	

}
