package com.sprint1.HBA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.HBA.entities.RoomDetails;
import com.sprint1.HBA.exceptions.IdNotMatchedException;
import com.sprint1.HBA.exceptions.NoRoomDetailsFoundByIdException;
import com.sprint1.HBA.exceptions.NoRoomDetailsFoundException;
import com.sprint1.HBA.repositories.RoomDetailsDao;




@Service("rs")
@Transactional
public class RoomDetailsService {
	@Autowired
	RoomDetailsDao rd;
	public String insertRoomDetails(RoomDetails tin) {
		RoomDetails rdTin=rd.save(tin);	
		return "Added Successfully with No:"+rdTin.getRoomNo();
	}
	public List<RoomDetails> findAll() {
		List<RoomDetails> list =rd.findAll();
		if(list.isEmpty()) {
			throw new NoRoomDetailsFoundException("No Room Details found");
		}
		return list;
	}
	public RoomDetails findByRoomId(int id) {
		Optional<RoomDetails> op=rd.findById(id);
		if(op.isPresent()) {
			return op.get();
		}else {
			throw new NoRoomDetailsFoundByIdException("No Room Details found By Id"+id);
		}	
	}
	public RoomDetails findByRoom_type(String type) {
		Optional<RoomDetails> op=rd.findByRoomType(type);
		if(op.isPresent()) {
			return op.get();
		}
			throw new NoRoomDetailsFoundByIdException("No Room Details found By type"+type);
	}
	public String updateRoomDetails(int id, RoomDetails tid) {
		if(id==tid.getRoomId())
		{
			if(rd.existsById(id)) {
				RoomDetails upTin=rd.save(tid);
				return "Updated Successfully for id:"+upTin.getRoomId();
			}else {
				throw new NoRoomDetailsFoundByIdException("No Room Details found for Id:"+id);
			}
		}		
		throw new IdNotMatchedException("id not matched for Id:"+id);

		
	}
	public String deleteById(int id) {
		if(rd.existsById(id))
		{
			rd.deleteById(id);
			return"Deleted Successfully for Id:"+id;
		}
		throw new NoRoomDetailsFoundByIdException("employee not found for Id:"+id);
	}
	public List<RoomDetails> findRoomDetailsByHotelId(int hotel_id) {
		// TODO Auto-generated method stub
		List<RoomDetails> roomdetails=rd.findAllByHotel(hotel_id);
		return roomdetails;
	}
}