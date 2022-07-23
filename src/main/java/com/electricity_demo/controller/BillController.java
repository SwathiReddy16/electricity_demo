package com.electricity_demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electricity_demo.entity.Bill;
import com.electricity_demo.entity.Customer;
import com.electricity_demo.entity.ElecReading;
import com.electricity_demo.exception.NoSuchCustomerException;
import com.electricity_demo.service.BillService;

@RestController
@RequestMapping("/bill")
public class BillController {

	@Autowired
	BillService billService;

	@GetMapping("/getAllBills")
	private List<Bill> getAllBill() {

		return billService.getAllBill();
	}

	@GetMapping("/findBillById/{billId}")
	public List<Bill> getbillid(@PathVariable("billId") long billId) throws NoSuchCustomerException {

		if (billService.findById(billId).isEmpty()) {
			System.out.println("Bill Not found");
			throw new NoSuchCustomerException();

		}
		System.out.println("Fetched Successfully");
		return billService.findById(billId);
	}
	@PostMapping("/saveOrUpdate")
	public ResponseEntity<Bill> saveOrUpdate(@RequestBody @Valid Bill bill) {
		Bill saveOrUpdate=billService.saveOrUpdate(bill);
		return new ResponseEntity<Bill>(saveOrUpdate,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/deleteBillById/{billId}") 
	public String deleteBillByid(@PathVariable("billId") Long billId) throws NoSuchCustomerException
	{ 
		 billService.deleteBillById(billId);
	      return "deleted Successfully";
	}  
	
	@PutMapping("/editdetailsbyID/{billId}")
	public ResponseEntity<Bill> updateBillById(@PathVariable(value = "billid") Long billId,
			@RequestBody Bill bill) {
		return new ResponseEntity<Bill>(billService.updateBillById(bill,billId),HttpStatus.OK);
	}

}
