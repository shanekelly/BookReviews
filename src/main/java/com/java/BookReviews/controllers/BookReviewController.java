package com.java.BookReviews.controllers; // Declaring the package in which this class resides.

import com.java.BookReviews.data.BookRepository; // Importing BookRepository class.
import com.java.BookReviews.data.ReviewRepository; // Importing ReviewRepository class.
import com.java.BookReviews.data.UserDetailsRepository; // Importing UserDetailsRepository class.
import com.java.BookReviews.models.Book; // Importing Book class.
import com.java.BookReviews.models.Review; // Importing Review class.
import org.springframework.beans.factory.annotation.Autowired; // Importing Autowired annotation.
import org.springframework.stereotype.Controller; // Importing Controller annotation.
import org.springframework.ui.Model; // Importing Model class.
import org.springframework.web.bind.annotation.GetMapping; // Importing GetMapping annotation.
import org.springframework.web.bind.annotation.RequestParam; // Importing RequestParam annotation.
import org.springframework.web.bind.annotation.RestController; // Importing RestController annotation.

@Controller // Annotation to indicate that this class is a controller.
public class BookReviewController {
    
    @Autowired // Annotation to automatically inject BookRepository instance.
    BookRepository bookRepository; // Declaring a field for BookRepository.

    @Autowired // Annotation to automatically inject ReviewRepository instance.
    ReviewRepository reviewRepository; // Declaring a field for ReviewRepository.

    @Autowired // Annotation to automatically inject UserDetailsRepository instance.
    UserDetailsRepository userDetailsRepository; // Declaring a field for UserDetailsRepository.

    @GetMapping("/") // Annotation to handle GET requests for the root endpoint.
    public String index(Model model) { // Method to handle the root endpoint request.
        model.addAttribute("books", bookRepository.findAll()); // Adding all books to the model.
        return "index"; // Returning the name of the view template to render.
    }
    
    @GetMapping("/addBook") // Annotation to handle GET requests for /addBook endpoint.
    public String addBook(Model model) { // Method to handle adding a new book.
        model.addAttribute("book", new Book()); // Adding a new Book object to the model.
        return "addBook"; // Returning the name of the view template to render.
    }
    
    @GetMapping("/addReview") // Annotation to handle GET requests for /addReview endpoint.
    public String addReview(@RequestParam("bookId") int bookId, Model model) { // Method to handle adding a new review.
        Review review = new Review(); // Creating a new Review object.
        review.setBookId(bookId); // Setting the book ID for the review.
        model.addAttribute("review", review); // Adding the review to the model.
        return "addReview"; // Returning the name of the view template to render.
    }
}

