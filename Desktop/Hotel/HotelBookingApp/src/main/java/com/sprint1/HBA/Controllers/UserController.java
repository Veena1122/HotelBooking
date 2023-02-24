package com.sprint1.HBA.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.HBA.entities.Userss;
import com.sprint1.HBA.service.UserService;



@RestController
public class UserController {
	@Autowired
	UserService es;

	@PostMapping("/users")
	public ResponseEntity<String> addUser(@Valid @RequestBody Userss users) {
		Userss ur = es.addUser(users);
		String msg="User registered Successfully with user id: "+ur.getUserId();
	  return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<Userss> getUserDetails(@PathVariable ("id") int userId) {
		Userss ur = es.getUserDetails(userId);
		return new ResponseEntity<>(ur, HttpStatus.FOUND);
		}
	

	@GetMapping("/users")
    public ResponseEntity<List<Userss>> getAllUserAll() {
		List<Userss> alist = es.getAllUserAll();
		 return new ResponseEntity<List<Userss>>(alist, HttpStatus.FOUND);

	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity <String> deleteUser(@PathVariable ("id") int userId ) {
		String alist= es.deleteUser(userId);
		return new ResponseEntity <>(alist, HttpStatus.FOUND);

	}
		
	
	

}