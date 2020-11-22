package stubs;

import org.spire.recipeservice.nutrition.Nutrition;

public class NutritionMock {
    public static Nutrition getNutrition() {
        return new Nutrition("id", 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }
}
