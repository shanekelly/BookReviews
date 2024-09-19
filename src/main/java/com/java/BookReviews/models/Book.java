package com.java.BookReviews.models; // Declaring the package in which this class resides.

import jakarta.persistence.Entity; // Importing Entity annotation.
import jakarta.persistence.GeneratedValue; // Importing GeneratedValue annotation.
import jakarta.persistence.GenerationType; // Importing GenerationType enum.
import jakarta.persistence.Id; // Importing Id annotation.
import lombok.AllArgsConstructor; // Importing AllArgsConstructor annotation from Lombok library.
import lombok.Data; // Importing Data annotation from Lombok library.
import lombok.NoArgsConstructor; // Importing NoArgsConstructor annotation from Lombok library.

@Entity // Annotation to indicate that this class is an entity mapped to a database table.
@Data // Annotation to automatically generate getters, setters, toString, equals, and hashCode methods.
@AllArgsConstructor // Annotation to generate an all-args constructor.
@NoArgsConstructor // Annotation to generate a no-args constructor.
public class Book { // Class representing a Book entity.

    @Id // Annotation to specify the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Annotation to specify the generation strategy for the primary key.
    private int id; // Field representing the ID of the book.

    private String title; // Field representing the title of the book.
    private String authors; // Field representing the authors of the book.
}
