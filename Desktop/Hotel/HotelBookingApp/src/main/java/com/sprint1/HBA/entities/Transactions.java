package com.sprint1.HBA.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Transaction_Details")
public class Transactions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;
	@Min(value=1,message="Amount should not be negative")
	private double amount;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="transactions")
	@JsonIgnore
	private Payments payments;
   
	public Transactions(int transactionId, @Min(value = 1, message = "Amount should not be negative") double amount) 
	{
	super();
	this.transactionId = transactionId;
	this.amount = amount;
	}


}

