package com.electricity_demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Bill {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long billId;
	
	@NotNull(message="cannot be null")
	private LocalDate BillDate;
	
	@NotNull(message="cannot be null")
	private LocalDate BillDueDate;
	
	@Min(50)
	@NotNull(message="cannot be null")
	private int unitsConsumed;
	
	private int billAmount;
	
	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public LocalDate getBillDate() {
		return BillDate;
	}

	public void setBillDate(LocalDate billDate) {
		BillDate = billDate;
	}

	public LocalDate getBillDueDate() {
		return BillDueDate;
	}

	public void setBillDueDate(LocalDate billDueDate) {
		BillDueDate = billDueDate;
	}

	public int getUnitsConsumed() {
		return unitsConsumed;
	}

	public void setUnitsConsumed(int unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}

	public int getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}

}
