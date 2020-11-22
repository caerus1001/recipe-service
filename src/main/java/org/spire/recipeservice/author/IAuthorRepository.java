package org.spire.recipeservice.author;

import org.spire.recipeservice.author.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IAuthorRepository extends MongoRepository<Author, String> {
}
