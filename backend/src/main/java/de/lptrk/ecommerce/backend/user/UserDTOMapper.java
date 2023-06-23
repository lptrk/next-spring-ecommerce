package de.lptrk.ecommerce.backend.user;

import java.util.function.Function;

public class UserDTOMapper implements Function<UserEty, UserDTO> {

    @Override
    public UserDTO apply(UserEty userEty) {
        return new UserDTO(
                userEty.getId(),
                userEty.getFirstName(),
                userEty.getLastName(),
                userEty.getUsername(),
                userEty.getEmail()
        );

    }
}
