package com.sprint1.HBA.service;

import java.util.List;

import com.sprint1.HBA.entities.Hotel;



public interface IHotelService {
      public Hotel addHotel(Hotel hotel);
      public Hotel updateHotel(int id,Hotel hotel);
      public String removeHotel(int hotel);
      public List<Hotel> showAllHotels();
      public Hotel showHotel(int id);
      public Hotel findByHotelName(String name);
      
}
