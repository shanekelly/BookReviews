package com.java.BookReviews.security; // Declaring the package in which this class resides.

import jakarta.persistence.Entity; // Importing Entity annotation.
import jakarta.persistence.GeneratedValue; // Importing GeneratedValue annotation.
import jakarta.persistence.GenerationType; // Importing GenerationType enum.
import jakarta.persistence.Id; // Importing Id annotation.
import java.util.Arrays; // Importing Arrays class.
import java.util.Collection; // Importing Collection interface.
import lombok.AllArgsConstructor; // Importing AllArgsConstructor annotation from Lombok library.
import lombok.Data; // Importing Data annotation from Lombok library.
import lombok.NoArgsConstructor; // Importing NoArgsConstructor annotation from Lombok library.
import org.springframework.context.annotation.Bean; // Importing Bean annotation from Spring framework.
import org.springframework.security.core.GrantedAuthority; // Importing GrantedAuthority interface from Spring Security.
import org.springframework.security.core.authority.SimpleGrantedAuthority; // Importing SimpleGrantedAuthority class from Spring Security.
import org.springframework.security.core.userdetails.UserDetails; // Importing UserDetails interface from Spring Security.
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Importing BCryptPasswordEncoder class from Spring Security.
import org.springframework.security.crypto.password.PasswordEncoder; // Importing PasswordEncoder interface from Spring Security.

@Entity // Annotation to indicate that this class is an entity mapped to a database table.
@Data // Annotation to automatically generate getters, setters, toString, equals, and hashCode methods.
@AllArgsConstructor // Annotation to generate an all-args constructor.
@NoArgsConstructor // Annotation to generate a no-args constructor.
public class MyUserDetails implements UserDetails { // Class representing user details for authentication.

    @Id // Annotation to specify the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Annotation to specify the generation strategy for the primary key.
    int id; // Field representing the ID of the user.

    private String username; // Field representing the username of the user.
    private String password; // Field representing the password of the user.
    private String roles; // Field representing the roles assigned to the user.

    @Bean // Annotation to indicate that this method produces a bean to be managed by the Spring container.
    public PasswordEncoder passwordEncoder() { // Method to create a PasswordEncoder bean.
        return new BCryptPasswordEncoder(); // Returning a new instance of BCryptPasswordEncoder.
    }

    @Override
    public String getPassword() { // Method to retrieve the encoded password.
        return passwordEncoder().encode(password); // Encoding and returning the password.
    }

    @Override
    public boolean isAccountNonExpired() { // Method to check if the user account is non-expired.
        return true; // Always returning true for simplicity.
    }

    @Override
    public boolean isAccountNonLocked() { // Method to check if the user account is non-locked.
        return true; // Always returning true for simplicity.
    }

    @Override
    public boolean isCredentialsNonExpired() { // Method to check if the user credentials are non-expired.
        return true; // Always returning true for simplicity.
    }

    @Override
    public boolean isEnabled() { // Method to check if the user account is enabled.
        return true; // Always returning true for simplicity.
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // Method to retrieve the user's authorities.
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(getRoles()); // Creating a SimpleGrantedAuthority object with the user's role.
        return Arrays.asList(authority); // Returning a list containing the user's authority.
    }
}

