package org.spire.recipeservice.recipe;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
    public List<Recipe> getAllByTitleContaining(String title);
}
