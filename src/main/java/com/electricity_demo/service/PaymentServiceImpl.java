package com.electricity_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity_demo.entity.Bill;
import com.electricity_demo.entity.Payment;
import com.electricity_demo.exception.AmountExceededException;
import com.electricity_demo.repository.BillRepository;
import com.electricity_demo.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	BillRepository billRepository;

	@Override
	public Payment viewPaymentById(Long paymentId) {

		Payment payment = paymentRepository.existPaymentId(paymentId);
		return payment;

	}

	@Override
	public Payment savePaymentDetails(Payment payment) {
		Bill bill = billRepository.existId(payment.getBillId());
		if (bill.getBillAmount() == payment.getTotalPaid()) {
			payment.setStatus("Paid");
			return paymentRepository.save(payment);
		} else if (bill.getBillAmount() >= payment.getTotalPaid()) {
			payment.setStatus("Pending");
			return paymentRepository.save(payment);
		} else

			throw new AmountExceededException();

	}

	@Override
	public String deletePayment(Long paymentId) {

		paymentRepository.deleteById(paymentId);
		return "Deleted Successfully";
	}

}
