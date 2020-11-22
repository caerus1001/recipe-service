package org.spire.recipeservice.recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.spire.recipeservice.nutrition.Nutrition;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    private String id;
    private String title;
    private String description;
    private Nutrition nutrition;
    private Review review;
    @CreatedDate
    private LocalDateTime createdDate;
}
