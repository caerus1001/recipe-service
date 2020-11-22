package org.spire.recipeservice.nutrition;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface INutritionRepository extends MongoRepository<Nutrition, String> {
}
