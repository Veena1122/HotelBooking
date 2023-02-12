package com.sprint1.HBA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.HBA.entities.Admin;
import com.sprint1.HBA.repositories.AdminDao;


@Service("as")
public class AdminService {
	@Autowired
	AdminDao ad;
	public String insertAdmin(Admin admin)
	{
		Admin dbAdmin = ad.save(admin);
		return "Admin Registered Successfully";
	}
	
     public String authenticateAdmin(Admin admin) {
		
		Optional<Admin> opAdmin=ad.findById(admin.getAdminId());
		if(opAdmin.isPresent()) {
			Admin dbAdmin=opAdmin.get();
			if(admin.getAdminPassword().equals(dbAdmin.getAdminPassword()))
				return "Authenticated Successfully";
			else
				return "Incorrect Password";
		}
		
		return null;
	}
}





//public List<Admin> findAll(){
//List<Admin> list = ad.findAll();
//if (list.isEmpty()) {
//	throw new NoBookingDetailsFoundByIdException("No Admin found");
//}
//return list;
//}

//public Admin findByAdminId(int adminId) throws NoBookingDetailsFoundByIdException {
//Optional<Admin> op = ad.findById(adminId);
//if (op.isPresent()) {
//	return op.get();
//} else {
//	throw new NoBookingDetailsFoundByIdException("Admin Not Found For adminId:" + adminId);
//}
//}
//public String updateAdmin(int adminId, Admin admin) throws NoBookingDetailsFoundByIdException{
//if (adminId == admin.getAdminId())
//{
//	Admin upAdmin = ad.save(admin);
//	return "Updated Successfully for AdminId:" + upAdmin.getAdminId();
//}
//throw new NoBookingDetailsFoundByIdException("Admin Not Found For adminId:" + adminId);
//}

//public String deleteById(int adminId) throws NoBookingDetailsFoundByIdException {
//if (ad.existsById(adminId))
//{
//	ad.deleteById(adminId);
//	return "Deleted Successfully for Admind:" + adminId;
//	}
//
//throw new NoBookingDetailsFoundByIdException("Admin Not Found For adminId:" + adminId);
//}
//
//public String addAdmin(Admin admin) {


////admin.setAdminPassword(encryptedPwd);
//Admin savedAdmin=ad.save(admin);
//return savedAdmin.getAdminName()+"added to database successfully";
//}


