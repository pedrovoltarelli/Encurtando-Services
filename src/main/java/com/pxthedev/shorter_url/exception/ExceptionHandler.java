package com.pxthedev.shorter_url.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Solicitação inválida");
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(OriginalUrlNotFoundException.class)
    protected ResponseEntity<String> handleOriginalUrlNotFound(OriginalUrlNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getLocalizedMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ExpiredUrlException.class)
    protected ResponseEntity<String> handleExpiredUrlException(ExpiredUrlException ex, WebRequest req) {
        return ResponseEntity.status(HttpStatus.GONE).body("This url is expired");
    }
}
