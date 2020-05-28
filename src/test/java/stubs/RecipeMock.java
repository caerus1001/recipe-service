package stubs;

import org.spire.recipeservice.recipe.Recipe;

public class RecipeMock {
    public static Recipe getRecipeMock() {
        return new Recipe(
                "Mock id",
                "Mock title",
                "Mock description",
                ReviewMock.getReviewMock()
        );
    }
}
