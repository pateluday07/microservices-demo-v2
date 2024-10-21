package com.pateluday07.microservicies.v2.forex_converter_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ForexConverterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForexConverterServiceApplication.class, args);
	}

}
