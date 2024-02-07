package com.wedding.WeddingVenuePlanning.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoRecordFoundException.class)
    public ResponseEntity<String> NoDataFoundExceptionHandler()
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Venues Found");
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        return this.handleExceptionInternal(ex, (Object)null, headers, HttpStatus.BAD_REQUEST, request);
    }

}
