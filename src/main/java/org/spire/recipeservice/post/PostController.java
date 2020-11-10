package org.spire.recipeservice.post;

import org.spire.recipeservice.post.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public ResponseEntity<List<Post>> getPosts() {
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable String id) {
        return new ResponseEntity<>(postService.getPost(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Post> addPost(@RequestBody Post post) {
        return new ResponseEntity<>(postService.addPost(post), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {
        return new ResponseEntity<>(postService.updatePost(post), HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<Boolean> deletePost(@RequestBody Post post) {
        return new ResponseEntity<>(postService.deletePost(post), HttpStatus.OK);
    }
}
