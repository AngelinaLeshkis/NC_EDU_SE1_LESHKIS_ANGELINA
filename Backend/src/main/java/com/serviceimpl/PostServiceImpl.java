package com.serviceimpl;

import com.dto.CreatePostDTO;
import com.entity.Post;
import com.entity.User;
import com.persistence.PostRepository;
import com.persistence.UserRepository;
import com.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepo;
    private UserRepository userRepo;

    @Autowired
    public PostServiceImpl(PostRepository postRepo, UserRepository userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Post savePost(CreatePostDTO postDTO) {
        User user = userRepo.findById(postDTO.getUserId())
                .orElseThrow(()-> new RuntimeException("User not found with id = " + postDTO.getUserId()));
        Post post = new Post();
        post.setDate(postDTO.getDate());
        post.setText(postDTO.getText());
        post.setUser(user);
        return postRepo.save(post);
    }


    @Override
    public List<Post> getPostsByUserId(Long id) {
        return postRepo.findPostsByUserId(id);
    }


    @Override
    public void deletePostByPostId(Long id) {
        postRepo.deleteById(id);
    }

    @Override
    public Iterable<Post> getPosts() {
        return postRepo.findAll();
    }

    @Override
    public Optional<Post> getPostByPostId(Long id) {
        return postRepo.findById(id);
    }
}
