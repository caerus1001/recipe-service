package stubs;

import org.spire.recipeservice.recipe.Review;

public class ReviewMock {
    public static Review getReview() {
        return new Review(
          "Mock id",
          "Mock title",
          "Mock summary",
          0
        );
    }
}
