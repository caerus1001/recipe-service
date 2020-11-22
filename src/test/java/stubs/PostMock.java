package stubs;

import org.spire.recipeservice.Photo;
import org.spire.recipeservice.post.model.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class PostMock {
    public static Post getPost() {
        return new Post("42", "title", "description", LocalDateTime.now(), RecipeMock.getRecipe(), AuthorMock.getAuthor(),
                new ArrayList<Photo>(Collections.singletonList(PhotoMock.getPhoto())));
    }
}
