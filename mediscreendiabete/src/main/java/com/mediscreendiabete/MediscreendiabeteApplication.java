package com.mediscreendiabete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.mediscreendiabete")
public class MediscreendiabeteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediscreendiabeteApplication.class, args);
	}

}
