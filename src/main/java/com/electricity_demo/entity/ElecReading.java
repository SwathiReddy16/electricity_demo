package com.electricity_demo.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ElecReading {
 

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="Reading_Id")
	private long readingId;
	
	@Min(50)
	@Column(name="Units_consumed")
	private int unitsConsumed;
	

	@NotNull(message="Reading Date cannot be null")
	@Column(name="Reading_Date")
	private LocalDate readingDate;
	
	@Min(100)
	@Column(name="Price_Per_Unit")
	private int priceperUnit;
	
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="Cust_ID")
	private Customer customer;

	

	public long getReadingId() {
		return readingId;
	}

	public void setReadingId(long readingId) {
		this.readingId = readingId;
	}

	public int getUnitsConsumed() {
		return unitsConsumed;
	}

	public void setUnitsConsumed(int unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}

	public LocalDate getReadingDate() {
		return readingDate;
	}

	public void setReadingDate(LocalDate readingDate) {
		this.readingDate = readingDate;
	}

	public int getPriceperUnit() {
		return priceperUnit;
	}

	public void setPriceperUnit(int priceperUnit) {
		this.priceperUnit = priceperUnit;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
