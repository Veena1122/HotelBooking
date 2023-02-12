package com.sprint1.HBA.exceptions;

public class HotelNotFoundException extends RuntimeException {
      public HotelNotFoundException(String str){
    	super(str);  
      }
}
