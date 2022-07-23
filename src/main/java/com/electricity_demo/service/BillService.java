package com.electricity_demo.service;



import java.util.List;

import com.electricity_demo.entity.Bill;



public interface BillService {
	
	 public List<Bill> getAllBill();   
	 public List<Bill> findById(Long billId);
	 public Bill saveOrUpdate(Bill bill); 
	 public int deleteBillById(Long billId);   
	 public Bill updateBillById(Bill bill, Long billId);   
	

}
