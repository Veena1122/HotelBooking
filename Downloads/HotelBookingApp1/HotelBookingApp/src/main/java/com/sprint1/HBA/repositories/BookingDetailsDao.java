package com.sprint1.HBA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint1.HBA.entities.BookingDetails;


@Repository("bdd")
public interface BookingDetailsDao extends JpaRepository<BookingDetails, Integer>{

	
	
	
}
