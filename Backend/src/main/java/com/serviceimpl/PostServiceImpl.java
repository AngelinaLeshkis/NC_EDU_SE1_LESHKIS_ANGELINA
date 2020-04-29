package com.serviceimpl;

import com.entity.Post;
import com.persistence.PostRepository;
import com.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepo;

    @Autowired
    public PostServiceImpl(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public Post savePost(Post post) {
        return postRepo.save(post);
    }


    @Override
    public List<Post> getPostsByUserId(Long id) {
        return postRepo.findPostsByUserId(id);
    }


    @Override
    public void deletePostById(Long id) {
        postRepo.deleteById(id);
    }

    @Override
    public Optional<Post> getPostByUserId(Long id) {
        return postRepo.findById(id);
    }

    @Override
    public Iterable<Post> getPosts() {
        return postRepo.findAll();
    }
}
