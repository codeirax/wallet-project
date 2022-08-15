package com.masai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Benificiary;
import com.masai.services.BenificiaryIntr;

@RestController
public class BenificiaryController {
	
	@Autowired
	private BenificiaryIntr bService;
	
	@PostMapping("/addbenificiary")
	public Benificiary addBenificiaryHandler(@RequestBody Benificiary benificiary, @RequestParam String key) {
		
	return bService.addBenificiary(benificiary, key);
		
	}
	
	@DeleteMapping("/deletebenificiary")
	public Benificiary deletebenificiary(@RequestParam String key,@RequestParam String name) {
		return bService.deleteBenificiary(name, key);
	}
	
	@GetMapping("/getBenificiaries")
	public List<Benificiary> benificiaryListyHandler(@RequestParam String key) {
		
	return bService.viewAllBenificiary(key);
		
	}
	

}
