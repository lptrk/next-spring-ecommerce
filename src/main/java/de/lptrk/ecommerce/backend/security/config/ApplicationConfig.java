// Import required libraries and classes
package de.lptrk.ecommerce.backend.security.config;

import de.lptrk.ecommerce.backend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final UserRepository repository;

    // Define a custom UserDetailsService bean
    @Bean
    public UserDetailsService userDetailsService() {
        // Define an implementation of the UserDetailsService interface using a lambda expression
        return username -> (UserDetails) repository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    // Define an AuthenticationProvider bean
    @Bean
    public AuthenticationProvider authenticationProvider() {
        // Create a DaoAuthenticationProvider instance
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        // Set the UserDetailsService for authentication
        authProvider.setUserDetailsService(userDetailsService());
        // Set the PasswordEncoder for password hashing
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    // Define a PasswordEncoder bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Use BCryptPasswordEncoder for password hashing
        return new BCryptPasswordEncoder();
    }

    // Define an AuthenticationManager bean
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        // Obtain the AuthenticationManager from the provided AuthenticationConfiguration
        return authenticationConfiguration.getAuthenticationManager();
    }
}
