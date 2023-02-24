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

import com.sprint1.HBA.entities.Payments;
import com.sprint1.HBA.responses.ErrorInfo;
import com.sprint1.HBA.service.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
public class PaymentController {
		@Autowired
		PaymentService ps;
		@Operation(summary="To add Payment...")
		@PostMapping("/payments")
		public ResponseEntity<String> addPayments(@Valid @RequestBody Payments pay)
		{
			String pt=ps.insertPayments(pay);
			return new ResponseEntity<>(pt,HttpStatus.CREATED);
		}
		@Operation(summary="To get all the Payments...")
		@GetMapping("/payments")
		public List<Payments> fetchAllPayments() 
		{
			return ps.findAll();
			
		}
		@Operation(summary="To get the Payment by Id...")
		@ApiResponses(value= {
				@ApiResponse(responseCode="200",description="OK",content=@Content(mediaType="application/json",schema=@Schema(oneOf=Payments.class))),
				@ApiResponse(responseCode="404",description="NOT_FOUND",content=@Content(mediaType="application/json",schema=@Schema(oneOf=ErrorInfo.class)))
		})
		@GetMapping("/payments/{id}")
		public ResponseEntity<Payments> findByPaymentId(@PathVariable("id") int id)
		{
			Payments pa=ps.findByPaymentsId(id);
			return new ResponseEntity<>(pa,HttpStatus.FOUND);
		}
		@GetMapping("/payments/transactions/{id}")
		public List<Payments> getAllPaymentsByTransactionId(@PathVariable("id") int id)
		{
			return ps.getPaymentsByTransactionId(id);
		}
		
		@Operation(summary="To delete the Payment by Id...")
		@DeleteMapping("/payments/{id}")
		public ResponseEntity<String> deletepaymentById(@PathVariable("id") int id)
		{
			String msg= ps.removeHotel(id);
		    return new ResponseEntity<>(msg,HttpStatus.OK);
		}
		
	}

