package com.techguyseli.Eventster.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * GlobalExceptionHandler
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(HttpException.class)
  public ResponseEntity<String> handleNotFoundException(HttpException ex) {
    return ResponseEntity
        .status(ex.getStatus())
        .header("Content-Type", "text/plain")
        .body(ex.getMessage());
  }

}
