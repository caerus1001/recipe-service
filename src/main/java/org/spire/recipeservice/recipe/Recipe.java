package org.spire.recipeservice.recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    private String id;
    private String title;
    private String description;
    private Review review;
    @CreatedDate
    private LocalDateTime createdDate;
}
