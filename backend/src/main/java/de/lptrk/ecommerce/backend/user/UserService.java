package de.lptrk.ecommerce.backend.user;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<UserEty>getUser(){
        return userRepository.findAll();
    }

    public Optional<UserEty>getUserById(Integer id){
        return userRepository.findById(id);
    }

    public UserEty saveUser(UserEty u) {
        return userRepository.save(u);
    }
}
