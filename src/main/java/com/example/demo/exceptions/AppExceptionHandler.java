package com.example.demo.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(StandardException.class)
    public ResponseEntity<StandardError> handleAnyExceptions(StandardException e, HttpServletRequest request) {
        StandardError standardError = StandardError.builder()
                .timestamp(Instant.now())
                .status(e.getStatus())
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(standardError.getStatus()).body(standardError);
    }

}
