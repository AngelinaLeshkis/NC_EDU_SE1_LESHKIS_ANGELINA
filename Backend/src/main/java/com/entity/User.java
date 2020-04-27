package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user", catalog = "testdb")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String username;
        private String password;
        private String email;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
        private List<Post> posts;

        @ManyToMany
        @JoinTable(
                name = "user_role",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
        private List<Role> roles;

        @ManyToMany
        @JoinTable(
                name = "user_status",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "status_id"))
        private List<Status> statuses;

        public List<Status> getStatuses() {
                return statuses;
        }

        public void setStatuses(List<Status> statuses) {
                this.statuses = statuses;
        }

        public User() {
        }

        public User(String username, String password, String email) {
                this.username = username;
                this.password = password;
                this.email = email;
        }

        public User(Long id, String username, String password, String email,List<Status> statuses) {
                this.id = id;
                this.username = username;
                this.password = password;
                this.email = email;
                this.statuses = statuses;
        }

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

        public List<Post> getPosts() {
                return posts;
        }

        public void setPosts(List<Post> posts) {
                this.posts = posts;
        }

        public List<Role> getRoles() {
                return roles;
        }

        public void setRoles(List<Role> roles) {
                this.roles = roles;
        }

}
