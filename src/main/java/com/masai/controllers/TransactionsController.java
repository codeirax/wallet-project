package com.masai.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.BankAccount;
import com.masai.model.BillPayment;
import com.masai.services.AccountServicesIntr;
import com.masai.services.BenificiaryIntr;
import com.masai.services.BillPaymentImpl;
import com.masai.services.TransactionSevices;
import com.masai.services.WalletServices;

@RestController
public class TransactionsController {
	
	
	    @Autowired
	   AccountServicesIntr accountServicesIntr;
		
		@Autowired
		private WalletServices wService;
		
		@Autowired
		private BenificiaryIntr bService;
		
		@Autowired
		private TransactionSevices trServices;
		
		@Autowired
		private BillPaymentImpl billservice;
		
		
		// deposit
		@PutMapping("/deposit/{ac}/{a}")
		public BankAccount depositInBankHandler(@PathVariable("ac") long accountNumber, @PathVariable("a") double amount, @RequestParam String key) {
			return wService.depositAmount(accountNumber, amount, key);
		}
		
		// add money to wallet
		@PostMapping("/addmoney/{accountNumber}/{amount}")
		public String addMoneyToWallet(@PathVariable long accountNumber, @PathVariable double amount, @RequestParam String key) {
			return wService.addMoneyToWallet( accountNumber, amount,key);
			
		}
		
		// fundTransfer after adding beneficiary
		@PutMapping("/fundtransfer")
		public String fundTransferHandler(@RequestParam String key, @RequestParam String mobileNumber, @RequestParam double amount) {
			
			return wService.FundTransfer(key, mobileNumber, amount);
		}
		
		//transfer amount one customer to another customer
		
		@PutMapping("/transfertocustomer/{m}/{a}")
		public String customerToCustomerHandler(@PathVariable("m") String mobileNumber , @PathVariable("a") double amount ,@RequestParam String key ) {
			
			return wService.transferToCustomerWallet(mobileNumber, amount, key);
		}
		
		
		
		//bill payment
		
		@PostMapping("/billpay")
		public BillPayment billpayment(@Valid @RequestParam String key ,@RequestBody BillPayment bill) {
			return  billservice.addBill(key, bill);
		}
		
		
		
		
		

}
