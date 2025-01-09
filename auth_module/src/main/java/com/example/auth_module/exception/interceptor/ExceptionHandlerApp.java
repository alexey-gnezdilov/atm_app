package com.example.auth_module.exception.interceptor;

import com.example.auth_module.exception.AbstractException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerApp {

    @ExceptionHandler(AbstractException.class)
    public ResponseEntity<?> catchException(AbstractException e) {
        return ResponseEntity.status(e.getCode()).body(e.getMessage());
    }
}
