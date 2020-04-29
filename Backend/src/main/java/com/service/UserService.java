package com.service;

import com.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);

    Iterable<User> getUsers();

    Optional <User> getUserById(Long id);


}
