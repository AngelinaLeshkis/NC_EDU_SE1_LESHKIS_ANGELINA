package com.service;

import com.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    void deleteUser(long id);

    void updateUser(User user);

    List<User> getUsers();

    Optional <User> getUserById(long id);


}
