package com.example.springboot.controllerException;
public class ErrorHandle {

   private String field;
   private String message;

    public ErrorHandle(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
