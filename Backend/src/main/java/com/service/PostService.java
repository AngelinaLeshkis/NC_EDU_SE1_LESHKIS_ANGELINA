package com.service;

import com.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Post savePost(Post post);

    List<Post> getPostsByUserId(Long id);

    void deletePostById(Long id);

    Optional<Post> getPostByUserId(Long id);

    Iterable<Post> getPosts();


}
