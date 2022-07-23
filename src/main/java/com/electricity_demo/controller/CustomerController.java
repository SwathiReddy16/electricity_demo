package com.electricity_demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electricity_demo.entity.Customer;

import com.electricity_demo.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/hello")
	public ResponseEntity<String> check() {
		return new ResponseEntity<String>("hi hello bye", HttpStatus.OK);
	}

	@PostMapping("/registerCustomer")
	public ResponseEntity<Customer> registerCustomer(@RequestBody @Valid Customer customer) {
		return new ResponseEntity<Customer>(customerService.registerCustomer(customer), HttpStatus.CREATED);
	}// working

//	@GetMapping("/byId/{id}")
	//public ResponseEntity<Optional<Customer>> viewCustomerProfile(@PathVariable(value = "id") Long customerId) {
	//	return new ResponseEntity<Optional<Customer>>(customerService.viewCustomerProfile(customerId), HttpStatus.OK);
//	}

	@GetMapping("/byemail/{email}")
	public ResponseEntity<Customer> searchCustomerByEmail(@PathVariable(value = "email") String email) {
		return new ResponseEntity<Customer>(customerService.searchCustomerByEmail(email), HttpStatus.OK);
	}

	@GetMapping("/byaadharNo/{aadharNo}")
	public ResponseEntity<Customer> searchCustomerByAadhar(@PathVariable(value = "aadharNo")  String aadharNo) {
		return new ResponseEntity<Customer>(customerService.searchCustomerByAadhar(aadharNo), HttpStatus.OK);
	}

	@GetMapping("/byname/{firstName}")
	public ResponseEntity<List<Customer>> searchCustomerByName(@PathVariable(value = "firstName") String firstName) {
		return new ResponseEntity<List<Customer>>(customerService.searchCustomerByName(firstName), HttpStatus.FOUND);
	}

	@PutMapping("/editdetails/{id}")
	public ResponseEntity<Customer> editCustomerProfile(@PathVariable(value = "id") Long CustomerId,
			@RequestBody Customer newCustomer) {
		return new ResponseEntity<Customer>(customerService.editCustomerProfile(newCustomer, CustomerId),
				HttpStatus.OK);
	}

}
