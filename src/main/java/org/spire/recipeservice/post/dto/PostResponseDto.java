package org.spire.recipeservice.post.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.spire.recipeservice.Photo;
import org.spire.recipeservice.author.model.Author;
import org.spire.recipeservice.recipe.Recipe;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {
    @Id
    private String id;
    private String title;
    private String description;
    private String date;
    private Recipe recipe;
    private Author author;
    private List<Photo> photos;
}
