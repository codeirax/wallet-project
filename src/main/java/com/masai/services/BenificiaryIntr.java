package com.masai.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.model.Benificiary;



@Service
public interface BenificiaryIntr {
	
	
	public Benificiary addBenificiary(Benificiary benificary,String key);
	
	
	
	public List<Benificiary> viewAllBenificiary(String key);
	
	
	

}
