package com.pm.patientservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
       ex.getBindingResult().getFieldErrors().forEach(error-> {
           errors.put( error.getField(),
                    error.getDefaultMessage());
       });
        return ResponseEntity.badRequest().body(errors);
    }


    @ExceptionHandler(ResourceExistsException.class)
    public ResponseEntity<APIResponse> handleResourceExistsException(ResourceExistsException ex) {
        String message = ex.getMessage();
        APIResponse apiResponse = new APIResponse(message, false);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(apiResponse);
    }
}
