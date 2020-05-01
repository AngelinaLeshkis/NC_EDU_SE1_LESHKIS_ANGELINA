package fapi.controller;


import fapi.model.Status;
import fapi.model.User;
import fapi.serviceimpl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "fapi/users")
public class UserController {

    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        /*List<Status> statuses = new ArrayList<>();
        statuses.add(new Status("kek"));
        User user = new User(1L, "abc", "1111", "2222");
        user.setStatuses(statuses);*/
        return ResponseEntity.ok(userService.getUserById(id));
        //return ResponseEntity.ok(user);
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

}
