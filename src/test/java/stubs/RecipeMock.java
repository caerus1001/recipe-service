package stubs;

import org.spire.recipeservice.recipe.Recipe;

import java.time.LocalDateTime;

public class RecipeMock {
    public static Recipe getRecipe() {
        return new Recipe(
                "Mock id",
                "Mock title",
                "Mock description",
                NutritionMock.getNutrition(),
                ReviewMock.getReview(),
                LocalDateTime.now()
        );
    }
}
