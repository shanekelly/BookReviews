package com.java.BookReviews.data; // Declaring the package in which this interface resides.

import com.java.BookReviews.models.Review; // Importing Review class.
import java.util.List; // Importing List interface.
import org.springframework.data.repository.CrudRepository; // Importing CrudRepository interface.
import org.springframework.data.rest.core.annotation.RepositoryRestResource; // Importing RepositoryRestResource annotation.

@RepositoryRestResource(path = "reviews" ) // Annotation to indicate that this interface exposes RESTful endpoints for reviews.
public interface ReviewRepository extends CrudRepository<Review, Integer> { // Interface to interact with Review entities.

    List<Review> findByBookId(int bookId); // Method to find reviews by book ID.

}

