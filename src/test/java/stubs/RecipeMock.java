package stubs;

import org.spire.recipeservice.recipe.Recipe;

import java.time.LocalDateTime;
import java.util.Date;

public class RecipeMock {
    public static Recipe getRecipe() {
        return new Recipe(
                "Mock id",
                "Mock title",
                "Mock description",
                ReviewMock.getReview(),
                LocalDateTime.now()
        );
    }
}
