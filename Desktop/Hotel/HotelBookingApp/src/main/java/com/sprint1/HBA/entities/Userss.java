package com.sprint1.HBA.entities;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Table(name = "users")
//@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Userss {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
    private String userName;
    @Email
	private String userEmail;
	private String userPassword;
	private String userRole;
	@Size(min = 10, max = 10)
	private String userMobile;
	private String userAddress;
	
	
	public Userss(int userId, String userName, @Email String userEmail, String userPassword, String userRole,
			@Size(min = 10, max = 10) String userMobile, String userAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userRole = userRole;
		this.userMobile = userMobile;
		this.userAddress = userAddress;
	}


	@OneToOne(cascade=CascadeType.ALL,mappedBy="userss")
	@JsonIgnore
    private BookingDetails bookingdetails;
}