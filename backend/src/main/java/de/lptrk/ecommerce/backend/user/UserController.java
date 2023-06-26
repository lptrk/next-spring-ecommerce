package de.lptrk.ecommerce.backend.user;

import de.lptrk.ecommerce.backend.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Integer id) throws EntityNotFoundException {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("users")
    public ResponseEntity<UserEty> createUser(@RequestBody UserEty user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}
//   {
//        "firstname":"Patrik",
//        "lastname":"Lakatos",
//        "username":"lptrk",
//        "email": "lakatos.p@gmx.de",
//        "password": "Patrik"
//        "createdAt": null,
//        "updatedAt": null
//    }