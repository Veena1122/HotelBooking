package com.sprint1.HBA.service;
import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.HBA.entities.Payments;
import com.sprint1.HBA.exceptions.PaymentNotFoundException;
import com.sprint1.HBA.repositories.PaymentDao;
@Service("ps")
@Transactional

public class PaymentService {
	@Autowired
	PaymentDao pd;

	public String insertPayments(Payments pay) {
	pd.save(pay);
	return "Payment Done Successfully!!!";
}
public List<Payments> findAll() {
		
		List<Payments> list=pd.findAll();
		if(list.isEmpty())
			throw new PaymentNotFoundException("No Payment Found");
		return list;
	}
public Payments findByPaymentsId(int id) {
	// TODO Auto-generated method stub
	
	Optional<Payments> op= pd.findById(id);
	if(op.isPresent())
		return op.get();
	else
		throw new PaymentNotFoundException("payment Not found for Id :" +id);
}

public List<Payments> getPaymentsByTransactionId(int id) {
	// TODO Auto-generated method stub
	return pd.fetchAllPayments(id);

}
public String removeHotel(int id) {
	// TODO Auto-generated method stub
	pd.deleteById(id);
	return "Deleted Successfully!!";
}

}

