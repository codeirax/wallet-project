package com.masai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.BankAccount;
import com.masai.model.Beneficiary;
import com.masai.model.BillPayment;
import com.masai.model.Customer;
import com.masai.model.Transaction;
import com.masai.services.AccountServicesIntr;
import com.masai.services.BenificiaryIntr;
import com.masai.services.BillPaymentImpl;
import com.masai.services.CustomerServiceIntr;
import com.masai.services.TransactionSevices;
import com.masai.services.WalletServices;

@RestController
public class GetDetailsController {
	
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
	
	// To get details of current user by passing its login key
	@GetMapping(value = "/customer")
	public Customer getCustomerDetails(@RequestParam(required = false) String key) {
		return customerServiceImpl.getCustomerDetails(key);
	}
	
	// list of banks
	
	@GetMapping("/accounts")
	public List<BankAccount> listAccountHandler(@RequestParam String key){
		return accountServicesIntr.getAllBankAccounts(key);
	}
	
	
	// list of bills
	@GetMapping("/billlist")
	public List<BillPayment> getallbills(@RequestParam String key){
		return billservice.billList(key);
	}
	

	//list of transaction
	@GetMapping("/transactionlist")
	public List<Transaction> getTransactionList(@RequestParam String key) {
		
		return trServices.viewAllTransaction(key);
	}
	
	
	// customer list
	@GetMapping(value = "/customers")
	public List<Customer> getAllCustomersDetailsHandler(){
		return customerServiceImpl.getCustomerList();
	}
	

	
	//beneficiary list
	
	@GetMapping("/getBenificiaries")
	public List<Beneficiary> beneficiaryListHandler(@RequestParam String key) {
		
	return bService.viewAllBenificiary(key);
		
	}
	
	// show wallet balance
	@GetMapping("/walletbalance")
	public double showWalletBalanceHandler(@RequestParam String key) {
		return wService.showWalletBalance(key);
	}

}
