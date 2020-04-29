package fapi.model;

import java.util.List;

public class User {

    private Long id;

    private String username;

    private String password;

    private String email;

    private List<Status> statuses;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Status> getStatus() {
        return statuses;
    }

    public void setStatus(List<Status> statuses) {
        this.statuses = statuses;
    }
}
