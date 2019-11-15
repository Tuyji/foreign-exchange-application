package com.openpayd.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FixerApiClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FixerApiClientApplication.class, args);
	}

}
