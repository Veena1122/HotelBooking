package com.sprint1.HBA.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "hotels")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hotelId;
    private String city;
    private String hotelName;
    private String address;
	@Min(value = 1)
	@Max(value = 10000)
	private double avgRatePerDay;
	@Email
	private String email;
    @Size(min = 10, max = 10)
	private String phone1;
	@Size(min = 10, max = 10)
    private String phone2;
    private String website;

	@OneToMany(mappedBy = "hotel", cascade = CascadeType.PERSIST)
	private List<RoomDetails> roomDetails = new ArrayList<>();

	@OneToOne(mappedBy = "hotell", cascade = CascadeType.ALL)
	@JsonIgnore
	private BookingDetails bookingdetails;

	public void SetHotelToRoomDetails(List<RoomDetails> roomdetails) {
		for (RoomDetails temp : roomdetails) {
			temp.setHotel(this);
		}
	}

	public Hotel(int hotelId, String city, String hotelName) {
		super();
		this.hotelId = hotelId;
		this.city = city;
		this.hotelName = hotelName;
	}
}
