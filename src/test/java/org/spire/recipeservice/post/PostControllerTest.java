package org.spire.recipeservice.post;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.spire.recipeservice.post.model.Post;
import stubs.PostMock;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PostControllerTest {
    @Mock
    private PostService postService;

    @InjectMocks
    private PostController postController;

    @Test
    public void getPosts_callGetPostsEndpoint_shouldReturnExpectedPostsCount() {
        List<Post> postsMock = new ArrayList<>();
        postsMock.add(PostMock.getPost());

        Mockito.when(postService.getPosts()).thenReturn(postsMock);

        List<Post> expectedPosts = postsMock;
        List<Post> actualPosts = postController.getPosts().getBody();
        Assertions.assertEquals(expectedPosts.size(), actualPosts.size());

        Assertions.assertEquals(expectedPosts.get(0).getTitle(), actualPosts.get(0).getTitle());
        Assertions.assertEquals(expectedPosts.get(0).getDate(), actualPosts.get(0).getDate());

        Assertions.assertEquals(expectedPosts.get(0).getAuthor().getId(), actualPosts.get(0).getAuthor().getId());
    }

    @Test
    public void addPost_callAddPostEndpoint_shouldReturn200OkAndSavedPost() {
        Post postMock = PostMock.getPost();
        Mockito.when(postService.addPost(postMock)).thenReturn(postMock);

        Post expectedPost = postMock;
        Post actualPost = postController.addPost(postMock).getBody();

        Assertions.assertEquals(expectedPost.getId(), actualPost.getId());
        Assertions.assertEquals(expectedPost.getTitle(), actualPost.getTitle());
        Assertions.assertEquals(expectedPost.getDate(), actualPost.getDate());

        Assertions.assertEquals(expectedPost.getAuthor().getId(), actualPost.getAuthor().getId());
    }

    @Test
    public void updatePost_callUpdatePostEndpoint_shouldReturnUpdatedSavedPost() {
        Post postMock = PostMock.getPost();
        Mockito.when(postService.updatePost(postMock)).thenReturn(postMock);

        Post expectedPost = postMock;
        Post actualPost = postController.updatePost(postMock).getBody();

        Assertions.assertEquals(expectedPost.getId(), actualPost.getId());
        Assertions.assertEquals(expectedPost.getTitle(), actualPost.getTitle());
        Assertions.assertEquals(expectedPost.getDate(), actualPost.getDate());

        Assertions.assertEquals(expectedPost.getAuthor().getId(), actualPost.getAuthor().getId());
    }

    @Test
    public void deletePost_callDeletePostEndpoint_shouldReturnTrue() {
        Post postMock = PostMock.getPost();
        Mockito.when(postService.deletePost(postMock)).thenReturn(true);

        boolean actualResponse = postController.deletePost(postMock).getBody();

        Assertions.assertEquals(true, actualResponse);
    }
}
