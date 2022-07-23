package com.electricity_demo.controller;



import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.electricity_demo.entity.Payment;
import com.electricity_demo.service.PaymentService;

@RestController
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@GetMapping("/payment/{paymentId}")
	public ResponseEntity<Payment> viewPaymentById(@PathVariable(value="paymentId") Long paymentId)
	{
		return new ResponseEntity<Payment>(paymentService.viewPaymentById(paymentId), HttpStatus.OK);
	}
	
	@PostMapping("/payment/savedetails")
	public ResponseEntity<Payment> savePaymentDetails(@RequestBody @Valid @NotBlank Payment payment)
	{
		return new ResponseEntity<Payment>(paymentService.savePaymentDetails(payment), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/payment/delete/{paymentId}")
	public ResponseEntity<String> deletePayment(@PathVariable Long paymentId )
	{
	  return new ResponseEntity<String>(paymentService.deletePayment(paymentId), HttpStatus.OK);
	}
	

	
}
