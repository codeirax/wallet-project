package com.masai.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.InvalidAccountException;
import com.masai.exceptions.WalletException;
import com.masai.model.BankAccount;
import com.masai.model.Customer;
import com.masai.model.Wallet;
import com.masai.services.UserService;
import com.masai.services.WalletServices;


@RestController
public class WalletController {
   
  @Autowired
  private WalletServices wService;
  
  @Autowired
  private UserService uService;
  
  
  
  
  
	
	
	@GetMapping("/walletbalance")
	public double showWalletBalanceHandler(@RequestParam String key) {
		return wService.showWalletBalance(key);
	}
	
	@PostMapping("/addmoney/{accountNumber}/{amount}")
	public String addMoneyToWallet(@PathVariable long accountNumber, @PathVariable double amount, @RequestParam String key) {
		return wService.addMoneyToWallet( accountNumber, amount,key);
		
	}
	
   
	@PutMapping("/fundtransfer")
	public String fundTransferHandler(@RequestParam String key, @RequestParam String mobileNumber, @RequestParam double amount) {
		
		return wService.FundTransfer(key, mobileNumber, amount);
	}
	

	
}
