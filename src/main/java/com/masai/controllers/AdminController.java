package com.masai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.masai.model.Transaction;
import com.masai.services.AdminServicesIntr;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminServicesIntr adminService;

	@GetMapping("/alltransactions")
	public ResponseEntity<List<Transaction>> allTransactionsHandler() {

		List<Transaction> list = adminService.getEveryTransaction();

		ResponseEntity<List<Transaction>> re = new ResponseEntity(list, HttpStatus.ACCEPTED);

		return re;
	}

	@GetMapping("/alltransactions/{id}")
	public ResponseEntity<List<Transaction>> allTransactionsByCustomerWalletHandler(@PathVariable int customerId) {

		List<Transaction> list = adminService.getEveryTransactionForId(customerId);

		ResponseEntity<List<Transaction>> re = new ResponseEntity(list, HttpStatus.ACCEPTED);

		return re;
	}

}
