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

import com.sprint1.HBA.entities.Payments;
import com.sprint1.HBA.repositories.PaymentDao;
import com.sprint1.HBA.service.PaymentService;

@SpringBootTest
public class PaymentsServiceTest {
        @Autowired
		PaymentService service;
		
        @MockBean
		private PaymentDao pd;

		@Test
	    public void insertPaymentTest() {
		String str="Payment Done Successfully!!!";
		Payments pdd = new Payments(1);
		when(pd.save(pdd)).thenReturn(pdd);
		assertEquals(str, service.insertPayments(pdd));
	}

		@Test
		public void findAllTest(){
			when(pd.findAll()).thenReturn(Stream.of(new Payments(1)).collect(Collectors.toList()));
			assertEquals(1,service.findAll().size());
			}
		
		@Test
		public void findByPaymentIdTest()
		{
			doReturn(Optional.of(new Payments(1))).when(pd).findById(1);
		}
		

}
