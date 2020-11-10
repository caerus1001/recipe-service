package org.spire.recipeservice.post;

import org.spire.recipeservice.post.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPostRepository extends MongoRepository<Post, String> {
}
