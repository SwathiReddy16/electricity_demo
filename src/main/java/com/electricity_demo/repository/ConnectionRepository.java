package com.electricity_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.electricity_demo.entity.Connection;
//import com.electricity_demo.entity.Customer;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, String> {

	
	@Query("select c from Connection c where c.consumerNumber=:consumerNumber")
	public Connection existByConsumerNo(@Param(value = "consumerNumber") Long consumerNumber); 
	
	@Query("select c from Connection c where c.connectionId=:connectionId")
	public Connection existById(@Param(value = "connectionId") Long connectionId); 
	
	@Query("select c from Connection c where c.connectionStatus=:connectionStatus")
	public Connection existByConnectionStatus(@Param(value = "connectionStatus") String connectionStatus); 
}
