package com.mpr.helpdesk.application.common;

import com.mpr.helpdesk.application.common.exceptions.NegocioException;
import com.mpr.helpdesk.application.common.exceptions.NotFoundException;
import com.mpr.helpdesk.application.common.exceptions.Error;
import com.mpr.helpdesk.application.common.exceptions.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Error> objectNotFoundException(NotFoundException e, HttpServletRequest request) {


        Error error = new Error(e.getDetail(), e.getSource());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<Error> negocioException(NegocioException e, HttpServletRequest request) {


        Error error = new Error(e.getDetail(), e.getSource());

        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationException> validationException(MethodArgumentNotValidException e, HttpServletRequest request) {


        ValidationException errors = new ValidationException();

        for (FieldError error : e.getBindingResult().getFieldErrors()){
            errors.addError(error.getField(), error.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(errors);

    }


}
