package com.electricity_demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.electricity_demo.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	@Query("select c from Customer c where c.customerId=:customerId")
	public Customer existId(@Param(value = "customerId") Long customerId);

	@Query("select c from Customer c where c.email=:email")
	public Customer existEmail(@Param(value = "email") String email);

	@Query("select c from Customer c where c.aadharNo=:aadharNo")
	public Customer existAadhar(@Param(value = "aadharNo") String aadharNo);

	@Query("select c from Customer c where c.firstName=:firstName")
	public List<Customer> existName(@Param(value = "firstName") String firstName);

}
