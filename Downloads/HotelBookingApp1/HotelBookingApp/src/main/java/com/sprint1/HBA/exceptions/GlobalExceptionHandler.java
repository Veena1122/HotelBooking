package com.sprint1.HBA.exceptions;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sprint1.HBA.responses.ErrorInfo;
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handlingException(MethodArgumentNotValidException ex) {
		Map<String,String> map=new LinkedHashMap<>();
		List<FieldError> list=ex.getFieldErrors();
		for(FieldError err:list)
		{
			String fieldName=err.getField();
			String Errormsg=err.getDefaultMessage();
			map.put(fieldName, Errormsg);
			
		}
		ResponseEntity<Map<String,String>> Rentity=new ResponseEntity<Map<String,String>>(map,HttpStatus.NOT_ACCEPTABLE);
		return Rentity;
	}

	@ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<String> handlingException(HotelNotFoundException ex)
	{
	String msg=ex.getMessage();
	ResponseEntity<String> Rentity=new ResponseEntity<String>(msg,HttpStatus.NO_CONTENT);
	return Rentity;
    }
	@ExceptionHandler(HotelIdNotFoundException.class)
    public ResponseEntity<ErrorInfo> handlingException(HotelIdNotFoundException ex,HttpServletRequest req)
	{
		
		String msg=ex.getMessage();
		ErrorInfo errin=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),msg,req.getRequestURI());
		ResponseEntity<ErrorInfo> Rentity=new ResponseEntity<ErrorInfo>(errin,HttpStatus.NOT_FOUND);
		return Rentity;
    }
	@ExceptionHandler(HotelNameNotFoundException.class)
    public ResponseEntity<String> handlingException(HotelNameNotFoundException ex)
	{
		String msg=ex.getMessage();
		ResponseEntity<String> Rentity=new ResponseEntity<String>(msg,HttpStatus.NOT_FOUND);
		return Rentity;
    }
	@ExceptionHandler(IdNotMatchedException.class)
    public ResponseEntity<String> handlingException(IdNotMatchedException ex)
	{
	String msg=ex.getMessage();
	ResponseEntity<String> Rentity=new ResponseEntity<String>(msg,HttpStatus.NOT_ACCEPTABLE);
	return Rentity;
    }
	@ExceptionHandler(NoRoomDetailsFoundException.class)
	public ResponseEntity<String> generalHandlerException(NoRoomDetailsFoundException ex) {
		String msg = ex.getMessage();
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
		return rEntity;
	}
	@ExceptionHandler(NoRoomDetailsFoundByIdException.class)
	public ResponseEntity<String> generalHandlerException(NoRoomDetailsFoundByIdException ex) {
		String msg = ex.getMessage();
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
		return rEntity;
	}
	
	 @ExceptionHandler(UserIdNotFoundException.class)
     public ResponseEntity<String> handlingException(UserIdNotFoundException ex) {
	 String msg = ex.getMessage();
	 //ErrorInfo errin = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, req.getRequestURI());
	 ResponseEntity<String> Rentity = new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
	 return Rentity;
	 }
	 
	 @ExceptionHandler(UserNotFoundException.class)
     public ResponseEntity<String> handlingException1(UserNotFoundException ex)
	 {
     String msg=ex.getMessage();
     //ErrorInfo errin=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),msg,req.getRequestURI());
     ResponseEntity<String> Rentity=new ResponseEntity<String>(msg,HttpStatus.NOT_FOUND);
     return Rentity; 
	 }
	 
	 @ExceptionHandler(InvalidUserException.class)
	 public ResponseEntity<String> handlingException1(InvalidUserException ex)
	 {
         String msg=ex.getMessage();
	     //ErrorInfo errin=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),msg,req.getRequestURI());
	     ResponseEntity<String> Rentity=new ResponseEntity<String>(msg,HttpStatus.NOT_FOUND);
	     return Rentity; 
	 }



}
