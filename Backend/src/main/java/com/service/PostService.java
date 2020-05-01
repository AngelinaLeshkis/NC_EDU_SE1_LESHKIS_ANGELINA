package com.service;

import com.dto.CreatePostDTO;
import com.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Post savePost(CreatePostDTO post);

    List<Post> getPostsByUserId(Long id);

    void deletePostByPostId(Long id);

    Iterable<Post> getPosts();

    Optional<Post> getPostByPostId(Long id);


}
