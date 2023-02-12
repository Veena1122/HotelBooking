package com.sprint1.HBA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.HBA.entities.BookingDetails;
import com.sprint1.HBA.exceptions.BookingDetailsByIdNotFoundException;
import com.sprint1.HBA.exceptions.BookingDetailsNotFoundException;
import com.sprint1.HBA.repositories.BookingDetailsDao;

@Service("bds")
@Transactional
public class BookingDetailsService {
	@Autowired
	BookingDetailsDao bdd;
	
	public BookingDetails insertBookingDetails(BookingDetails bookingdetails) 
	{
		bookingdetails.AddBookingIdToRoomDetails(bookingdetails.getRoomdetails1());
		BookingDetails bd=bdd.save(bookingdetails);
		return bd;
		
	}

	public List<BookingDetails> findAll() 
	{
		List<BookingDetails> list =bdd.findAll();
		if(list.isEmpty())
		{
			throw new BookingDetailsNotFoundException("No Bookings Found");
		}
		return list;
	
		
	}

	public BookingDetails findByBookingId(int booking_id) 
	{
		Optional<BookingDetails> op=bdd.findById(booking_id);
		if(op.isPresent()) 
		{
			return op.get();
		}
		else
			throw new BookingDetailsByIdNotFoundException("No Bookings by Id Found:"+booking_id);
			
	}

	public BookingDetails updateBookingDetails(int booking_id, BookingDetails booking_id1)
	{
		if(booking_id==booking_id1.getBooking_id()) 
		{
			if(bdd.existsById(booking_id))
			{
				BookingDetails bd=bdd.save(booking_id1);
				return bd;
			}
			else {
				throw new BookingDetailsByIdNotFoundException("Booking Details not found for Id:"+booking_id);
			}
		}
		//throw new BookingIdNotMatchedException("Id not matched for Id:"+booking_id);
		return null;

		
	}

	public String deleteById(int booking_id)
	{
		if(bdd.existsById(booking_id))
		{
			bdd.deleteById(booking_id);
			return "Deleted Successfully with id:"+booking_id;
		}
		throw new BookingDetailsByIdNotFoundException("Trainee not found for Id: " + booking_id);
	}

	

	
}