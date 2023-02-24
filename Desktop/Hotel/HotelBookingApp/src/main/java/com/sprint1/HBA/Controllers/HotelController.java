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
import org.springframework.web.client.RestTemplate;

import com.sprint1.HBA.entities.Hotel;
import com.sprint1.HBA.service.HotelService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class HotelController {
	
	@Autowired
	RestTemplate rt;
	
	@Autowired
	HotelService hs;
	String url="http://localhost:8070/roomdetails/byhotelid";
	@Operation(summary="ADD Hotels...")
	@PostMapping(value="/hotels")
	public ResponseEntity<Hotel> addHotel(@Valid @RequestBody Hotel hotel)
	{
		Hotel hotell= hs.addHotel(hotel);
		return new ResponseEntity<>(hotell,HttpStatus.CREATED);
		
	}
	
	@Operation(summary="Show All hotels")
	@GetMapping(value="/hotels")
	public List<Hotel> fetchAllHotels()
	{
		return hs.showAllHotels();
	}
	@Operation(summary="To get the Hotel by Id...")
	@GetMapping("/hotels/{id}")					
	public ResponseEntity<Hotel> findHotelById(@PathVariable("id") int id)
	{
		Hotel hotel=hs.showHotel(id);
		return new ResponseEntity<>(hotel,HttpStatus.FOUND);
		
	}
	@Operation(summary="To get the Hotel by Name...")
	@GetMapping("/hotels/byName/{hName}")
	public ResponseEntity<Hotel> findTraineeByName(@PathVariable("hName") String tName)
	{
		Hotel tra=hs.findByHotelName(tName);
		return new ResponseEntity<>(tra,HttpStatus.FOUND);
	
	}
	@Operation(summary="To Update the Hotel by Id...")
	@PutMapping("/hotels/{id}")					
	public ResponseEntity<Hotel> modifyHotel(@PathVariable("id") int id,@Valid @RequestBody Hotel hotel)
	{
		Hotel hotell= hs.updateHotel(id,hotel);
		return new ResponseEntity<>(hotell,HttpStatus.ACCEPTED);
	}
	@Operation(summary="To delete the Hotel by Id...")
	@DeleteMapping("/hotels/{id}")
	public ResponseEntity<String> deleteHotelById(@PathVariable("id") int id)
	{
		String msg= hs.removeHotel(id);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	

}
