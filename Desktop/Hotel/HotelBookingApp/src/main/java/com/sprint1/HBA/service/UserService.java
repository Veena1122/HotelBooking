package com.sprint1.HBA.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.HBA.entities.Userss;
import com.sprint1.HBA.exceptions.UserNotFoundException;
import com.sprint1.HBA.repositories.UserDao;
@Service("es")
@Transactional
public class UserService{
	@Autowired
	UserDao ud;

// add user
	public Userss addUser(Userss user) {
		
		return ud.save(user);
	}

//show all user
	public List<Userss> getAllUserAll(){
		List<Userss> list = ud.findAll();
		if (list.isEmpty()) {
			throw new UserNotFoundException("No Users Found");
		}
     return list;
	}

// show user by id
	public Userss getUserDetails(int id) throws UserNotFoundException {
		Optional<Userss> op = ud.findById(id);
		if (op.isPresent()) {
			return op.get();
			}
		else{
			throw new UserNotFoundException(" User Id not found" + id);

		}
	}

	public String deleteUser(int userId) {
		//Optional<User> optUser = ud.findById((userId));
		if (ud.existsById(userId)) {
			ud.deleteById(userId);
			return "deleted successfully";
			
		}
		throw new UserNotFoundException("No user Found with id" + userId);

		
	}
	public Userss updateUser(Userss updateUser, int userId) 
	{
		Optional<Userss> findUserById = ud.findById(userId);
		if (findUserById.isPresent()) {
			ud.save(updateUser);
			}
		else throw new UserNotFoundException("User with Id: " + userId + " not exists!!");
		return updateUser;
		}
	

}
