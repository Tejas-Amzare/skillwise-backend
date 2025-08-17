package com.skillwise.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);

		// Print a message to confirm the application started successfully
		System.out.println("\n\n\n\t\t\t Hello, the application has started successfully!");
	}
}
