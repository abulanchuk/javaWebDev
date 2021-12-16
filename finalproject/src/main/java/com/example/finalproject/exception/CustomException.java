package com.example.finalproject.exception;

public class CustomException extends Exception{
    public CustomException(String message){
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public CustomException() {
    }
}
