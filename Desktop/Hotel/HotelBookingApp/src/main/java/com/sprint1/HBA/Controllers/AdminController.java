package com.sprint1.HBA.Controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sprint1.HBA.entities.Admin;
import com.sprint1.HBA.entities.Hotel;
import com.sprint1.HBA.service.AdminService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
public class AdminController {
@Autowired
AdminService as;

@Autowired
RestTemplate rt;

@Operation(summary="Admin Registration ")
@PostMapping("/admins")
 public ResponseEntity<String> addAdmin(@Valid @RequestBody Admin admin) {
      String msg = as.insertAdmin(admin);
      return new ResponseEntity<>(msg, HttpStatus.CREATED);
  }

  @Operation(summary="Fetch All Hotels")
  @GetMapping("/admins/fetchhotels")
  public List<Hotel> fetchAllHotels()
     { 
	  String url="http://localhost:8070/hotels/";
	   return Arrays.asList(rt.getForObject(url,Hotel[].class));
     }
  
  @Operation(summary="Admin Login using Correct ID Name and Password")
  @PostMapping("/admins/authenticate")
  public String authenticateAdmin(@Valid @RequestBody Admin admin) {
  return as.authenticateAdmin(admin);
  }
}