package com.sprint1.HBA.entities;
import java.time.LocalDate;
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
import javax.validation.constraints.Min;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="BookingDet")
public class BookingDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int booking_id;
	//private int room_id;
	//private int user_id;
	@NonNull
	private LocalDate booked_from;
	private LocalDate booked_to;
	private int no_of_adults;
	private int no_of_children;
    private double amount;
    
    
    @OneToOne
    private Hotel hotell;
    
    @OneToOne
    private Userss userss;
    
    //@OneToMany(mappedBy="bookingdetails1",cascade=CascadeType.ALL)
    @OneToMany(cascade=CascadeType.ALL)
    private List<RoomDetails> roomdetails1=new ArrayList<>();
    

    public void AddBookingIdToRoomDetails(List<RoomDetails> roomd) {
    	for(RoomDetails temp:roomd)
    	{
    		temp.setBookingdetails1(this);
    	}
    	
    }


	public BookingDetails(int booking_id, int no_of_adults, int no_of_children, double amount) {
		super();
		this.booking_id = booking_id;
		this.no_of_adults = no_of_adults;
		this.no_of_children = no_of_children;
		this.amount = amount;
	}


	public int getBooking_id() {
		return booking_id;
	}


	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}


	public int getNo_of_adults() {
		return no_of_adults;
	}


	public void setNo_of_adults(int no_of_adults) {
		this.no_of_adults = no_of_adults;
	}


	public int getNo_of_children() {
		return no_of_children;
	}


	public void setNo_of_children(int no_of_children) {
		this.no_of_children = no_of_children;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public List<RoomDetails> getRoomdetails1() {
		return roomdetails1;
	}


	public void setRoomdetails1(List<RoomDetails> roomdetails1) {
		this.roomdetails1 = roomdetails1;
	}
	
	

}