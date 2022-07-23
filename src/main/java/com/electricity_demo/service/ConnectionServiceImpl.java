package com.electricity_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity_demo.entity.Connection;

import com.electricity_demo.repository.ConnectionRepository;

@Service
public class ConnectionServiceImpl implements ConnectionService {

	@Autowired
	ConnectionRepository connRepo;

	@Override
	public Connection newConnectionRequest(Connection newConnection) {

		return connRepo.save(newConnection);
	}

	@Override
	public Connection searchByConsumerNumber(Long consumerNumber) {

		return connRepo.existByConsumerNo(consumerNumber);

	}

	@Override
	public Connection modifyConnection(Connection newConnection, Long connectionId) {

		Connection connection = connRepo.existById(connectionId);
		if (connection.getConnectionId().equals(connectionId) && connectionId != 0) {
			connRepo.save(newConnection);
		}
		return newConnection;

	}

	@Override
	public Connection searchConnectionStatus(String connectionStatus) {

		Connection connection = connRepo.existByConnectionStatus(connectionStatus);
		if (connection.getConnectionStatus().equals(connectionStatus) && connectionStatus != null) {
			connRepo.save(connection);
		}
		return connection;

	}

}
