package com.electricity_demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity_demo.entity.Bill;
import com.electricity_demo.exception.NoSuchCustomerException;
import com.electricity_demo.repository.BillRepository;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	BillRepository billRepository;

	@Override
	public List<Bill> getAllBill() {
	
		List<Bill> bills = new ArrayList<Bill>();
		billRepository.findAll().forEach(bill -> bills.add(bill));
		return bills;
	}

	@Override
	public List<Bill> findById(Long billId) {
		if(billId == null)
		{
			System.out.println("BillId is null");		}
		return (List<Bill>) billRepository.findByBillId(billId);
	}

	@Override
	public Bill saveOrUpdate(Bill bill) {
		
		return billRepository.save(bill);
	}

	@Override
	public int deleteBillById(Long billId)  {
		
		if (billRepository.existsById(billId)) {

			billRepository.deleteById(billId);
			return 1;
		} else {
			throw new NoSuchCustomerException();
		}
	}

	@Override
	public Bill updateBillById(Bill bill, Long billId) {
		
		Bill bills = billRepository.existId(billId);

		if (bills.getBillId().equals(bills)) {
			billRepository.save(bill);
		}
		return bills;

	}

}
