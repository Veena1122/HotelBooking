package com.sprint1.HBA.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.HBA.entities.RoomDetails;
import com.sprint1.HBA.service.RoomDetailsService;

import io.swagger.v3.oas.annotations.Operation;



@RestController
public class RoomDetailsController {
	private static final List<RoomDetails> tr = null;
	@Autowired
	RoomDetailsService rs;
	@PostMapping("/roomdetails")
	public ResponseEntity<RoomDetails> addRoomDetails(@Valid @RequestBody RoomDetails rmD)
	{
		RoomDetails msg=rs.insertRoomDetails(rmD);
		ResponseEntity<RoomDetails> rEntity=new ResponseEntity<RoomDetails>(msg,HttpStatus.CREATED);
		return rEntity;
	}
	@GetMapping("/roomdetails")
	public ResponseEntity<List<RoomDetails>> fetchAllRoomDetails()
	{	
		List<RoomDetails> tr=rs.findAll();
		ResponseEntity<List<RoomDetails>> rEntity=new ResponseEntity<List<RoomDetails>>(tr,HttpStatus.FOUND);
		return rEntity;
	}
	@GetMapping("/roomdetails/{id}")
	public ResponseEntity<RoomDetails> findRoomDetailsById(@PathVariable ("id") int id)
	{
		RoomDetails tr=rs.findByRoomId(id);
		ResponseEntity<RoomDetails> rEntity=new ResponseEntity<RoomDetails>(tr,HttpStatus.FOUND);
		return rEntity;
	}
	@GetMapping("/roomdetails/bytype/{type}")
	public ResponseEntity<RoomDetails> findRoomDetailsByType(@PathVariable ("type") String rtype)
	{
		RoomDetails tr= rs.findByRoom_type(rtype);
		ResponseEntity<RoomDetails> rEntity=new ResponseEntity<RoomDetails>(tr,HttpStatus.FOUND);
		return rEntity;
	}
//	@GetMapping("/roomdetails/byhotelid/{id}")
//	public ResponseEntity<RoomDetails> findRoomDetailsByType(@PathVariable ("id") int hid)
//	{
//		RoomDetails tr= rs.findByHotel_id(hid);
//		ResponseEntity<RoomDetails> rEntity=new ResponseEntity<RoomDetails>(tr,HttpStatus.FOUND);
//		return rEntity;
//	}
	
	//MappedMethod
	@Operation(summary="To get Room details by hotel_Id")
    @GetMapping("/roomdetails/byhotelid/{hotel_id}")
	public List<RoomDetails> findRoomDetailsByHotelId(@PathVariable("hotel_id") int hotel_id)
    {	 
    List<RoomDetails> roomdetails=rs.findRoomDetailsByHotelId(hotel_id);
	//ResponseEntity<List<RoomDetails>> Rentity=new ResponseEntity<List<RoomDetails>>(roomdetails,HttpStatus.FOUND);
	return roomdetails;
    }
	
	@PutMapping("/roomdetails/{id}")
	public ResponseEntity<RoomDetails> modifyRoomDetails(@Valid @PathVariable("id") int id,@RequestBody RoomDetails tid) 
	{
		RoomDetails tr=rs.updateRoomDetails(id,tid);
		ResponseEntity<RoomDetails> rEntity=new ResponseEntity<RoomDetails>(tr,HttpStatus.ACCEPTED);
		return rEntity;
	}
	
	@DeleteMapping("/roomdetails/{id}")
	public ResponseEntity<String> deleteroomdetailsById(@PathVariable("id") int id)
	{
		String tr=rs.deleteById(id);
		ResponseEntity<String> rEntity=new ResponseEntity<String>(tr,HttpStatus.ACCEPTED);
		return rEntity;
	}
}
