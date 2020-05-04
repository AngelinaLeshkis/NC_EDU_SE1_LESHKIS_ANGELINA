package fapi.controller;

import fapi.dto.CreatePostDTO;
import fapi.model.Post;
import fapi.model.User;
import fapi.serviceimpl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "fapi/posts")
public class PostController {

    private PostServiceImpl postService;

    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @PostMapping("/addPost")
    public ResponseEntity<Post> savePost(@RequestBody CreatePostDTO postDTO) {
        return postService.savePost(postDTO);
    }

    @GetMapping("")
    Iterable<Post> getAllPosts() {
        return postService.getPosts();
    }

    @GetMapping(value = "/post/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable(name = "postId") Long id) {
        return ResponseEntity.ok(postService.getPostByPostId(id));
    }

    @GetMapping(value = "/postsByUserId/{id}")
    public Iterable<Post> getPostsByUserId(@PathVariable(name = "id") long id) {
        return postService.getPostsByUserId(id);
    }

    @DeleteMapping(value = "/post/{id}")
    public void deletePost(@PathVariable(name = "id") Long id) {
        postService.deletePostByPostId(id);
    }



}
