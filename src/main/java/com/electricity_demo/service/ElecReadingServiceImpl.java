package com.electricity_demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity_demo.entity.ElecReading;
import com.electricity_demo.exception.NoSuchCustomerException;
import com.electricity_demo.repository.ElecReadingRepository;

@Service
public class ElecReadingServiceImpl implements ElecReadingService {
	
	@Autowired
	private ElecReadingRepository elecreadingRepository;

	@Override
	public ElecReading saveElecReading(ElecReading elecreading) {
		
		return elecreadingRepository.save(elecreading);
	}

	@Override
	public List<ElecReading> allElecreading() {
		return elecreadingRepository.findAll();
	}

	@Override
	public ElecReading addElecReading(ElecReading elecreading) {
		return elecreadingRepository.save(elecreading);
	}

	@Override
	public Optional<ElecReading> getElecReadingById(long readingId) {
		
		return elecreadingRepository.findById(readingId);
	}

	@Override
	public int deleteElecReading(Long readingId) {
		if (elecreadingRepository.existsById(readingId)) {

			elecreadingRepository.deleteById(readingId);
			return 1;
		} 
		else {
			throw new NoSuchCustomerException();
		}
	}

	
}
