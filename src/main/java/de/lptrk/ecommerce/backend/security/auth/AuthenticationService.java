// Import required libraries and classes
package de.lptrk.ecommerce.backend.security.auth;

import de.lptrk.ecommerce.backend.security.config.JwtService;
import de.lptrk.ecommerce.backend.user.UserEty;
import de.lptrk.ecommerce.backend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // Handle user registration
    public AuthenticationResponse register(RegisterRequest request) {
        // Create a new UserEty instance based on the registration request
        var user = UserEty.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .userName(request.getUserName())
                .password(passwordEncoder.encode(request.getPassword())) // Hash the password
                // TODO: Add user role
                .build();

        // Save the user details in the repository
        repository.save(user);

        // Generate a JWT token for the registered user
        var jwtToken = jwtService.generateToken(user);

        // Return the JWT token in the response
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    // Handle user authentication
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        // Authenticate user using the AuthenticationManager
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        // Find the user details in the repository based on the provided email
        var user = repository.findByEmail(request.getEmail()).orElseThrow();

        // Generate a JWT token for the authenticated user
        var jwtToken = jwtService.generateToken(user);

        // Return the JWT token in the response
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
