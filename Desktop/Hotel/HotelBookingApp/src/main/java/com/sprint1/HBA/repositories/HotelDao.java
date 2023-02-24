package com.sprint1.HBA.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint1.HBA.entities.Hotel;

@Repository
public interface HotelDao extends JpaRepository<Hotel,Integer> {


	   Optional<Hotel> findAllByHotelName(String hName);

	    Hotel findByHotelName(String hName);

}
