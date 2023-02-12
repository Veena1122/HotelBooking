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
    //Optional<RoomDetails> findByHotelId(int hid);

	//@Query("select obj from RoomDetails obj where obj.hotel_hotel_id = :hotelid")
	//@Query("select obj from RoomDetails obj where obj.hotel.hotel_id=?1")
	
       @Query("select obj from RoomDetails obj JOIN obj.hotel h WHERE h.hotel_id = :hotelid")
	   List<RoomDetails> findAllByHotel(@Param("hotelid") int hotel_id);
	
      //	@Query("select obj from Availability obj where obj.from_date between :fromD and :toD")
     //	List<Availability> getByAvailabilityInRange(@Param("fromD") LocalDate fD, @Param("toD")LocalDate tD);
	
}
