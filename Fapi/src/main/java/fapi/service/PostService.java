package fapi.service;

import fapi.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    //Post savePost(CreatePostDTO post);

    Iterable<Post> getPostsByUserId(Long id);

    void deletePostByPostId(Long id);

    Post getPostByPostId(Long id);

    Iterable<Post> getPosts();
}
