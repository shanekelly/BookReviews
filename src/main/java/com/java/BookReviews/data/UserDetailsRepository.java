package com.java.BookReviews.data; // Declaring the package in which this interface resides.

import com.java.BookReviews.security.MyUserDetails; // Importing MyUserDetails class.
import org.springframework.data.repository.CrudRepository; // Importing CrudRepository interface.

public interface UserDetailsRepository extends CrudRepository<MyUserDetails, Integer> { // Interface to interact with user details entities.

    public MyUserDetails findByUsername(String username); // Method to find a user by username.

    public MyUserDetails findUserByUsername(String username); // Method to find a user by username (alternative method name).

}
