package com.electricity_demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.electricity_demo.entity.Bill;
;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long>{

	List<Bill> findByBillId(Long billId);
	
	@Query("select b from Bill b where b.billId=:billId")
	public Bill existId(@Param(value = "billId") Long billId); 
	
}
