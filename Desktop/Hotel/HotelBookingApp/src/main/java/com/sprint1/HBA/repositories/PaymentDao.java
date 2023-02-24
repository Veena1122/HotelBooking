package com.sprint1.HBA.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprint1.HBA.entities.Payments;
@Repository("pd")
public interface PaymentDao extends JpaRepository<Payments,Integer> {

	
	@Query("select obj from Payments obj join obj.transactions obj1 where obj1.transactionId=:pn")
	List<Payments> fetchAllPayments(@Param("pn") int id);
}