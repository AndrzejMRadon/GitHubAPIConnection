package com.atipera.app.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleIOException(RuntimeException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", 404);
        body.put("message", "User not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}