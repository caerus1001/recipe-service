package org.spire.recipeservice;

import org.bson.types.ObjectId;

import org.spire.recipeservice.exception.ExceptionResponse;
import org.spire.recipeservice.exception.InvalidIdException;
import org.spire.recipeservice.exception.InvalidRequestObjectException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler({ InvalidIdException.class })
    public ResponseEntity<ExceptionResponse> handleInvalidIdException(InvalidIdException exception) {

        String id = exception.getId() != null ? exception.getId() : "-1";
        String errorCode;
        if (!ObjectId.isValid(id)) {
            errorCode = "0";
        } else {
            errorCode = "1";
        }

        ExceptionResponse exceptionResponse = new ExceptionResponse(errorCode, exception.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {

        InvalidRequestObjectException invalidRequestObjectException = new InvalidRequestObjectException();

        ExceptionResponse exceptionResponse = new ExceptionResponse(
                invalidRequestObjectException.getID(), invalidRequestObjectException.getErrorMessage() );

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
