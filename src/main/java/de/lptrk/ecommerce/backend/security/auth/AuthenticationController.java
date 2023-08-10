// Import required libraries and classes
package de.lptrk.ecommerce.backend.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    // Handle user registration requests
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        // Call the AuthenticationService's register method to process the request
        return ResponseEntity.ok(authenticationService.register(request));
    }

    // Handle user login requests
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ) {
        // Call the AuthenticationService's authenticate method to process the request
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
