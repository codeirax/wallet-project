package com.masai.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.BankAccount;
import com.masai.model.Beneficiary;
import com.masai.model.Customer;
import com.masai.model.LoginDTO;
import com.masai.services.AccountServicesIntr;
import com.masai.services.BenificiaryIntr;
import com.masai.services.BillPaymentImpl;
import com.masai.services.CustomerLoginImpl;
import com.masai.services.CustomerServiceIntr;
import com.masai.services.TransactionSevices;
import com.masai.services.WalletServices;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerServiceIntr customerServiceImpl;

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
	
	@Autowired
	private CustomerLoginImpl customerLogin;
	
	  // for user Login
		@PostMapping(value = "/login")
		public String logInCustomer(@Valid @RequestBody LoginDTO customerDTO) {
			return customerLogin.logIntoAccount(customerDTO);
		}
		
		// for user Logout
		@PatchMapping(value = "/logout")
		public String logOutCustomer(@RequestParam(required = false) String key) {
			return customerLogin.logOutFromAccount(key);
		}

		// to register user
		@PostMapping(value = "/addcustomer")
		public Customer addCustomer(@Valid @RequestBody Customer customer) {
			return customerServiceImpl.createCustomer(customer);
		}
		
		// To update existing user details by passing its login key
		@PutMapping(value = "/customer")
		public Customer updateCustomer(@Valid @RequestBody Customer customer, @RequestParam(required = false) String key) {
			return customerServiceImpl.updateCustomer(customer, key);
		}
		
		
		// To delete existing user details by passing its login key
		@DeleteMapping(value = "/customer")
		public Customer deleteCustomer(@RequestParam(required = false) String key) {
			return customerServiceImpl.deleteCustomer(key);
		}
		
	
		
		
		@PostMapping("/addaccount")
		public BankAccount AccountHandler(@RequestBody  BankAccount bank, @RequestParam String key) {
			return accountServicesIntr.addAccount(bank, key);
			
			
		}
		

		
		@DeleteMapping("/accounts")
		public BankAccount removeBankAccountHandler(@RequestParam String key,@RequestParam Integer accountNo ) {
													                 
			return accountServicesIntr.removeBankAccount(key, accountNo);
		}
		
		
		// add beneficiary
		@PostMapping("/addbenificiary")
		public Beneficiary addBenificiaryHandler(@Valid @RequestBody Beneficiary benificiary, @RequestParam String key) {
			
		return bService.addBenificiary(benificiary, key);
			
		}
		
		
	

}
