// Import required libraries and add annotations for class properties
package de.lptrk.ecommerce.backend.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    private String email; // User's email
    String password; // User's password
}
