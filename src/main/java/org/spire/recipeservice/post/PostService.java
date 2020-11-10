package org.spire.recipeservice.post;

import org.spire.recipeservice.post.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final IPostRepository postRepository;

    public PostService(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPost(String id) {
        return postRepository.findById(id).get();
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Post post) {
        return postRepository.save(post);
    }

    public boolean deletePost(Post post) {
        try {
            postRepository.delete(post);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
