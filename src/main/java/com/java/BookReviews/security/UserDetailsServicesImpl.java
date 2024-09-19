package com.java.BookReviews.security; // Declaring the package in which this class resides.

import com.java.BookReviews.data.UserDetailsRepository; // Importing UserDetailsRepository class.
import com.java.BookReviews.security.MyUserDetails; // Importing MyUserDetails class.
import org.springframework.beans.factory.annotation.Autowired; // Importing Autowired annotation from Spring framework.
import org.springframework.security.core.userdetails.UserDetails; // Importing UserDetails interface from Spring Security.
import org.springframework.security.core.userdetails.UserDetailsService; // Importing UserDetailsService interface from Spring Security.
import org.springframework.security.core.userdetails.UsernameNotFoundException; // Importing UsernameNotFoundException class from Spring Security.

public class UserDetailsServicesImpl implements UserDetailsService { // Class implementing the UserDetailsService interface for user details retrieval.

    @Autowired // Annotation to automatically inject UserDetailsRepository instance.
    private UserDetailsRepository userDetailsRepository; // Declaring a field for UserDetailsRepository.

    @Override // Annotation to indicate that this method overrides a method from the superclass/interface.
    public UserDetails loadUserByUsername(String username) // Method to load user details by username.
            throws UsernameNotFoundException { // Handling a potential UsernameNotFoundException.

        MyUserDetails mud = userDetailsRepository.findUserByUsername(username); // Retrieving user details from the repository.

        if (mud == null) // Checking if user details are not found.
            throw new UsernameNotFoundException("User not found"); // Throwing UsernameNotFoundException.

        return mud; // Returning user details.
    }
}
