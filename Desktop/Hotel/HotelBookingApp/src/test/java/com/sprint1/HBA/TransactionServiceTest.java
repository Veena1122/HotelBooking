package com.sprint1.HBA;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint1.HBA.entities.Transactions;
import com.sprint1.HBA.repositories.TransactionDao;
import com.sprint1.HBA.service.TransactionService;

@SpringBootTest
class TransactionServiceTest {
	@Autowired
	private TransactionService service;
	@MockBean
	private TransactionDao pd;

	@Test
	public void findAllTest(){
		when(pd.findAll()).thenReturn(Stream.of(new Transactions(1,5000.0)).collect(Collectors.toList()));
		assertEquals(1,service.findAll().size());
	}
	@Test
	public void findByTransactionIdTest()
	{
		doReturn(Optional.of(new Transactions(1,10000.0))).when(pd).findById(1);
	}
}
