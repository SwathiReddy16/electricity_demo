package com.electricity_demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electricity_demo.entity.Connection;
import com.electricity_demo.service.ConnectionService;

@RestController
@RequestMapping("/connection")
public class ConnectionController {
	
	@Autowired
	ConnectionService connectionService;
	
	
	@PostMapping("/saveConnection")
	public ResponseEntity<Connection> newConnectionRequest(@RequestBody @Valid Connection connection)
	{
		return new ResponseEntity<Connection>(connectionService.newConnectionRequest(connection), HttpStatus.CREATED);
	}
	
	@GetMapping("/searchByConsumerNumber/{consumerNumber}")
	public ResponseEntity<Connection> searchByConsumerNumber(@PathVariable(value = "consumerNumber") Long consumerNumber)
	{
		return new ResponseEntity<Connection>(connectionService.searchByConsumerNumber(consumerNumber),HttpStatus.OK);
		
	}
	
	@PutMapping("/modifyConnection/{connectionId}")
	public ResponseEntity<Connection> modifyConnection(@PathVariable(value = "connectionId") Long connectionId, @RequestBody Connection newConnection)
	{
		return new ResponseEntity<Connection>(connectionService.modifyConnection( newConnection,connectionId), HttpStatus.OK);
	}
	
	
	@GetMapping("/searchByConnectionStatus/{connectionStatus}")
	public ResponseEntity<Connection> searchConnectionStatus(@PathVariable(value = "connectionStatus") String connectionStatus)
	{
		return new ResponseEntity<Connection>(connectionService.searchConnectionStatus(connectionStatus),HttpStatus.OK);
		
	}
	

}
