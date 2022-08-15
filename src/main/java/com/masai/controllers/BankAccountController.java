package com.masai.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.BankAccount;
import com.masai.services.AccountServicesIntr;


@RestController
public class BankAccountController {
	
	@Autowired
   AccountServicesIntr accountServicesIntr;
	

	@PostMapping("/addaccount")
	public BankAccount AccountHandler(@RequestBody  BankAccount bank, @RequestParam String key) {
		return accountServicesIntr.addAccount(bank, key);
		
		
	}
	
	@GetMapping("/accounts")
	public List<BankAccount> listAccountHandler(@RequestParam String key){
		return accountServicesIntr.getAllBankAccounts(key);
	}
	
	@DeleteMapping("/accounts")
	public BankAccount removeBankAccountHandler(@RequestParam String key,
												@RequestParam Integer accountNo ) {
		return accountServicesIntr.removeBankAccount(key, accountNo);
	}

}
