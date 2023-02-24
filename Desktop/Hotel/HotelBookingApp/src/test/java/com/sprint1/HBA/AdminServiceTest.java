package com.sprint1.HBA;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint1.HBA.entities.Admin;
import com.sprint1.HBA.repositories.AdminDao;
import com.sprint1.HBA.service.AdminService;

@SpringBootTest
public class AdminServiceTest {
	@Autowired
	private AdminService aService;
	@MockBean
	private AdminDao aRepository;
	
	@Test
	public void insertAdminTest()
	{
		Admin admin = new Admin(1, "Maggiboy","rightuu12345");
		when(aRepository.save(admin)).thenReturn(admin);
		String msg="Admin Registered Successfully";
		assertEquals(msg, aService.insertAdmin(admin));
	}
	@Test
	public void authenticateAdminTest()
	{
		int adminId=1;
		doReturn(Optional.of(new Admin(1, "Maggiboy","rightuu12345"))).when(aRepository).findById(adminId);
		}

}

