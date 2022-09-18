package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.capg.model.CheckinRecord;
import com.capg.model.FlightData;
import com.capg.model.Passenger;

@Repository
public interface checkinrepo extends JpaRepository<CheckinRecord,Integer>{

}
