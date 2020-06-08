package com.airline.ticketing.ticketer.controller.exception;

import com.airline.ticketing.ticketer.resource.ErrorResource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.NoResultException;

@ControllerAdvice(basePackages = {"com.airline.ticketing.ticketer.controller"})
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    protected ResponseEntity<Object> handleUnsupportedOperationException(UnsupportedOperationException ex, WebRequest request) {
        return handleException(HttpStatus.METHOD_NOT_ALLOWED, ex, request);
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleNoResultException(NoResultException ex, WebRequest request) {
        return handleException(HttpStatus.NOT_FOUND, ex, request);
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request) {
        return handleException(HttpStatus.NOT_FOUND, ex, request);
    }

    private ResponseEntity<Object> handleException(HttpStatus status, RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, createErrorResource(status, ex.getMessage()),
                new HttpHeaders(), status, request);
    }

    private ErrorResource createErrorResource(HttpStatus status, String detail) {
        ErrorResource resource = new ErrorResource();
        resource.setError_status(status.value());
        resource.setError_message(status.getReasonPhrase());
        resource.setDetail(detail);

        return resource;
    }

}
