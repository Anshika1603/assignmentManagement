package com.knoldus.assignmentmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

 @SpringBootApplication
 public final class AssignmentManagementSystemApplication {

 /**
  * Private constructor to prevent instantiation of the utility class.
  */
 private AssignmentManagementSystemApplication() {
 }

 /**
  * The main method to start the application.
  * @param args The command-line arguments.
  */
 public static void main(final String[] args) {
 SpringApplication.run(AssignmentManagementSystemApplication
 .class, args);
 }
 }

