package com.sprint1.HBA;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint1.HBA.entities.BookingDetails;
import com.sprint1.HBA.repositories.BookingDetailsDao;
import com.sprint1.HBA.service.BookingDetailsService;

@SpringBootTest
public class BookingDetailsServiceTest {

	@Autowired
	private BookingDetailsService service;

	@MockBean
	private BookingDetailsDao dao;

	
    @Test
	public void insertBookingDetailsTest() {
		
		BookingDetails bd=new BookingDetails(1,2,1,4000);
		String str="Booking Registered Successfully with Booking ID: "+bd.getBookingId()+" Proceed to do transaction Rs."+bd.getAmount();
		when(dao.save(bd)).thenReturn(bd);
		assertEquals(str, service.insertBookingDetails(bd));

		
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
		String msg="Deleted Successfully with id:"+bds.getBookingId();
		when(dao.existsById(bds.getBookingId())).thenReturn(true);
		Mockito.doNothing().when(dao).deleteById(bds.getBookingId());
		assertEquals(msg, service.deleteById(bds.getBookingId()));
	}	
	
	@Test
	public void updateBookingDetailsTest()
	{
		BookingDetails bds=new BookingDetails(1,2,1,4000);
		when(dao.existsById(bds.getBookingId())).thenReturn(true);
		when(dao.save(bds)).thenReturn(bds);
		assertEquals(bds, service.updateBookingDetails(bds.getBookingId(),bds));
	}
	


}
