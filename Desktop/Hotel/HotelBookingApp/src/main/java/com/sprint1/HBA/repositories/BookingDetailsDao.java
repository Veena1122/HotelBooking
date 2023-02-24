package com.sprint1.HBA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprint1.HBA.entities.BookingDetails;


@Repository("bdd")
public interface BookingDetailsDao extends JpaRepository<BookingDetails, Integer>{

   @Query("select obj from BookingDetails obj JOIN obj.userss u WHERE u.userId = :userId")
   BookingDetails findByUserss(@Param("userId") int userId);

   @Query("select obj from BookingDetails obj JOIN obj.hotell u WHERE u.hotelId = :hotelId")
   BookingDetails findByHotell(@Param("hotelId") int hotelId);
   
  // @Query("select obj from RoomDetails obj JOIN obj.hotel h WHERE h.hotelId = :hotelid")
   //List<RoomDetails> findAllByHotel(@Param("hotelid") int hotel_id);

	
	
}
