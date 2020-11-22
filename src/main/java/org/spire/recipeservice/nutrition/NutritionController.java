package org.spire.recipeservice.nutrition;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nutrition")
public class NutritionController {
    private NutritionService nutritionService;
}
