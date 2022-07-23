package com.electricity_demo.service;




import com.electricity_demo.entity.Connection;



public interface ConnectionService {
	
	
	Connection newConnectionRequest(Connection newConnection);

	Connection searchByConsumerNumber(Long consumerNumber);

	Connection modifyConnection(Connection newConnection, Long connectionId);
	
	Connection searchConnectionStatus(String connectionStatus);
	

	

}

