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
	@Autowired
	RoomDetailsService rs;
	@PostMapping("/roomdetails")
	public ResponseEntity<String> addRoomDetails(@Valid @RequestBody RoomDetails rmD)
	{
		String msg=rs.insertRoomDetails(rmD);
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}
	@GetMapping("/roomdetails")
	public ResponseEntity<List<RoomDetails>> fetchAllRoomDetails() 
	{	
		List<RoomDetails> rooms=rs.findAll();
	    return new ResponseEntity<List<RoomDetails>>(rooms,HttpStatus.FOUND);
		
	}
	@GetMapping("/roomdetails/{id}")
	public ResponseEntity<RoomDetails> findRoomDetailsById(@PathVariable ("id") int id)
	{
		RoomDetails rooms=rs.findByRoomId(id);
		return new ResponseEntity<>(rooms,HttpStatus.FOUND);
	}
	@GetMapping("/roomdetails/bytype/{type}")
	public ResponseEntity<RoomDetails> findRoomDetailsByType(@PathVariable ("type") String rtype)
	{
		RoomDetails rooms= rs.findByRoom_type(rtype);
		return new ResponseEntity<>(rooms,HttpStatus.FOUND);
	}

	@Operation(summary="To get Room details by hotel_Id")
    @GetMapping("/roomdetails/byhotelid/{hotel_id}")
	public List<RoomDetails> findRoomDetailsByHotelId(@PathVariable("hotel_id") int hotelId)
    {	 
    return rs.findRoomDetailsByHotelId(hotelId);
    }
	
	@PutMapping("/roomdetails/{id}")
	public ResponseEntity<String> modifyRoomDetails(@Valid @PathVariable("id") int id,@RequestBody RoomDetails tid) 
	{
		String rooms=rs.updateRoomDetails(id,tid);
	    return new ResponseEntity<>(rooms,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/roomdetails/{id}")
	public ResponseEntity<String> deleteroomdetailsById(@PathVariable("id") int id)
	{
		String rooms=rs.deleteById(id);
		return new ResponseEntity<>(rooms,HttpStatus.ACCEPTED);
	}
	
}
