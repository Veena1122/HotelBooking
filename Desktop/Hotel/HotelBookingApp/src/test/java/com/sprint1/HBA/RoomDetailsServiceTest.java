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

import com.sprint1.HBA.entities.RoomDetails;
import com.sprint1.HBA.repositories.RoomDetailsDao;
import com.sprint1.HBA.service.RoomDetailsService;

@SpringBootTest
public class RoomDetailsServiceTest {
	@Autowired
	private RoomDetailsService rService;
	@MockBean
	private RoomDetailsDao rRepository;
	@Test
	public void insertRoomDetailsTest()
	{
		RoomDetails bd=new RoomDetails(1, "13b", "kbed", 000, true);
		when(rRepository.save(bd)).thenReturn(bd);
		String msg="Added Successfully with No:"+bd.getRoomNo();
		assertEquals(msg, rService.insertRoomDetails(bd));
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
	public void findByRoomTypeTest()
	{
		String roomType="kbed";
		doReturn(Optional.of(new RoomDetails(1, "13b", "kbed", 12000, true))).when(rRepository).findByRoomType(roomType);
		}
	@Test
	public void updateRoomDetailsTest()
	{
		RoomDetails rd=new RoomDetails(1, "13b", "kbed", 12000, true);
		when(rRepository.existsById(rd.getRoomId())).thenReturn(true);
		when(rRepository.save(rd)).thenReturn(rd);
		String msg="Updated Successfully for id:"+rd.getRoomId();
		assertEquals(msg, rService.updateRoomDetails(rd.getRoomId(),rd));
		}
	
	@Test
	public void deleteByIdTest() 
	{
		RoomDetails rd=new RoomDetails(122, "13b", "kbed", 12000, true);
		String msg="Deleted Successfully for Id:"+rd.getRoomId();
		when(rRepository.existsById(rd.getRoomId())).thenReturn(true);
		Mockito.doNothing().when(rRepository).deleteById(rd.getRoomId());
		assertEquals(msg, rService.deleteById(rd.getRoomId()));
	}

}
