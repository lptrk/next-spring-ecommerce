package de.lptrk.ecommerce.backend.user;

import de.lptrk.ecommerce.backend.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEty> getUser() {
        return userRepository.findAll();
    }

    public UserEty getUserById(Integer id) throws EntityNotFoundException {

        var user = userRepository.findById(id);

        if (user.isEmpty()) throw new EntityNotFoundException();

        return user.get();
    }

    public UserEty saveUser(UserEty u) {
        return userRepository.save(u);
    }
}
