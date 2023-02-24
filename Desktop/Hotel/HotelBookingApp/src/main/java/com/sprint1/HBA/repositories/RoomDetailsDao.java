package com.sprint1.HBA.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprint1.HBA.entities.RoomDetails;


@Repository("rd")
public interface RoomDetailsDao extends JpaRepository<RoomDetails,Integer>{
	Optional<RoomDetails> findByRoomType(String rtype);
	
       @Query("select obj from RoomDetails obj JOIN obj.hotel h WHERE h.hotelId = :hotelid")
	   List<RoomDetails> findAllByHotel(@Param("hotelid") int hotel_id);
	
}
