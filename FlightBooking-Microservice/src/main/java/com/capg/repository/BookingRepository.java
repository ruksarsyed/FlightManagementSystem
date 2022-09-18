package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.model.Passenger;
@Repository
public interface BookingRepository extends JpaRepository<Passenger,Integer>{

	Passenger findBypid(int pid);
	
	/*@Query("SELECT Count(p) FROM flight_data p WHERE p.pid LIKE CONCAT(:pid,'%')")
	public int findByPid(@Param("pid")int pid);*/
	
   
}
