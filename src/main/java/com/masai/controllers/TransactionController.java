package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.services.TransactionSevices;

import java.time.LocalDate;
import java.util.*;
import com.masai.model.Transaction;

@RestController
public class TransactionController {

	@Autowired
	private TransactionSevices trServices;
	
	
	@GetMapping("/transactionlist")
	public List<Transaction> getTransactionList(@RequestParam String key) {
		
		return trServices.viewAllTransaction(key);
	}
	
	
	@GetMapping("/transactionlistbyDate/{L}")
	public List<Transaction> getTransactionList2(@RequestParam String key, @PathVariable("L") String localDate) {
		
		return trServices.viewAllTransactionByDate(key, localDate);
	}
	
}

