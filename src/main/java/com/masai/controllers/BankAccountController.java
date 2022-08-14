package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.BankAccount;
import com.masai.services.AccountServicesIntr;
import com.masai.services.WalletServices;

@RestController
public class BankAccountController {
	
	@Autowired
   AccountServicesIntr accountServicesIntr;
	

	@PostMapping("/addaccount")
	public BankAccount AccountHandler(@RequestBody  BankAccount bank, @RequestParam String key) {
		return accountServicesIntr.addAccount(bank, key);
		
		
	}

}
