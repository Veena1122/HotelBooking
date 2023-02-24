package com.sprint1.HBA.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="Payment_Details")
@Getter
@Setter
@NoArgsConstructor
public class Payments {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int paymentId;
	
	
	@OneToOne
    @JoinColumn(name="trans_id")
	private Transactions transactions;
    
	public Transactions getTransactions() {
		return transactions;
	}
	
	public void setTransactions(Transactions transactions) {
		this.transactions = transactions;
	}
	
	@ManyToOne
	BookingDetails bookingdetails;
	public Payments(int paymentId) 
	{
		super();
		this.paymentId = paymentId;
		}
}
