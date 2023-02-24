package com.sprint1.HBA;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint1.HBA.entities.Hotel;
import com.sprint1.HBA.repositories.HotelDao;
import com.sprint1.HBA.service.HotelService;

@SpringBootTest
public class HotelServiceTest {
	
	@Autowired
	private HotelService service;
	
	@MockBean
	private HotelDao hoteldao;
	
	
	@Test
	public void addHotelTest()
	{
	Hotel hotel=new Hotel(1,"Mumbai","Paradise");
	when(hoteldao.save(hotel)).thenReturn(hotel);
	assertEquals(hotel, service.addHotel(hotel));
	}
	 
	@Test
	public void updateHotelTest()
	{
		Hotel hotel=new Hotel(1,"Mumbai","Paradise");
		when(hoteldao.save(hotel)).thenReturn(hotel);
		assertEquals(hotel, service.updateHotel(hotel.getHotelId(),hotel));
		}

	@Test
	public void findByHotelNameTest()
	{
		Hotel hotel=new Hotel(1,"Mumbai","Paradise");
		when(hoteldao.findByHotelName(hotel.getHotelName())).thenReturn(hotel);
		assertEquals(hotel, service.findByHotelName(hotel.getHotelName()));
	}

  
	@Test
	public void removeHotelTest()
	{
		Hotel hotel=new Hotel(1,"Mumbai","Paradise");
		String msg="Deleted Successfully for Id: "+hotel.getHotelId();
		when(hoteldao.existsById(hotel.getHotelId())).thenReturn(true);
		Mockito.doNothing().when(hoteldao).deleteById(hotel.getHotelId());
		assertEquals(msg, service.removeHotel(hotel.getHotelId()));
	}	

}
