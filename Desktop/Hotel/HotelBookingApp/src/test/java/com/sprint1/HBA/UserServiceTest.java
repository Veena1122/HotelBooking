package com.sprint1.HBA;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint1.HBA.entities.Userss;
import com.sprint1.HBA.repositories.UserDao;
import com.sprint1.HBA.service.UserService;

@SpringBootTest
public class UserServiceTest {
	@Autowired
	private UserService rService;
	
	@MockBean
	private UserDao rRepository;
	
	
	@Test
	public void testUpdateUserTest() 
		{
			Userss updateUser = new Userss(1, "jayanth", "jayanth@gmail.com", "Jayanthnoob", "seghrr", "9898765897","new wahsemenpet");
			when(rRepository.findById(updateUser.getUserId())).thenReturn(Optional.of(updateUser));
			Userss returnedUser = rService.updateUser(updateUser, updateUser.getUserId());
			assertEquals(updateUser, returnedUser);
		}

	@Test
	public
	void viewUsersTest() {
		int user_id = 1;
		Userss ut = new Userss(1, "jayanth", "paradise@gmail.com", "Jayanthnoob", "seghrr", "9898765897",
				"new wahsemenpet");
		when(rRepository.findById(user_id)).thenReturn(Optional.of(ut));
		Userss et = rService.getUserDetails(user_id);
		assertEquals(ut, et);
	}
	@Test
	public void testViewAllUsersTest() {
		List<Userss> expectedUsers = Arrays.asList(new Userss(1,"jayanth","paradise@gmail.com","Jayanthnoob","seghrr","9898765897","new wahsemenpet"),(new Userss(2,"rithik","noob@gmail.com","rithikthnoob","tyruwer","9898765765"," wahsemenpet")));
		when(rRepository.findAll()).thenReturn(expectedUsers);
		List<Userss> actualUsers = rService.getAllUserAll();assertEquals(expectedUsers, actualUsers);}
	
	@Test
	public void removeUsersTest() {
			Userss u = new Userss(1, "jayanth", "paradise@gmail.com", "Jayanthnoob", "seghrr", "9898765897","new wahsemenpet");
			String msg = "deleted successfully";
			when(rRepository.existsById(u.getUserId())).thenReturn(true);
			Mockito.doNothing().when(rRepository).deleteById(u.getUserId());
			assertEquals(msg, rService.deleteUser(u.getUserId()));
}
		}
