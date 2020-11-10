package org.spire.recipeservice.recipe;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public List<Recipe> getRecipesByFromDate(LocalDateTime startDate, LocalDateTime endDate) {
        return recipeRepository.getAllByCreatedDateBetween(startDate, endDate);
    }

    public Recipe updateRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public boolean deleteRecipe(Recipe recipe) {
        try {
            recipeRepository.delete(recipe);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
