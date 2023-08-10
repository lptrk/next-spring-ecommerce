package de.lptrk.ecommerce.backend.user;

import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
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
