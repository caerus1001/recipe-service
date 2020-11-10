package org.spire.recipeservice.recipe;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        return new ResponseEntity<>(recipeService.addRecipe(recipe), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Recipe>> getRecipes(
            @RequestParam(required = false) @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime endDate) {

        return
                startDate != null && endDate != null ? new ResponseEntity<>(recipeService.getRecipesByFromDate(startDate, endDate), HttpStatus.OK) :
                new ResponseEntity<>(recipeService.getAllRecipes(), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe) {
        return new ResponseEntity<>(recipeService.updateRecipe(recipe), HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<Boolean> deleteRecipe(Recipe recipe) {
        return new ResponseEntity<>(recipeService.deleteRecipe(recipe), HttpStatus.OK);
    }

}
