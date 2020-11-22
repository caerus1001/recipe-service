package org.spire.recipeservice.post;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.spire.recipeservice.exception.InvalidIdException;
import org.spire.recipeservice.post.dto.CreatePostDto;
import org.spire.recipeservice.post.dto.DeletePostDto;
import org.spire.recipeservice.post.dto.UpdatePostDto;
import org.spire.recipeservice.post.model.Post;
import org.springframework.ui.Model;
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
        Assertions.assertEquals(expectedPosts.get(0).getCreatedDate(), actualPosts.get(0).getCreatedDate());

        Assertions.assertEquals(expectedPosts.get(0).getAuthor().getId(), actualPosts.get(0).getAuthor().getId());
    }

    @Test
    public void addPost_callAddPostEndpoint_shouldReturn200OkAndSavedPost() {
        ModelMapper modelMapper = new ModelMapper();

        Post postMock = PostMock.getPost();
        CreatePostDto createPostObj = modelMapper.map(postMock, CreatePostDto.class);
        Mockito.when(postService.createPost(createPostObj)).thenReturn(postMock);

        Post expectedPost = postMock;
        Post actualPost = postController.createPost(createPostObj).getBody();

        Assertions.assertEquals(expectedPost.getId(), actualPost.getId());
        Assertions.assertEquals(expectedPost.getTitle(), actualPost.getTitle());
        Assertions.assertEquals(expectedPost.getCreatedDate(), actualPost.getCreatedDate());

        Assertions.assertEquals(expectedPost.getAuthor().getId(), actualPost.getAuthor().getId());
    }

    @Test
    public void updatePost_callUpdatePostEndpoint_shouldReturnUpdatedSavedPost() throws InvalidIdException  {
        ModelMapper modelMapper = new ModelMapper();

        Post postMock = PostMock.getPost();
        postMock.setId("5fba2638b707441b23c03769");
        UpdatePostDto updatePostDto = modelMapper.map(postMock, UpdatePostDto.class);
        Mockito.when(postService.updatePost(updatePostDto)).thenReturn(postMock);

        Post expectedPost = postMock;
        Post actualPost = postController.updatePost(updatePostDto).getBody();

        Assertions.assertEquals(expectedPost.getId(), actualPost.getId());
        Assertions.assertEquals(expectedPost.getTitle(), actualPost.getTitle());
        Assertions.assertEquals(expectedPost.getCreatedDate(), actualPost.getCreatedDate());

        Assertions.assertEquals(expectedPost.getAuthor().getId(), actualPost.getAuthor().getId());
    }

    @Test
    public void deletePost_callDeletePostEndpoint_shouldReturnTrue() throws InvalidIdException {
        ModelMapper modelMapper = new ModelMapper();
        Post postMock = PostMock.getPost();
        postMock.setId("5fba2638b707441b23c03769");
        DeletePostDto deletePostDto = modelMapper.map(postMock, DeletePostDto.class);
        Mockito.when(postService.deletePost(deletePostDto)).thenReturn(true);

        boolean actualResponse = postController.deletePost(deletePostDto).getBody();

        Assertions.assertEquals(true, actualResponse);
    }
}
