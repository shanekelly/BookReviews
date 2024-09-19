package com.java.BookReviews; // This line declares the package in which this class resides.

import org.springframework.boot.SpringApplication; // Importing SpringApplication class from Spring Boot framework.
import org.springframework.boot.autoconfigure.SpringBootApplication; // Importing SpringBootApplication annotation from Spring Boot framework.

@SpringBootApplication // Annotation to indicate that this class is a Spring Boot application.
public class BookReviewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookReviewsApplication.class, args); // Method to run the Spring Boot application.
    }

}

