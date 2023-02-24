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

import com.sprint1.HBA.entities.BookingDetails;
import com.sprint1.HBA.entities.RoomDetails;
import com.sprint1.HBA.service.BookingDetailsService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class BookingDetailsController {
	@Autowired
	BookingDetailsService bds;
	@Autowired
	RestTemplate rt;
	
	@Operation(summary="To add Booking Details...")
	@PostMapping("/bookings")
	public ResponseEntity<String> addBookingDetails(@Valid @RequestBody BookingDetails bookingdetails) 
	{
		List<RoomDetails> rooms=bookingdetails.getRoomdetails1();
		int sum=0;
    	for(RoomDetails r: rooms)
		{
			int id=r.getRoomId();
			RoomDetails r1=rt.getForObject("http://localhost:8070/roomdetails/"+id, RoomDetails.class);
			sum=sum + r1.getRatePerDay();
			
		}
		int totalAmount = sum*bookingdetails.getNoOfAdults();
        bookingdetails.setAmount(totalAmount);
		String msg=bds.insertBookingDetails(bookingdetails);
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
		
		
	}
	@Operation(summary="To get all Booking Details...")
	@GetMapping("/bookings")
	public ResponseEntity<List<BookingDetails>> findAllBookingDetails()
	{
		List<BookingDetails> bd=bds.findAll();
		return new ResponseEntity<List<BookingDetails>>(bd,HttpStatus.FOUND);
		
		
	}
	@Operation(summary="To get Booking Details by Id...")
	@GetMapping("/bookings/{id}")
	public ResponseEntity<BookingDetails> findById(@PathVariable ("id") int bookingId)
	{
		BookingDetails bd=bds.findByBookingId(bookingId);
		return new ResponseEntity<>(bd,HttpStatus.FOUND);
		
	}
	@Operation(summary="To get Booking Details by User Id...")
	@GetMapping("/bookings/users/{id}")
	public ResponseEntity<BookingDetails> findByUserId(@PathVariable ("id") int userId)
	{
		BookingDetails bd=bds.findByUserId(userId);
		return new ResponseEntity<>(bd,HttpStatus.FOUND);
		
	}
	@Operation(summary="To get Booking Details by Hotel Id...")
	@GetMapping("/bookings/hotels/{id}")
	public ResponseEntity<BookingDetails> findByHotelId(@PathVariable ("id") int hotelID)
	{
		BookingDetails bd=bds.findByHotelId(hotelID);
		return new ResponseEntity<>(bd,HttpStatus.FOUND);
		
	}

	@Operation(summary="To update Booking Details by Id...")
	@PutMapping("/bookings/{id}")
	public ResponseEntity<BookingDetails> modifyBookingDetails(@PathVariable ("id") int bookingId,@Valid @RequestBody BookingDetails bookingId1)
	{
		List<RoomDetails> rooms=bookingId1.getRoomdetails1();
		int sum=0;
    	for(RoomDetails r: rooms)
		{
			int id=r.getRoomId();
			RoomDetails r1=rt.getForObject("http://localhost:8070/roomdetails/"+id, RoomDetails.class);
			sum=sum + r1.getRatePerDay();
			
		}
		int totalAmount = sum*bookingId1.getNoOfAdults();
		bookingId1.setAmount(totalAmount);
		BookingDetails tr=bds.updateBookingDetails(bookingId,bookingId1);
		return new ResponseEntity<>(tr,HttpStatus.ACCEPTED);
		
	}
	@Operation(summary="To delete Booking Details by Id...")
	@DeleteMapping("/bookings/{id}")
	public ResponseEntity<String> deleteBookingDetails(@PathVariable ("id") int bookingId) 
	{
		String tr=bds.deleteById(bookingId);
		return new ResponseEntity<>(tr,HttpStatus.ACCEPTED);
	}

}