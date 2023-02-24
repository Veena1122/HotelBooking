package com.sprint1.HBA.entities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="BookingDet")
public class BookingDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookingId;
	@NonNull
	private LocalDate bookedFrom;
	private LocalDate bookedTo;
	private int noOfAdults;
	private int noOfChildren;
    private double amount;
    
    @OneToOne
    private Hotel hotell;
    
    @OneToOne
    private Userss userss;
    
    @OneToMany
    private List<RoomDetails> roomdetails1=new ArrayList<>();
    

    public void AddBookingIdToRoomDetails(List<RoomDetails> roomd) {
    	for(RoomDetails temp:roomd)
    	{
    		temp.setBookingdetails1(this);
    	}
     }
   
    @OneToMany(mappedBy="bookingdetails")
    @JsonIgnore
    List<Payments> payments=new ArrayList<>();


	public BookingDetails(int bookingId, int noOfAdults, int noOfChildren, double amount) {
		super();
		this.bookingId = bookingId;
		this.noOfAdults = noOfAdults;
		this.noOfChildren = noOfChildren;
		this.amount = amount;
	}


	
    
}