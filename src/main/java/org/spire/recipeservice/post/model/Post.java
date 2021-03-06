package org.spire.recipeservice.post.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.spire.recipeservice.author.model.Author;
import org.spire.recipeservice.Photo;
import org.spire.recipeservice.recipe.Recipe;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    private String id;
    private String title;
    private String description;
    @CreatedDate
    private LocalDateTime createdDate;
    private Recipe recipe;
    private Author author;
    private List<Photo> photos;
}
