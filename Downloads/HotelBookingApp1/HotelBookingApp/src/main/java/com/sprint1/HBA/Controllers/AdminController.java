package com.sprint1.HBA.Controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
      ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
      return rEntity;
  }

  @Operation(summary="Fetch All Hotels")
  @GetMapping("/admins/fetchhotels")
  public List<Hotel> fetchAllHotels()
     { 
	  String url="http://localhost:8070/hotels/";
	  List<Hotel> Rentity=Arrays.asList(rt.getForObject(url,Hotel[].class));
      return Rentity;
      }
  
  @Operation(summary="ADD HOTELS")
  @PostMapping("/admins/addhotels")
  public List<Hotel> addHotel(@Valid @RequestBody Hotel hotel)
     { 
	  String url="http://localhost:8070/hotels/";
	  List<Hotel> Rentity=Arrays.asList(rt.getForObject(url,Hotel[].class));
      return Rentity;
      }
  @Operation(summary="FETCH HOTELS BY ID")
  @GetMapping("/admins/fetchhotelsbyId")
  public List<Hotel> findHotelById(@PathVariable("id") int id)
     { 
	  String url="http://localhost:8070/hotels/{id}";
	  List<Hotel> Rentity=Arrays.asList(rt.getForObject(url,Hotel[].class));
      return Rentity;
      }
  @Operation(summary="FETCH HOTELS BY NAME")
  @GetMapping("/admins/fetchhotelsbyName")
  public List<Hotel> findHotelByName(@PathVariable("hName") String tName)
     { 
	  String url="http://localhost:8070/hotels/byName/{hName}";
	  List<Hotel> Rentity=Arrays.asList(rt.getForObject(url,Hotel[].class));
      return Rentity;
      }
  
  @Operation(summary="UPDATE HOTELS BY ID")
  @PutMapping("/admins/updatehotelsbyId")
  public List<Hotel> modifyHotel(@PathVariable("id") int id)
     { 
	  String url="http://localhost:8070/hotels/{id}";
	  List<Hotel> Rentity=Arrays.asList(rt.getForObject(url,Hotel[].class));
      return Rentity;
      }
  @Operation(summary="DELETE HOTELS BY ID")
  @DeleteMapping("/admins/deletehotelsbyId")
  public List<Hotel> deleteHotelById(@PathVariable("id") int id)
     { 
	  String url="http://localhost:8070/hotels/{id}";
	  List<Hotel> Rentity=Arrays.asList(rt.getForObject(url,Hotel[].class));
      return Rentity;
      }
  
  



  @Operation(summary="Admin Login using Correct ID Name and Password")
  @PostMapping("/admins/authenticate")
  public String authenticateAdmin(@Valid @RequestBody Admin admin) {
  return as.authenticateAdmin(admin);
  }


//@Operation(summary="To get all AdminId Details...")
//@GetMapping("/admins/{adminId}")
// public ResponseEntity<Admin> fetchAdminById(@Valid @PathVariable("adminId") int adminId) throws NoBookingDetailsFoundByIdException{
// Admin msg = as.findByAdminId(adminId);
// ResponseEntity<Admin> rEntity = new ResponseEntity<Admin>(msg, HttpStatus.FOUND);
// return rEntity;
//}

//
//@Operation(summary="To get all Admin Details...")
//@GetMapping("/admins")
//public List<Admin> fetchAllAdmins() 
//   {
//	return as.findAll();
//	}




}