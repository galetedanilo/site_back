package com.galetedanilo.site.controllers;

import com.galetedanilo.site.exceptions.SignUpException;
import com.galetedanilo.site.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {SignUpException.class})
    protected ResponseEntity<ErrorResponse> signUpExceptionHandler(SignUpException ex, HttpServletRequest req) {
        HttpStatus httpStatus = HttpStatus.CONFLICT;

        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setTimestamp(Instant.now());
        errorResponse.setStatus(httpStatus.value());
        errorResponse.setCode(ex.getApplicationErrorCode());
        errorResponse.setType(ex.getApplicationErrorType());
        errorResponse.setPath(req.getRequestURI());
        errorResponse.addMessage(ex.getMessage());

        return ResponseEntity.status(httpStatus).body(errorResponse);
    }
}
