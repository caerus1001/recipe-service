package org.spire.recipeservice.recipe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import stubs.RecipeMock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class RecipeControllerTest {

    @Mock
    private RecipeService recipeServiceMock;

    @InjectMocks
    private RecipeController recipeController;

    @Test
    public void addRecipe_addValidRecipe_shouldReturnRecipe() {
        Recipe recipeMock = RecipeMock.getRecipe();

        Mockito.when(recipeServiceMock.addRecipe(Mockito.any(Recipe.class))).thenReturn(recipeMock);

        Recipe expectedRecipe = recipeMock;
        Recipe actualRecipe = recipeController.addRecipe(recipeMock).getBody();
        Assertions.assertEquals(expectedRecipe.getId(), actualRecipe.getId());
        Assertions.assertEquals(expectedRecipe.getTitle(), actualRecipe.getTitle());
        Assertions.assertEquals(expectedRecipe.getDescription(), actualRecipe.getDescription());

        Review expectedReview = expectedRecipe.getReview();
        Review actualReview = actualRecipe.getReview();
        Assertions.assertEquals(expectedReview.getId(), actualReview.getId());
        Assertions.assertEquals(expectedReview.getTitle(), actualReview.getTitle());
        Assertions.assertEquals(expectedReview.getSummary(), actualReview.getSummary());
        Assertions.assertEquals(expectedReview.getRating(), actualReview.getRating());
    }

    @Test
    public void getRecipes_callGetRecipesEndpoint_shouldReturnAllRecipes() {
        List<Recipe> recipesMock = new ArrayList();
        recipesMock.add(RecipeMock.getRecipe());

        Mockito.when(recipeServiceMock.getAllRecipes()).thenReturn(recipesMock);

        List<Recipe> actualRecipes = recipeController.getRecipes(null, null).getBody();
        List<Recipe> expectedRecipes = recipesMock;

        Assertions.assertEquals(expectedRecipes.get(0).getId(), actualRecipes.get(0).getId());
        Assertions.assertEquals(expectedRecipes.get(0).getTitle(), actualRecipes.get(0).getTitle());
        Assertions.assertEquals(expectedRecipes.get(0).getDescription(), actualRecipes.get(0).getDescription());

        Review expectedReview = expectedRecipes.get(0).getReview();
        Review actualReview = actualRecipes.get(0).getReview();
        Assertions.assertEquals(expectedReview.getId(), actualReview.getId());
        Assertions.assertEquals(expectedReview.getTitle(), actualReview.getTitle());
        Assertions.assertEquals(expectedReview.getSummary(), actualReview.getSummary());
        Assertions.assertEquals(expectedReview.getRating(), actualReview.getRating());
    }
}
