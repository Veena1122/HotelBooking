package com.sprint1.HBA;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint1.HBA.entities.BookingDetails;
import com.sprint1.HBA.repositories.BookingDetailsDao;
import com.sprint1.HBA.service.BookingDetailsService;



@SpringBootTest
class HotelBookingAppApplicationTests {

	@Autowired
	private BookingDetailsService service;

	@MockBean
	private BookingDetailsDao dao;

	
	@Test
	public void insertBookingDetailsTest()
	{
		
		BookingDetails bd=new BookingDetails(1,2,1,4000);
		when(dao.save(bd)).thenReturn(bd);
		assertEquals(bd, service.insertBookingDetails(bd));
		//Mockito.verify(bd, Mockito.times(1);
	}
	

	@Test
	public void findAllTest()
	{
		when(dao.findAll()).thenReturn(Stream.of(new BookingDetails(1,2,1,4000)).collect(Collectors.toList()));
		assertEquals(1,service.findAll().size());
		}
	
	@Test
	public void findByBookingIdTest()
	{
		int id=1;
		doReturn(Optional.of(new BookingDetails(1,2,1,4000))).when(dao).findById(id);
	}
	
	@Test
	public void deleteByIdTest()
	{
		BookingDetails bds=new BookingDetails(1,2,1,4000);
		String msg="Deleted Successfully with id:"+bds.getBooking_id();
		when(dao.existsById(bds.getBooking_id())).thenReturn(true);
		Mockito.doNothing().when(dao).deleteById(bds.getBooking_id());
		assertEquals(msg, service.deleteById(bds.getBooking_id()));
	}	
	
	
//	@Test
//	public void updateBookingDetailsTest() 
//	{
//		BookingDetails bd=new BookingDetails(1,2,1,4000);
//		String msg="Updated Successfully with id:"+bd.getBooking_id();
//		when(dao.existsById(bd.getBooking_id())).thenReturn(true);
//		Mockito.doNothing().when(dao).BookingDetails(bd.getBooking_id());
//		assertEquals(msg,service.updateBookingDetails(bd.getBooking_id(),bd));
//		
//	}
	
/*	public void updateBookingDetailsTest() 
	{
		// Create a new user object to update
		BookingDetails updateBooking = new BookingDetails(1,2,1,4000);
		when(dao.findById(updateBooking.getBooking_id())).thenReturn(Optional.of(updateBooking));
		BookingDetails returnedUser = service.updateBookingDetails(updateBooking, updateBooking.getBooking_id());
		assertEquals(updateBooking, returnedUser);
		}
	*/
	
	
//	@Test
//	public void updateBookingDetailsTest()
//	{
//		BookingDetails bds=new BookingDetails();
//		String msg="Updated Successfully with id:"+bds.getBooking_id();
//		when(dao.save(bds)).thenReturn(bds);
//		assertEquals(bds, service.updateBookingDetails(bds.getBooking_id(),bds));
////		Hotel hot=service.updateHotel(hotel.getHotel_id(),hotel);
////		String str=hot.getHotelName();
////		assertEquals(hotel.getHotelName(),str);
//		
//	}
	
//	public void testUpdateUser() 
//	{
//		// Create a new user object to update
//		Users updateUser = new Users(1, "jayanth", "jayanth@gmail.com", "Jayanthnoob", "seghrr", "9898765897","new wahsemenpet");
//		when(rRepository.findById(updateUser.getUser_id())).thenReturn(Optional.of(updateUser));
//		Users returnedUser = rService.updateUser(updateUser, updateUser.getUser_id());
//		assertEquals(updateUser, returnedUser);
//		}

	@Test
	public void updateBookingDetailsTest()
	{
		BookingDetails bds=new BookingDetails(1,2,1,4000);
		when(dao.existsById(bds.getBooking_id())).thenReturn(true);
		when(dao.save(bds)).thenReturn(bds);
		assertEquals(bds, service.updateBookingDetails(bds.getBooking_id(),bds));
		
	}
	
}

