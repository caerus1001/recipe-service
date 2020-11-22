package org.spire.recipeservice.post.dto;

import java.util.List;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.spire.recipeservice.Photo;
import org.spire.recipeservice.author.model.Author;
import org.spire.recipeservice.recipe.Recipe;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePostDto {
    @Id
    @NotNull
    public String id;
    private String title;
    private String description;
    private String date;
    private Recipe recipe;
    private Author author;
    private List<Photo> photos;
}
