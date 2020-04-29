package com.controlller;

import com.entity.Post;
import com.serviceimpl.PostServiceImpl;
import com.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/demo/posts")
public class PostController {

    private PostServiceImpl postService;
    private UserServiceImpl userService;

    @Autowired
    public PostController(PostServiceImpl postService, UserServiceImpl userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("")
    Iterable<Post> getAllPosts() {
        return postService.getPosts();
    }

    @GetMapping(value = "/post/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable(name = "postId") Long id) {
        Optional<Post> post = postService.getPostByUserId(id);
        return post.isPresent() ? ResponseEntity.ok(post.get()) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/postsByUserId/{id}")
    public Iterable<Post> getPostsByUserId(@PathVariable(name = "id") long id) {
        return postService.getPostsByUserId(id);
    }

    @PostMapping(value = "/post")
    public Post savePost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @DeleteMapping(value = "/post/{id}")
    public void deletePost(@PathVariable(name = "id") Long id) {
        postService.deletePostById(id);
    }





}
