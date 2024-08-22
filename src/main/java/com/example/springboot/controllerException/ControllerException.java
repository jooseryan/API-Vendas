package com.example.springboot.controllerException;

import com.example.springboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerException extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorHandle> errorHandleList (MethodArgumentNotValidException exception){

        List<FieldError> fieldErrorList = exception.getBindingResult().getFieldErrors();
        List<ErrorHandle> list = new ArrayList<>();

        fieldErrorList.forEach(error -> list.add(new ErrorHandle(error.getField(), error.getDefaultMessage())));
        return list;
    }
}
