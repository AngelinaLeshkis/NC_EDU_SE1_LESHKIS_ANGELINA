package com.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role", catalog = "testdb")
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private RoleEn role;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Role(Long id, RoleEn role) {
        this.id = id;
        this.role = role;
    }

    public Role() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleEn getRole() {
        return role;
    }

    public void setRole(RoleEn role) {
        this.role = role;
    }
}
