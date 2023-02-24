package com.sprint1.HBA.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.HBA.entities.Admin;
import com.sprint1.HBA.repositories.AdminDao;


@Service
public class AdminService {
	@Autowired
	AdminDao ad;
	public String insertAdmin(Admin admin)
	{
		ad.save(admin);
		return "Admin Registered Successfully";
	}
	
     public String authenticateAdmin(Admin admin) {
		
		Optional<Admin> opAdmin=ad.findById(admin.getAdminId());
		if(opAdmin.isPresent()) {
			Admin dbAdmin=opAdmin.get();
			if(admin.getAdminPassword().equals(dbAdmin.getAdminPassword())) {
				return "Authenticated Successfully";
				}
			else
				return "Incorrect Password";
		}
		else return "No Admin";
	}
}




