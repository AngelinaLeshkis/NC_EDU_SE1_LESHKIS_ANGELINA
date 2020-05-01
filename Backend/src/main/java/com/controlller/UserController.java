package com.controlller;

import com.entity.Status;
import com.entity.User;
import com.persistence.StatusRepository;
import com.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/demo/users")
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        Optional<User> user = userService.getUserById(id);
        return user.isPresent() ? ResponseEntity.ok(user.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping(value = "")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping(value = "")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @PutMapping(value = "/updateUser")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping(value = "/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
