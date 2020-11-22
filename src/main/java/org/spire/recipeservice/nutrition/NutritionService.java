package org.spire.recipeservice.nutrition;

import org.springframework.stereotype.Service;

@Service
public class NutritionService {
    private final INutritionRepository nutritionRepository;

    public NutritionService(INutritionRepository nutritionRepository) {
        this.nutritionRepository = nutritionRepository;
    }
}
