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

import com.sprint1.HBA.entities.BookingDetails;
import com.sprint1.HBA.service.BookingDetailsService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class BookingDetailsController {
	@Autowired
	BookingDetailsService bds;
	@Operation(summary="To add Booking Details...")
	@PostMapping("/bookings")
	public ResponseEntity<BookingDetails> addBookingDetails(@Valid @RequestBody BookingDetails bookingdetails) 
	{
		BookingDetails msg=bds.insertBookingDetails(bookingdetails);
		ResponseEntity<BookingDetails> rEntity=new ResponseEntity<BookingDetails>(msg,HttpStatus.CREATED);
		return rEntity;
		
	}
	@Operation(summary="To get all Booking Details...")
	@GetMapping("/bookings")
	public ResponseEntity<List<BookingDetails>> findAllBookingDetails()
	{
		List<BookingDetails> bd=bds.findAll();
		ResponseEntity<List<BookingDetails>> rEntity=new ResponseEntity<List<BookingDetails>>(bd,HttpStatus.NOT_FOUND);
		return rEntity;
		
	}
	@Operation(summary="To get Booking Details by Id...")
	@GetMapping("/bookings/{id}")
	public ResponseEntity<BookingDetails> findById(@PathVariable ("id") int booking_id)
	{
		BookingDetails bd=bds.findByBookingId(booking_id);
		ResponseEntity<BookingDetails> rEntity=new ResponseEntity<BookingDetails>(bd,HttpStatus.FOUND);
		return rEntity;
		
	}
	@Operation(summary="To update Booking Details by Id...")
	@PutMapping("/bookings/{id}")
	public ResponseEntity<BookingDetails> modifyBookingDetails(@PathVariable ("id") int booking_id,@Valid @RequestBody BookingDetails booking_id1)
	{
		BookingDetails tr=bds.updateBookingDetails(booking_id,booking_id1);
		ResponseEntity<BookingDetails> rEntity=new ResponseEntity<BookingDetails>(tr,HttpStatus.ACCEPTED);
		return rEntity;
	}
	@Operation(summary="To delete Booking Details by Id...")
	@DeleteMapping("/bookings/{id}")
	public ResponseEntity<String> deleteBookingDetails(@PathVariable ("id") int booking_id) 
	{
		String tr=bds.deleteById(booking_id);
		ResponseEntity<String> rEntity=new ResponseEntity<String>(tr,HttpStatus.ACCEPTED);
		return rEntity;
	}

}