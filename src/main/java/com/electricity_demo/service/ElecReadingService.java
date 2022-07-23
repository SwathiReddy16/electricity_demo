package com.electricity_demo.service;

import java.util.List;
import java.util.Optional;

import com.electricity_demo.entity.ElecReading;

public interface ElecReadingService {

public ElecReading saveElecReading(ElecReading elecreading);
	
	public List<ElecReading> allElecreading();
	
	public Optional<ElecReading> getElecReadingById(long readingId);
	
	public ElecReading addElecReading(ElecReading elecreading);
	
	public int deleteElecReading(Long readingId);

}
