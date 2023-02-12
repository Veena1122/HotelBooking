package com.sprint1.HBA.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Room_Details")
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDetails {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int room_id;
//	@NotEmpty
//	@NotEmpty
	private String room_no;
//	@NotEmpty
	private String roomType;
	@Min(value=10000,message="price should be greater than 10000")
	@Max(value=1000000,message="price should be less than 1000000")
	private int rate_per_day;
	//@NotEmpty
	private boolean available;
    
	@ManyToOne
	@JsonIgnore
    private Hotel hotel;
	
	@ManyToOne
	private BookingDetails bookingdetails1;

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getRoom_no() {
		return room_no;
	}

	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRate_per_day() {
		return rate_per_day;
	}

	public void setRate_per_day(int rate_per_day) {
		this.rate_per_day = rate_per_day;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public BookingDetails getBookingdetails1() {
		return bookingdetails1;
	}

	public void setBookingdetails1(BookingDetails bookingdetails1) {
		this.bookingdetails1 = bookingdetails1;
	}

	public RoomDetails(int room_id, String room_no, String roomType,
			@Min(value = 10000, message = "price should be greater than 10000") @Max(value = 1000000, message = "price should be less than 1000000") int rate_per_day,
			boolean available) {
		super();
		this.room_id = room_id;
		this.room_no = room_no;
		this.roomType = roomType;
		this.rate_per_day = rate_per_day;
		this.available = available;
	}
	
	
	
	
}