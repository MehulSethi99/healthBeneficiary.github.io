package com.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="http://localhost:4200")
@SpringBootApplication
public class Spring2ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring2ProjectApplication.class, args);
	}

}
