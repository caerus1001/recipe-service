package org.spire.recipeservice.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InvalidRequestObjectException extends Exception {
    private static final String ERROR_MESSAGE = "Invalid request object";
    private final String ID = "2";

    public InvalidRequestObjectException(String id) {
        super(ERROR_MESSAGE);
    }

    public String  getErrorMessage() {
        return ERROR_MESSAGE;
    }
}
