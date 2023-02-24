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
	
	public String insertBookingDetails(BookingDetails bookingdetails) 
	{
		bookingdetails.AddBookingIdToRoomDetails(bookingdetails.getRoomdetails1());
		BookingDetails bd=bdd.save(bookingdetails);
		return "Booking Registered Successfully with Booking ID: "+bd.getBookingId()+" Proceed to do transaction Rs."+bd.getAmount();
		
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

	public BookingDetails findByBookingId(int bookingId) 
	{
		Optional<BookingDetails> op=bdd.findById(bookingId);
		if(op.isPresent()) 
		{
			return op.get();
		}
		else
			throw new BookingDetailsByIdNotFoundException("No Bookings by Id Found:"+bookingId);
			
	}

	public BookingDetails updateBookingDetails(int bookingId, BookingDetails bookingId1)
	{
		if(bookingId==bookingId1.getBookingId()) 
		{
			if(bdd.existsById(bookingId))
			{
				BookingDetails bd=bdd.save(bookingId1);
				return bd;
			}
			else {
				throw new BookingDetailsByIdNotFoundException("Booking Details not found for Id:"+bookingId);
			}
		}
		return null;

		
	}

	public String deleteById(int bookingId)
	{
		if(bdd.existsById(bookingId))
		{
			bdd.deleteById(bookingId);
			return "Deleted Successfully with id:"+bookingId;
		}
		throw new BookingDetailsByIdNotFoundException("Booking Not found for Id: " + bookingId);
	}

	public BookingDetails findByUserId(int userId) {
		// TODO Auto-generated method stub
		return bdd.findByUserss(userId);
		
	}

	public BookingDetails findByHotelId(int hotelID) {
		// TODO Auto-generated method stub
		return bdd.findByHotell(hotelID);
	}

	

	
}