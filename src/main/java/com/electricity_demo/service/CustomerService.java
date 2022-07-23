package com.electricity_demo.service;

import java.util.List;
import java.util.Optional;

import com.electricity_demo.entity.Customer;
import com.electricity_demo.exception.AadharNoNotFoundException;
import com.electricity_demo.exception.EmailDoesNotExistException;
import com.electricity_demo.exception.IdDoesNotExistException;

public interface CustomerService {
	
	public Customer registerCustomer(Customer customer);

	
	
	public Customer searchCustomerByEmail(String email) throws EmailDoesNotExistException;
	public Customer searchCustomerByAadhar(String aadharNo) throws AadharNoNotFoundException ;
	public List<Customer> searchCustomerByName(String firstName);
	public Customer editCustomerProfile(Customer newCustomer, Long customerId)throws IdDoesNotExistException;
	public Customer viewCustomerProfile(Long customerId) throws IdDoesNotExistException;


	

}
