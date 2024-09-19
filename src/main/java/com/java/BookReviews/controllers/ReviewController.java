package com.java.BookReviews.controllers; // Declaring the package in which this class resides.

import com.java.BookReviews.data.ReviewRepository; // Importing ReviewRepository class.
import com.java.BookReviews.models.Review; // Importing Review class.
import java.util.List; // Importing List interface.
import org.springframework.beans.factory.annotation.Autowired; // Importing Autowired annotation.
import org.springframework.ui.Model; // Importing Model class.
import org.springframework.web.bind.annotation.GetMapping; // Importing GetMapping annotation.
import org.springframework.web.bind.annotation.PathVariable; // Importing PathVariable annotation.
import org.springframework.web.bind.annotation.PostMapping; // Importing PostMapping annotation.
import org.springframework.web.bind.annotation.RequestBody; // Importing RequestBody annotation.
import org.springframework.web.bind.annotation.RequestParam; // Importing RequestParam annotation.
import org.springframework.web.bind.annotation.RestController; // Importing RestController annotation.
import org.springframework.web.servlet.view.RedirectView;

@RestController // Annotation to indicate that this class will handle RESTful requests.
public class ReviewController {

    @Autowired // Annotation to automatically inject ReviewRepository instance.
    private ReviewRepository reviewRepository; // Declaring a field for ReviewRepository.

    @GetMapping("/reviews/{bookId}") // Annotation to handle GET requests for /reviews/{bookId} endpoint.
    public List<Review> listReviews(@PathVariable("bookId") int bookId) { // Method to list reviews for a specific book.
        return reviewRepository.findByBookId(bookId); // Returning reviews for the specified book ID.
    }

    @PostMapping("/reviews") // Annotation to handle POST requests for /reviews endpoint.
    public RedirectView addReview(@RequestParam("bookId") int bookId, @RequestParam("review") String review, Model model) { // Method to add a new review.
        Review review1 = new Review(); // Creating a new Review object.
        review1.setBookId(bookId); // Setting the book ID for the review.
        review1.setReview(review); // Setting the review text.
        reviewRepository.save(review1); // Saving the review to the repository.
        model.addAttribute("reviews", reviewRepository.findAll()); // Adding all reviews to the model.
        return new RedirectView("/"); // Returning a message indicating the review creation.
    }
    
}
