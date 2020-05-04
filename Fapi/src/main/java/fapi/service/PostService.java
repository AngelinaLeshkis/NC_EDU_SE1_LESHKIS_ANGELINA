package fapi.service;

import fapi.dto.CreatePostDTO;
import fapi.model.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PostService {

    ResponseEntity<Post> savePost(CreatePostDTO post);

    Iterable<Post> getPostsByUserId(Long id);

    void deletePostByPostId(Long id);

    Post getPostByPostId(Long id);

    Iterable<Post> getPosts();
}
