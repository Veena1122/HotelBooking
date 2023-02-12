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

	@PostMapping("/userss")
	public ResponseEntity<Userss> addUser(@Valid @RequestBody Userss users) {
		Userss ur = es.addUser(users);
		ResponseEntity<Userss> rEntity = new ResponseEntity<Userss>(ur, HttpStatus.CREATED);
		return rEntity;
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<Userss> getUserDetails(@PathVariable ("id") int userId) {
		Userss ur = es.getUserDetails(userId);
		ResponseEntity<Userss> rEntity = new ResponseEntity<Userss>(ur, HttpStatus.FOUND);
		return rEntity;
		}
	
	@GetMapping("/users")
    public ResponseEntity<List<Userss>> getAllUserAll() {
		// List<User> a= es.getAllUserAll();
		List<Userss> alist = es.getAllUserAll();
		ResponseEntity<List<Userss>> rEntity = new ResponseEntity<List<Userss>>(alist, HttpStatus.FOUND);
		return rEntity;

	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity <String> deleteUser(@PathVariable ("id") int userId ) {
		String alist= es.deleteUser(userId);
		ResponseEntity<String> rEntity = new ResponseEntity <String>(alist, HttpStatus.FOUND);
		return rEntity;

	}
		
	
	

}