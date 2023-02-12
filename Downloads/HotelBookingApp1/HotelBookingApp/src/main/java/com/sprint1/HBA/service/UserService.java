package com.sprint1.HBA.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.HBA.entities.Userss;
import com.sprint1.HBA.exceptions.InvalidUserException;
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
			throw new UserNotFoundException("No Transaction  Found");
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
			throw new UserNotFoundException("Id not found" + id);

		}
		}

//delete user
//	public List<User> deleteUser(int userId) throws UserNotFoundException {
//		Optional<User> optUser = ud.findById((userId));
//		if (optUser.isPresent()) {
//			throw new UserNotFoundException("No user Found with id" + userId);
//
//		}
//		ud.deleteById(userId);
//		return null;
//	}

//validate user
	public void validateUser(Userss user) throws InvalidUserException {
		String phoneNo = user.getUser_mobile();
		String phno = phoneNo.toString();
		Pattern p = Pattern.compile("^[1-9][0-9]{9}$");
		Matcher m = p.matcher(phno);
		String email = user.getUser_email();
		Pattern p1 = Pattern.compile("^[A-Za-z0-9]*@[a-zA-Z]+[.][a-zA-Z]{2,4}$");
		Matcher m1 = p1.matcher(email);
		if ((!m1.matches()) && (m.matches())) {
			throw new InvalidUserException("Email is invalid");
		}
		else if ((!m.matches()) && (m1.matches())) {
			throw new InvalidUserException("Phone number is invalid");
		} else if ((!m.matches()) && (!m1.matches())) {
			throw new InvalidUserException("Phone number and email are invalid");
		}

	}
//
//	public List<User> deleteUser() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public String deleteUser(int userId) {
		//Optional<User> optUser = ud.findById((userId));
		if (ud.existsById(userId)) {
			ud.deleteById(userId);
			return "deleted successfully";
			
		}
		throw new UserNotFoundException("No user Found with id" + userId);

		
	}
}
