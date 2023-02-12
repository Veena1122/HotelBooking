package com.sprint1.HBA.Controllers;


import java.util.Arrays;
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

import com.sprint1.HBA.entities.BookingDetails;
import com.sprint1.HBA.entities.Hotel;
import com.sprint1.HBA.entities.RoomDetails;
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
	//ResponseEntity clubs our response data and status code internally..
	public ResponseEntity<Hotel> addHotel(@Valid @RequestBody Hotel hotel)
	{
		Hotel hotell= hs.addHotel(hotel);
		ResponseEntity<Hotel> Rentity=new ResponseEntity<Hotel>(hotell,HttpStatus.CREATED);
		return Rentity;
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
		ResponseEntity<Hotel> Rentity=new ResponseEntity<Hotel>(hotel,HttpStatus.FOUND);
		return Rentity;
		
	}
	@Operation(summary="To get the Hotel by Name...")
	@GetMapping("/hotels/byName/{hName}")
	public ResponseEntity<Hotel> findTraineeByName(@PathVariable("hName") String tName)
	{
		Hotel tra=hs.findByHotelName(tName);
		ResponseEntity<Hotel> Rentity=new ResponseEntity<Hotel>(tra,HttpStatus.FOUND);
		return Rentity;
	}
	@Operation(summary="To Update the Hotel by Id...")
	@PutMapping("/hotels/{id}")					
	public ResponseEntity<Hotel> modifyHotel(@PathVariable("id") int id,@Valid @RequestBody Hotel hotel)
	{
		Hotel hotell= hs.updateHotel(id,hotel);
		ResponseEntity<Hotel> REntity=new ResponseEntity<Hotel>(hotell,HttpStatus.ACCEPTED);
		return REntity;
	}
	@Operation(summary="To delete the Hotel by Id...")
	@DeleteMapping("/hotels/{id}")
	public ResponseEntity<String> deleteHotelById(@PathVariable("id") int id)
	{
		String msg= hs.removeHotel(id);
		ResponseEntity<String> REntity=new ResponseEntity<String>(msg,HttpStatus.OK);
		return REntity;
	}
	

	
	
	//       //MappedMethod
//       @Operation(summary="To get Room details by hotel_Id")
//       @GetMapping("/hotels/room_details/{id}")
//    	public List<RoomDetails> findRoomDetailsByHotelId(@PathVariable("id") int hotel_id)
//       {		
//          //List<RoomDetails> roomdetails=hs.findRoomDetailsByHotelId(hotel_id);
//		  List<RoomDetails> Rentity=Arrays.asList(rt.getForObject(url+"/"+hotel_id, RoomDetails[].class));
//     	  return Rentity;
//	   }
//     	 
//     	 
////      //MappedMethod
////   	  @Operation(summary="To get the Booking Details by HotelID...")
////     @GetMapping("/hotels/booking_details/{hotel_id}")
////     public ResponseEntity<RoomDetails> findBookingDetailsByHotelId(@PathVariable("id") int hotel_id)
////	{
////   		  String url1="";
////	    //RoomDetails Roomdetails=hs.findBookingDetailsByHotelId(hotel_id);
////   		ResponseEntity<BookingDetails> Rentity=rt.getForObject(url+"/"+hotel_id, ResponseEntity.class);
////   	    return Rentity;
////    }
//	//by range
////	@GetMapping("/hotels/booking_details/")
////	public ResponseEntity<RoomDetails> findBookingDetailsBetweenRange(@PathVariable("id") int hotel_id)
////	{
////		RoomDetails Roomdetails=hs.findBookingDetailsByHotelId(hotel_id);
////		ResponseEntity<RoomDetails> Rentity=new ResponseEntity<RoomDetails>(Roomdetails,HttpStatus.FOUND);
////		return Rentity;
////		
////	}
//	
	

}
