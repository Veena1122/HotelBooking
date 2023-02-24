package com.sprint1.HBA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Hotel Rest API",description="Performing Crud Operations",version="v1",license=@License(name="@Nandini5653"),contact=@Contact(name="Nandini Veddampuri",email="nandini-nageshrao.veddampuri@capgemini.com")))
public class HotelBookingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingAppApplication.class, args);
	}
	@Bean("rt")
	public RestTemplate getRT() {
		return new RestTemplate();
		
	}

}
