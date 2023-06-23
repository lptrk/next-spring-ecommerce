package de.lptrk.ecommerce.backend.user;

public record UserDTO(
        Integer id,
        String firstName,
        String lastName,
        String userName,
        String email
) {
}
