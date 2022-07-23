package com.electricity_demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Range;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long paymentId;
	
	@NotNull(message = "Invalid Date")
	private LocalDate paymentDate;
	
	
	@NotNull(message="Late Payment Charges cannot be null")
    private double latePaymentCharges;
    
	
    @Range(min=0,message="Total Paid cannot be empty")
	@NotNull(message = "Enter valid amount")
	private double totalPaid;
	

	private String status;

	@NotNull(message = "Bill Id Cannot be Blank")
	private Long billId;

	@Enumerated(EnumType.STRING)
	private PaymentMode paymentmode;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setBillId(Long billId){this.billId = billId;}

	public Long getBillId(){return billId;}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getLatePaymentCharges() {
		return latePaymentCharges;
	}

	public void setLatePaymentCharges(double latePaymentCharges) {
		this.latePaymentCharges = latePaymentCharges;
	}

	public double getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(double totalPaid) {
		this.totalPaid = totalPaid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PaymentMode getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(PaymentMode paymentmode) {
		this.paymentmode = paymentmode;
	}

}
