package com.sprint1.HBA.entities;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

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
	private int user_id;
    private String user_name;
    @Email
	private String user_email;
	private String user_password;
	private String user_role;
	@Size(min = 10, max = 10)
	private String user_mobile;
	private String user_address;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="userss")
    private BookingDetails bookingdetails;
}