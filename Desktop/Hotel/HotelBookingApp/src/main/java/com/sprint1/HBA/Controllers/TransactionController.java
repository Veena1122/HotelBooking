package com.sprint1.HBA.Controllers;
import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.HBA.entities.Transactions;
import com.sprint1.HBA.responses.ErrorInfo;
import com.sprint1.HBA.service.TransactionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
@RestController
public class TransactionController {
	@Autowired
	TransactionService ts;
	@Operation(summary="To add Transaction...")
	@PostMapping("/transactions")
	public ResponseEntity<String> addTransactions(@Valid @RequestBody Transactions trans)
	{
		String msg=ts.insertTransactions(trans);
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}
	@Operation(summary="To get all the Transactions...")
	@GetMapping("/transactions")
	public List<Transactions> fetchAllTransactions() 
	{
		return ts.findAll();
		
	}
	@Operation(summary="To get the Transaction by Id...")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200",description="OK",content=@Content(mediaType="application/json",schema=@Schema(oneOf=Transactions.class))),
			@ApiResponse(responseCode="404",description="NOT_FOUND",content=@Content(mediaType="application/json",schema=@Schema(oneOf=ErrorInfo.class)))
	})
	@GetMapping("/transactions/{id}")
	public ResponseEntity<Transactions> findByTransactionId(@PathVariable("id") int id)
	{
		Transactions ta=ts.findByTransactionId(id);
		return new ResponseEntity<>(ta,HttpStatus.FOUND);
	
	}
}
