package org.spire.recipeservice.post;

import java.util.List;

import org.modelmapper.ModelMapper;

import org.spire.recipeservice.post.dto.CreatePostDto;
import org.spire.recipeservice.post.dto.DeletePostDto;
import org.spire.recipeservice.post.dto.UpdatePostDto;
import org.spire.recipeservice.post.model.Post;

import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final IPostRepository postRepository;
    private final ModelMapper modelMapper;

    public PostService(IPostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Get all posts.
     *
     * @return lists of all posts.
     */
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    /**
     * Get a post by id.
     *
     * @param id the ObjectId id of post.
     * @return the post specified by id.
     */
    public Post getPost(String id) {
        return postRepository.findById(id).orElse(null);
    }

    public Post createPost(CreatePostDto post) {
        Post postObj  = modelMapper.map(post, Post.class);

        return postRepository.save(postObj);
    }

    public Post updatePost(UpdatePostDto post) {
        Post postObj = modelMapper.map(post, Post.class);

        return postRepository.save(postObj);
    }

    public boolean deletePost(DeletePostDto post) {
        Post postObj = modelMapper.map(post, Post.class);

        try {
            postRepository.delete(postObj);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
