package com.sprint1.HBA.roomdetails;

import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint1.HBA.entities.BookingDetails;
import com.sprint1.HBA.entities.RoomDetails;
import com.sprint1.HBA.repositories.RoomDetailsDao;
import com.sprint1.HBA.service.RoomDetailsService;

@SpringBootTest
class RoomDetailsTestCases {

		@Autowired
		private RoomDetailsService rService;
		
		@MockBean
		private RoomDetailsDao rRepository;

		@Test
		public void insertRoomDetailsTest() {
			RoomDetails bd=new RoomDetails(1, "13b", "kbed", 000, true);
		when(rRepository.save(bd)).thenReturn(bd);
		assertEquals(bd, rService.insertRoomDetails(bd));
		}
		
		@Test
		public void findAllTest() 
		{
			when(rRepository.findAll()).thenReturn(Stream.of(new RoomDetails(1, "13b", "kbed", 12000, true)).collect(Collectors.toList()));
			assertEquals(1,rService.findAll().size());
		}
		
		@Test
		public void findByRoomIdTest() 
		{
			int id=2;
		    doReturn(Optional.of(new RoomDetails(1, "13b", "kbed", 12000, true))).when(rRepository).findById(id);
		}

		@Test
		public void updateRoomDetailsTest()
		{
			RoomDetails rd=new RoomDetails(1, "13b", "kbed", 12000, true);
			when(rRepository.existsById(rd.getRoom_id())).thenReturn(true);
			when(rRepository.save(rd)).thenReturn(rd);
			assertEquals(rd, rService.updateRoomDetails(rd.getRoom_id(),rd));	
		}

//		@Test
//		public void findByHotelNameTest()
//		{
//			Hotel hotel=new Hotel(1,"Mumbai","Paradise");
//			when(hoteldao.findByHotelName(hotel.getHotelName())).thenReturn(hotel);
//			assertEquals(hotel, service.findByHotelName(hotel.getHotelName()));
//		}
		
		@Test
		public void deleteByIdTest()
		{
			RoomDetails rd=new RoomDetails(122, "13b", "kbed", 12000, true);
			String msg="Deleted Successfully for Id:"+rd.getRoom_id();
			when(rRepository.existsById(rd.getRoom_id())).thenReturn(true);
			Mockito.doNothing().when(rRepository).deleteById(rd.getRoom_id());
			assertEquals(msg, rService.deleteById(rd.getRoom_id()));
		}
//		@Test
//		void contextLoads() {
//		}


	}


