package com.controlller;

import com.dto.CreatePostDTO;
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

    @Autowired
    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @GetMapping("")
    Iterable<Post> getAllPosts() {
        return postService.getPosts();
    }

    @GetMapping(value = "/post/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable(name = "postId") Long id) {
        Optional<Post> post = postService.getPostByPostId(id);
        return post.isPresent() ? ResponseEntity.ok(post.get()) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/postsByUserId/{id}")
    public Iterable<Post> getPostsByUserId(@PathVariable(name = "id") long id) {
        return postService.getPostsByUserId(id);
    }

    @PostMapping(value = "/post")
    public Post savePost(@RequestBody CreatePostDTO postDTO) {
        return postService.savePost(postDTO);
    }

    @DeleteMapping(value = "/post/{id}")
    public void deletePost(@PathVariable(name = "id") Long id) {
        postService.deletePostByPostId(id);
    }


}
