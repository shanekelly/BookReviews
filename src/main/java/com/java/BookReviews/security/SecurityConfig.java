package com.java.BookReviews.security; // Declaring the package in which this class resides.

import org.springframework.boot.autoconfigure.security.servlet.PathRequest; // Importing PathRequest class from Spring Boot auto-configuration.
import org.springframework.context.annotation.Bean; // Importing Bean annotation from Spring framework.
import org.springframework.context.annotation.Configuration; // Importing Configuration annotation from Spring framework.
import org.springframework.security.authentication.AuthenticationManager; // Importing AuthenticationManager interface from Spring Security.
import org.springframework.security.authentication.ProviderManager; // Importing ProviderManager class from Spring Security.
import org.springframework.security.authentication.dao.DaoAuthenticationProvider; // Importing DaoAuthenticationProvider class from Spring Security.
import org.springframework.security.config.Customizer; // Importing Customizer interface from Spring Security config.
import org.springframework.security.config.annotation.web.builders.HttpSecurity; // Importing HttpSecurity class from Spring Security config.
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; // Importing EnableWebSecurity annotation from Spring Security config.
import org.springframework.security.core.userdetails.UserDetailsService; // Importing UserDetailsService interface from Spring Security core.
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Importing BCryptPasswordEncoder class from Spring Security crypto.
import org.springframework.security.crypto.password.PasswordEncoder; // Importing PasswordEncoder interface from Spring Security crypto.
import org.springframework.security.web.SecurityFilterChain; // Importing SecurityFilterChain interface from Spring Security web.

@Configuration // Annotation to indicate that this class is a configuration class.
@EnableWebSecurity // Annotation to enable Spring Security's web security configuration.
public class SecurityConfig { // Class defining security configuration for the application.

    // Bean for encoding passwords using BCrypt
    @Bean // Annotation to indicate that this method produces a bean to be managed by the Spring container.
    public PasswordEncoder passwordEncoder() { // Method to create a PasswordEncoder bean.
        return new BCryptPasswordEncoder(); // Returning a new instance of BCryptPasswordEncoder.
    }

    // Bean for providing user details service
    @Bean // Annotation to indicate that this method produces a bean to be managed by the Spring container.
    public UserDetailsService userDetailsService() { // Method to create a UserDetailsService bean.
        return new UserDetailsServicesImpl(); // Returning a new instance of UserDetailsServicesImpl.
    }

    // Bean for authentication manager
    @Bean // Annotation to indicate that this method produces a bean to be managed by the Spring container.
    public AuthenticationManager authenticationManager() { // Method to create an AuthenticationManager bean.

        DaoAuthenticationProvider authenticationProvider = // Creating a DaoAuthenticationProvider instance.
                new DaoAuthenticationProvider(); // Initializing the provider.

        authenticationProvider.setUserDetailsService(userDetailsService()); // Setting the user details service.
        authenticationProvider.setPasswordEncoder(passwordEncoder()); // Setting the password encoder.

        ProviderManager providerManager = // Creating a ProviderManager instance.
                new ProviderManager(authenticationProvider); // Initializing the manager with the authentication provider.

        return providerManager; // Returning the authentication manager.
    }

    // Bean for defining security filter chain
    @Bean // Annotation to indicate that this method produces a bean to be managed by the Spring container.
    public SecurityFilterChain securityFilterChain(HttpSecurity http) // Method to create a SecurityFilterChain bean.
            throws Exception {

        http.authorizeHttpRequests(auth -> auth // Configuring HTTP request authorization rules.
            .requestMatchers("/").permitAll() // Allowing access to the index page without authentication.
            .requestMatchers("/addReview").permitAll() // Allowing access to the addReview endpoint without authentication.
            .requestMatchers("/reviews/**").permitAll() // Allowing access to the reviews endpoint without authentication.
            .requestMatchers("/books/**").permitAll() // Allowing access to the books endpoint without authentication.
            .requestMatchers("/bookscript.js").permitAll() // Allowing access to the bookscript.js resource without authentication.
            .requestMatchers("/addBook").hasAnyAuthority("USER") // Allowing access to the addBook endpoint for users with the USER role.
            .requestMatchers(PathRequest.toH2Console()).permitAll() // Allowing access to the H2 console without authentication.
            .anyRequest().authenticated()) // Requiring authentication for any other requests.
            .httpBasic(Customizer.withDefaults()) // Configuring HTTP basic authentication with default settings.
            .formLogin(Customizer.withDefaults()); // Configuring form-based authentication with default settings.

        http.csrf((csrf) -> csrf.disable()); // Disabling CSRF protection.
        http.headers((headers) -> headers.frameOptions((frame) -> frame.sameOrigin())); // Configuring X-Frame-Options header.

        return http.build(); // Building the SecurityFilterChain.
    }
}
