package org.spire.recipeservice.post;

import java.util.List;
import javax.validation.Valid;

import org.bson.types.ObjectId;

import org.spire.recipeservice.exception.InvalidIdException;
import org.spire.recipeservice.post.dto.CreatePostDto;
import org.spire.recipeservice.post.dto.DeletePostDto;
import org.spire.recipeservice.post.dto.UpdatePostDto;
import org.spire.recipeservice.post.model.Post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    /**
     * Get all posts.
     *
     * @return list of posts.
     */
    @GetMapping("")
    public ResponseEntity<List<Post>> getPosts() {
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }

    /**
     * Get a post by id.
     *
     * @param id the mongo ObjectId id.
     * @return the post specified by id.
     * @throws InvalidIdException exception if ObjectId is invalid.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable String id) throws InvalidIdException {
        if (id == null || !ObjectId.isValid(id)) {
            throw new InvalidIdException(id);
        }

        return new ResponseEntity<>(postService.getPost(id), HttpStatus.OK);
    }

    /**
     * Create a post.
     *
     * @param post the post to create.
     * @return the successfully created post.
     */
    @PostMapping("")
    public ResponseEntity<Post> createPost(@RequestBody @Valid CreatePostDto post) {
        return new ResponseEntity<>(postService.createPost(post), HttpStatus.OK);
    }

    /**
     * Update a post.
     *
     * @param post the post to update.
     * @return the updated post.
     */
    @PutMapping("")
    public ResponseEntity<Post> updatePost(@RequestBody @Valid  UpdatePostDto post) throws InvalidIdException {
        String id = post.getId();
        if (id == null || !ObjectId.isValid(id)) {
            throw new InvalidIdException(id);
        }
        return new ResponseEntity<>(postService.updatePost(post), HttpStatus.OK);
    }

    /**
     * Delete a post.
     *
     * @param post the post to delete.
     * @return true if deletion successful, false otherwise.
     */
    @DeleteMapping("")
    public ResponseEntity<Boolean> deletePost(@RequestBody @Valid DeletePostDto post) throws InvalidIdException {
        String id = post.getId();
        if (id == null || !ObjectId.isValid(id)) {
            throw new InvalidIdException(id);
        }
        return new ResponseEntity<>(postService.deletePost(post), HttpStatus.OK);
    }
}
