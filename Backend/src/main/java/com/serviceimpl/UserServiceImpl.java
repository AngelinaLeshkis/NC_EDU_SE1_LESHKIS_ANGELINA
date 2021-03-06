package com.serviceimpl;

import com.entity.Role;
import com.entity.Status;
import com.entity.User;
import com.persistence.StatusRepository;
import com.persistence.UserRepository;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;
    private StatusRepository statusRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo, StatusRepository statusRepo) {
        this.userRepo = userRepo;
        this.statusRepo = statusRepo;
    }

    @Override
    public User saveUser(User user) {
        Status status = statusRepo.findById(1L)
                .orElseThrow(()-> new RuntimeException("User not found with id = " + 1));
        user.addStatus(status);
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepo.save(user);
    }

    @Override
    public Iterable<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }
}
