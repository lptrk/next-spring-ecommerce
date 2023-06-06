package de.lptrk.ecommerce.backend.user;

import de.lptrk.ecommerce.backend.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public ResponseEntity<List<UserEty>> getUsers() {
        return new ResponseEntity<>(userService.getUser(), HttpStatus.OK);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<UserEty> getUserById(@PathVariable("id") Integer id) throws EntityNotFoundException {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    record newUserRequest(String userName,
                          String email,
                          String password,
                          Date createdAt,
                          Date updatedAt) {
    }

    @PostMapping("users")
    public ResponseEntity<UserEty> createUser(@RequestBody UserEty user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

}
