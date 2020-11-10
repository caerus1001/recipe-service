package org.spire.recipeservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nutrition {
    @Id
    private String id;
    private double totalFat;
    private double sodium;
    private double dietaryFiber;
    private double protein;
    private double vitaminC;
    private double cholesterol;
    private double totalCarbohydrate;
    private double sugars;
    private double vitaminA;
}
