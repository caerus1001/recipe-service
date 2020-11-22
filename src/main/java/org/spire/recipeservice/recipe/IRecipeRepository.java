package org.spire.recipeservice.recipe;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IRecipeRepository extends MongoRepository<Recipe, String> {
    public List<Recipe> getAllByTitleContaining(String title);
    public List<Recipe> getAllByCreatedDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    public List<Recipe> getAllByCreatedDateAfter(LocalDateTime startDate);
    public List<Recipe> getAllByCreatedDateBefore(LocalDateTime endDate);
}
