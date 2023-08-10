// Import required libraries and add annotations for class properties
package de.lptrk.ecommerce.backend.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstName; // User's first name
    private String lastName; // User's last name
    private String userName; // User's username
    private String email; // User's email
    private String password; // User's password
    private Date createdAt; // Date of registration
    private Date updatedAt; // Date of last update
}
