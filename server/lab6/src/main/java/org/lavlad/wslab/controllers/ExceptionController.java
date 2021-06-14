package org.lavlad.wslab.controllers;

import org.lavlad.wslab.exception.InvalidBookException;
import org.lavlad.wslab.exception.BookNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BookNotExistsException.class})
    public ResponseEntity<String> handleBookNotExists(BookNotExistsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler({InvalidBookException.class})
    public ResponseEntity<String> handleInvalidRequest(InvalidBookException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

}
