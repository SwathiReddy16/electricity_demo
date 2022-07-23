package com.electricity_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.electricity_demo.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	

	@Query("select p from Payment p where p.paymentId=:paymentId")
	public Payment existPaymentId(@Param(value = "paymentId") Long paymentId);

}
