package com.java.BookReviews.data; // Declaring the package in which this interface resides.

import com.java.BookReviews.models.Book; // Importing Book class.
import org.springframework.data.repository.CrudRepository; // Importing CrudRepository interface.
import org.springframework.data.rest.core.annotation.RepositoryRestResource; // Importing RepositoryRestResource annotation.

@RepositoryRestResource(path = "books" ) // Annotation to indicate that this interface exposes RESTful endpoints for books.
public interface BookRepository extends CrudRepository<Book, Integer> { // Interface to interact with Book entities.

}

