package com.masai.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.services.CustomerServiceIntr;

@RestController
public class CustomerController {

	@Autowired
	private CustomerServiceIntr customerServiceImpl;

	// to register user
	@PostMapping(value = "/customer")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) {

		Customer custmer = customerServiceImpl.createCustomer(customer);

		return new ResponseEntity<Customer>(custmer, HttpStatus.ACCEPTED);
	}

	// To update existing user details by passing its login key
	@PutMapping(value = "/customer")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer,
			@RequestParam(required = false) String key) {
		Customer fetched_customer = customerServiceImpl.updateCustomer(customer, key);

		return new ResponseEntity<Customer>(fetched_customer, HttpStatus.ACCEPTED);
	}

	// To delete existing user details by passing its login key
	@DeleteMapping(value = "/customer")
	public ResponseEntity<Customer> deleteCustomer(@RequestParam(required = false) String key) {
		Customer deleted_customer = customerServiceImpl.deleteCustomer(key);

		return new ResponseEntity<Customer>(deleted_customer, HttpStatus.ACCEPTED);
	}

	// To get details of current user by passing its login key
	@GetMapping(value = "/customer")
	public ResponseEntity<Customer> getCustomerDetails(@RequestParam(required = false) String key) {
		Customer fetched_customer = customerServiceImpl.getCustomerDetails(key);

		return new ResponseEntity<Customer>(fetched_customer, HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/customers")
	public ResponseEntity<List<Customer>> getAllCustomersDetailsHandler() {
		List<Customer> list = customerServiceImpl.getCustomerList();
		
		return new ResponseEntity<List<Customer>>(list, HttpStatus.ACCEPTED);
	}

}
