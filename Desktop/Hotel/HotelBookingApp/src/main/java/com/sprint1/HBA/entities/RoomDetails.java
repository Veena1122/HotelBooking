package com.sprint1.HBA.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Room_Details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomDetails {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roomId;
	private String roomNo;
	private String roomType;
	@Min(value=500,message="price should be greater than 10000")
	@Max(value=1000000,message="price should be less than 1000000")
	private int ratePerDay;
	private boolean available;
    
	@ManyToOne
	@JsonIgnore
    private Hotel hotel;
	
	@ManyToOne
	@JsonIgnore
	private BookingDetails bookingdetails1;

	public RoomDetails(int roomId, String roomNo, String roomType,
			@Min(value = 500, message = "price should be greater than 10000") @Max(value = 1000000, message = "price should be less than 1000000") int ratePerDay,
			boolean available) {
		super();
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.ratePerDay = ratePerDay;
		this.available = available;
	}

	
	
}