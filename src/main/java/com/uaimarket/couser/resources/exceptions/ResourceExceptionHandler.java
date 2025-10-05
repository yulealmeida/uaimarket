package com.uaimarket.couser.resources.exceptions;


import com.uaimarket.couser.services.exceptions.DatabaseExeption;
import com.uaimarket.couser.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(),status.value(),error,request.getRequestURI(),e.getMessage());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseExeption.class)
    public ResponseEntity<StandardError> database(DatabaseExeption e, HttpServletRequest request){
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(),status.value(),error,request.getRequestURI(),e.getMessage());
        return ResponseEntity.status(status).body(err);
    }


}
