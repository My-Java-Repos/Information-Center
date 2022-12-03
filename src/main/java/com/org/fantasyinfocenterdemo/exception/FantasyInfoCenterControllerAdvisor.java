package com.org.fantasyinfocenterdemo.exception;

import com.org.fantasyinfocenterdemo.model.dto.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.Date;

@ControllerAdvice
public class FantasyInfoCenterControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<?> handleValidationError(IllegalArgumentException ex, WebRequest webRequest) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(LocalDate.now(),
                400,
                "Bad Request",
                "Required request body is missing or invalid.",
                ((ServletWebRequest) request).getRequest().getRequestURI());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FantasyInfoCenterExistingEntityException.class)
    public final ResponseEntity<?> handleExistingEntityRecordException(FantasyInfoCenterExistingEntityException ex, WebRequest request) {
        HttpHeaders httpHeaders = new HttpHeaders();

        ErrorResponse errorResponse = new ErrorResponse(LocalDate.now(),
                HttpStatus.CONFLICT.value(),
                "Conflict",
                ex.getMessage(),
                ((ServletWebRequest) request).getRequest().getRequestURI());

        return handleExceptionInternal(ex, errorResponse, httpHeaders, HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(FantasyInfoCenterEntityNotFound.class)
    public final ResponseEntity<?> handleEntityNotFoundException(FantasyInfoCenterEntityNotFound ex, WebRequest request) {
        HttpHeaders httpHeaders = new HttpHeaders();

        ErrorResponse errorResponse = new ErrorResponse(LocalDate.now(),
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                ex.getMessage(),
                ((ServletWebRequest) request).getRequest().getRequestURI());

        return handleExceptionInternal(ex, errorResponse, httpHeaders, HttpStatus.NOT_FOUND, request);
    }
}
