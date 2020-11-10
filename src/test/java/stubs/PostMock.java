package stubs;

import org.spire.recipeservice.Photo;
import org.spire.recipeservice.post.model.Post;

import java.util.ArrayList;
import java.util.Arrays;

public class PostMock {
    public static Post getPost() {
        return new Post("42", "title", "description", "date", RecipeMock.getRecipe(), AuthorMock.getAuthor(),
                new ArrayList<Photo>(Arrays.asList(PhotoMock.getPhoto())), NutritionMock.getNutrition());
    }
}
