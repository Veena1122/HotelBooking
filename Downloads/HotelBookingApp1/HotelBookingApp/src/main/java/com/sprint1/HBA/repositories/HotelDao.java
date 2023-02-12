package com.sprint1.HBA.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint1.HBA.entities.Hotel;
import com.sprint1.HBA.entities.RoomDetails;

@Repository
public interface HotelDao extends JpaRepository<Hotel,Integer> {

	Optional<Hotel> findByHotelName(String hName);
//    Optional<RoomDetails> findAllByRoomDetails(int hotel_id);

}
