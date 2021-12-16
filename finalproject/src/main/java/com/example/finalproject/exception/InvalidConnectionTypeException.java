package com.example.finalproject.exception;

public class InvalidConnectionTypeException extends Exception{
    public InvalidConnectionTypeException(String message){
        super(message);
    }

    public InvalidConnectionTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidConnectionTypeException(Throwable cause) {
        super(cause);
    }

    public InvalidConnectionTypeException() {
    }
}
