package org.spire.recipeservice.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InvalidIdException extends Exception {
    private static final String ERROR_MESSAGE = "Invalid ID format";
    private String id;

    public InvalidIdException(String id) {
        super(ERROR_MESSAGE);
        this.id = id;
    }
}
