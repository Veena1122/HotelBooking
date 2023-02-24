package com.sprint1.HBA.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.HBA.entities.Transactions;
import com.sprint1.HBA.exceptions.TransactionNotFoundException;
import com.sprint1.HBA.repositories.TransactionDao;


@Service("ts")
@Transactional
public class TransactionService {
	@Autowired
	TransactionDao td;

	public String insertTransactions(Transactions trans) {
		Transactions tdtrans= td.save(trans);
		return "Transaction Done successfully with Amount :"+tdtrans.getAmount()+" and Transaction ID is :"+tdtrans.getTransactionId() ;
	}

public List<Transactions> findAll() {
		
		List<Transactions> list=td.findAll();
		if(list.isEmpty())
			throw new TransactionNotFoundException("No Transaction Found");
		return list;
	}
public Transactions findByTransactionId(int id) {
	// TODO Auto-generated method stub
	
	Optional<Transactions> op= td.findById(id);
	if(op.isPresent())
		return op.get();
	else
		throw new TransactionNotFoundException("Transaction Not found for Id :" +id);
}

}

