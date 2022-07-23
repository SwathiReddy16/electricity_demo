package com.electricity_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electricity_demo.entity.ElecReading;

public interface ElecReadingRepository extends JpaRepository<ElecReading,Long>{

}
