package fapi.serviceimpl;

import fapi.model.User;
import fapi.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Value("${backend.server.url}")
    private String backendServerUrl;


    @Override
    public ResponseEntity<String> saveUser(User user) {
       return null;
    }

    @Override
    public void deleteUser(long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "users/" + id);
    }

    @Override
    public void updateUser(User user) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(backendServerUrl + "users/", user, User.class);
    }


    @Override
    public List<User> getUsers() {
        RestTemplate restTemplate = new RestTemplate();
        User[] response = restTemplate.getForObject(backendServerUrl + "users/all", User[].class);
        return response == null ? Collections.emptyList() : Arrays.asList(response);
    }

    @Override
    public User getUserById(long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "demo/users/user/" + id, User.class);
    }


}
