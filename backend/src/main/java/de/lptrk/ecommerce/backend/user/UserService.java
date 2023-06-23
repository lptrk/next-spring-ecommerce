package de.lptrk.ecommerce.backend.user;

import de.lptrk.ecommerce.backend.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;

    public UserService(UserRepository userRepository, UserDTOMapper userDTOMapper) {
        this.userRepository = userRepository;
        this.userDTOMapper = userDTOMapper;
    }

    public List<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userDTOMapper)
                .collect(Collectors.toList()
                );
    }

    public UserDTO getUserById(Integer id) throws EntityNotFoundException {

        var user = userRepository.findById(id)
                .map(userDTOMapper);

        if (user.isEmpty()) throw new EntityNotFoundException();

        return user.get();
    }

    public UserEty saveUser(UserEty u) {
        return userRepository.save(u);
    }



    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
