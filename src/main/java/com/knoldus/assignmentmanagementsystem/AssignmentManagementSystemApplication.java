package com.knoldus.assignmentmanagementsystem;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssignmentManagementSystemApplication {

	// Spring Cloud Azure will automatically inject SecretClient in your ApplicationContext.
//	private final SecretClient secretClient;
//
//	public AssignmentManagementSystemApplication(SecretClient secretClient) {
//		this.secretClient = secretClient;
//	}
	public static void main(String[] args) {
		SpringApplication.run(AssignmentManagementSystemApplication.class, args);
	}

//	@Override
//	public void run(String... args) {
//		System.out.println("spring-data-mongo-uri: " + secretClient.getSecret("spring-data-mongo-uri").getValue());
//	}
}

