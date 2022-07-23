package com.electricity_demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity_demo.entity.Customer;
import com.electricity_demo.exception.AadharNoNotFoundException;
import com.electricity_demo.exception.EmailDoesNotExistException;
import com.electricity_demo.exception.IdDoesNotExistException;
import com.electricity_demo.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer registerCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer viewCustomerProfile(Long customerId) throws IdDoesNotExistException {

		Optional<Customer> opcust=customerRepository.findById(customerId);
		if(opcust.isPresent())return opcust.get();
		throw new IdDoesNotExistException();
		
	}

	@Override
	public Customer searchCustomerByEmail(String email) throws EmailDoesNotExistException {

		if (customerRepository.existEmail(email) != null) {
			return customerRepository.existEmail(email);
		} else
			throw new EmailDoesNotExistException();
	}

	@Override
	public Customer searchCustomerByAadhar(String aadharNo) throws AadharNoNotFoundException {
		
		if (customerRepository.existAadhar(aadharNo) != null) {
			return customerRepository.existAadhar(aadharNo);
		}

		throw new AadharNoNotFoundException();

		
	}

	@Override
	public List<Customer> searchCustomerByName(String firstName) {

		List<Customer> customer = customerRepository.existName(firstName);
		return customer;

	}

	@Override
	public Customer editCustomerProfile(Customer newCustomer, Long customerId) throws IdDoesNotExistException {

		if (customerRepository.existId(customerId) != null) {
			Customer customer = customerRepository.existId(customerId);
			if (customer.getCustomerId().equals(customerId) && customerId != 0) {
				customerRepository.save(newCustomer);
			}
			return customer;
		}
		throw new IdDoesNotExistException();
	}
}
