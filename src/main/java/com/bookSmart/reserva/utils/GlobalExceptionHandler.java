package com.bookSmart.reserva.utils;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public CustomResponseEntity hanldeEntityNotFound(EntityNotFoundException ex){
        return new CustomResponseEntity(null, ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public CustomResponseEntity hanldeDataIntegrityViolationException(DataIntegrityViolationException ex){
        return new CustomResponseEntity(null, ex.getMessage(), HttpStatus.CONFLICT);
    }

}
