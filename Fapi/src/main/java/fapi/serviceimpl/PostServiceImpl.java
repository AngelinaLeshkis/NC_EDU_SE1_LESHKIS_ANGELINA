package fapi.serviceimpl;

import fapi.model.Post;
import fapi.model.User;
import fapi.service.PostService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service(value = "postService")
public class PostServiceImpl implements PostService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

   /* @Override
    public Post savePost(CreatePostDTO post) {
        return null;
    }*/

    @Override
    public Iterable<Post> getPostsByUserId(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Post[] response = restTemplate.getForObject(backendServerUrl + "demo/posts/postsByUserId/" + id, Post[].class);
        return response == null ? Collections.emptyList() : Arrays.asList(response);
    }

    @Override
    public void deletePostByPostId(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "demo/posts/post/" + id);
    }

    @Override
    public Post getPostByPostId(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "demo/posts/post/" + id, Post.class);
    }

    @Override
    public Iterable<Post> getPosts() {
        RestTemplate restTemplate = new RestTemplate();
        Post[] response = restTemplate.getForObject(backendServerUrl + "demo/posts", Post[].class);
        return response == null ? Collections.emptyList() : Arrays.asList(response);
    }
}
