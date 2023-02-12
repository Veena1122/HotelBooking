package com.sprint1.HBA.service;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprint1.HBA.entities.Hotel;
import com.sprint1.HBA.entities.RoomDetails;
//import com.sprint1.HBA.entities.RoomDetails;
import com.sprint1.HBA.exceptions.HotelIdNotFoundException;
import com.sprint1.HBA.exceptions.HotelNameNotFoundException;
import com.sprint1.HBA.exceptions.HotelNotFoundException;
import com.sprint1.HBA.exceptions.IdNotMatchedException;
import com.sprint1.HBA.exceptions.NoRoomDetailsFoundException;
import com.sprint1.HBA.repositories.HotelDao;

@Service
public class HotelService implements IHotelService{
    @Autowired
	HotelDao hd;
	
    @Override
    public Hotel addHotel(Hotel hotel) {
//    	for(RoomDetails temp:hotel.getRoomDetails())
//    	{
//     	   hotel.addRoomDetails(temp);
//    	}
    	hotel.SetHotelToRoomDetails(hotel.getRoomDetails());
		Hotel added=hd.save(hotel);
//		added.addRoomDetails(added.getRoomDetails());
		return added;
	}
	
//	public RoomDetails findRoomDetailsByHotelId(int hotel_id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	public RoomDetails findBookingDetailsByHotelId(int hotel_id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
    @Override
    public List<Hotel> showAllHotels() {
		// TODO Auto-generated method stub
		List<Hotel> hotel= hd.findAll();
		if(hotel.isEmpty())
			throw new HotelNotFoundException("No Hotels to show");
		else
			return hotel;
	}
    @Override
	public Hotel showHotel(int hotel_id) {
		Optional<Hotel> op= hd.findById(hotel_id);
		if(op.isPresent())
			return op.get();
    	else
        throw new HotelIdNotFoundException("Hotel Not Found For id: "+hotel_id);
	   }
    @Override
	public Hotel updateHotel(int id, @Valid Hotel hotel) {
		// TODO Auto-generated method stub
		if(id==hotel.getHotel_id())
		{
			Hotel updatedhotel= hd.save(hotel);
			return updatedhotel;
		}
		else
         throw new IdNotMatchedException("Id is not matched in path variable");
	   }
    @Override
	public String removeHotel(int id) {
		// TODO Auto-generated method stub
		if(hd.existsById(id))
		{
		hd.deleteById(id);
		return "Deleted Successfully for Id: "+id;
		}
		return "Record Not Found for Id: "+id;
	}
    @Override
	public Hotel findByHotelName(String hName) {
		// TODO Auto-generated method stub
		Optional<Hotel> op= hd.findByHotelName(hName);
		if(op.isPresent())
			return op.get();
		else
			throw new HotelNameNotFoundException("Hotel name not found :"+ hName);
	}

//	public List<RoomDetails> findRoomDetailsByHotelId(int hotel_id) {
//		// TODO Auto-generated method stub
//	    Optional<RoomDetails> roomdetails=hd.findAllByRoomDetails(hotel_id);
//	    if(roomdetails.isPresent())
//			return (List<RoomDetails>) roomdetails.get();
//		else
//			throw new NoRoomDetailsFoundException("Rooms are not there for Hotel ID :"+ hotel_id);
//	}

	
}
