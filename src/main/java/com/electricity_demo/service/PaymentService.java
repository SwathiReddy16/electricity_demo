package com.electricity_demo.service;
import com.electricity_demo.entity.Payment;



public interface PaymentService {
	
	public Payment savePaymentDetails(Payment payment);
	public Payment viewPaymentById(Long paymentId);
	public String deletePayment(Long paymentId);
	
}
