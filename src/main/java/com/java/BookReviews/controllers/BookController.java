package com.java.BookReviews.controllers; // Declaring the package in which this class resides.

import com.java.BookReviews.data.BookRepository; // Importing BookRepository class.
import com.java.BookReviews.models.Book; // Importing Book class.
import java.util.List; // Importing List interface.
import org.springframework.beans.factory.annotation.Autowired; // Importing Autowired annotation.
import org.springframework.stereotype.Controller; // Importing Controller annotation.
import org.springframework.ui.Model; // Importing Model class.
import org.springframework.web.bind.annotation.GetMapping; // Importing GetMapping annotation.
import org.springframework.web.bind.annotation.PathVariable; // Importing PathVariable annotation.
import org.springframework.web.bind.annotation.PostMapping; // Importing PostMapping annotation.
import org.springframework.web.bind.annotation.RequestBody; // Importing RequestBody annotation.
import org.springframework.web.bind.annotation.RequestParam; // Importing RequestParam annotation.
import org.springframework.web.bind.annotation.RestController; // Importing RestController annotation.
import org.springframework.web.servlet.view.RedirectView;

@RestController // Annotation to indicate that this class will handle RESTful requests.
public class BookController {

    @Autowired // Annotation to automatically inject BookRepository instance.
    private BookRepository bookRepository; // Declaring a field for BookRepository.

    @GetMapping("/books") // Annotation to handle GET requests for /books endpoint.
    public List<Book> listBooks() { // Method to list all books.
        return (List<Book>) bookRepository.findAll(); // Returning all books from the repository.
    }

    @GetMapping("/books/{id}") // Annotation to handle GET requests for /books/{id} endpoint.
    public Book getBook(@PathVariable("id") int id) { // Method to retrieve a book by its ID.
        return bookRepository.findById(id).orElse(null); // Returning the book with the specified ID, if found.
    }

    @PostMapping("/books") // Annotation to handle POST requests for /books endpoint.
    public RedirectView addBook(@RequestParam("title") String title, @RequestParam("authors") String authors, Model model) { // Method to add a new book.
        Book book = new Book(); // Creating a new Book object.
        book.setTitle(title); // Setting the title of the book.
        book.setAuthors(authors); // Setting the authors of the book.
        bookRepository.save(book); // Saving the book to the repository.
        model.addAttribute("books", bookRepository.findAll()); // Adding all books to the model.
        return new RedirectView("/"); // Returning a message indicating the book creation.
    }
    
}
