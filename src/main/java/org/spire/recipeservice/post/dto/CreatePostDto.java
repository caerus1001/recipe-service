package org.spire.recipeservice.post.dto;

import java.util.List;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.spire.recipeservice.Photo;
import org.spire.recipeservice.author.model.Author;
import org.spire.recipeservice.recipe.Recipe;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostDto {
    @NotNull
    private String title;
    @NotNull
    private String description;
    private Recipe recipe;
    private Author author;
    private List<Photo> photos;
}
