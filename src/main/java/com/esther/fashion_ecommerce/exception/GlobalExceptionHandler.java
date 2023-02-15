package com.esther.fashion_ecommerce.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> fileNotFound(UserNotFoundException userId, HttpServletRequest req){
       CustomErrorResponse errorMessage = new CustomErrorResponse(
               ZonedDateTime.now(),
               HttpStatus.NOT_FOUND.value(),
                req.getRequestURI(),
                userId.getMessage()
       );

        return new ResponseEntity<> (errorMessage, HttpStatus.NOT_FOUND);
    }
}
