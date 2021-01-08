package com.example.cinemareservationsystem.exception;

public class EntityDoesNotExistsException extends RuntimeException {



    public EntityDoesNotExistsException(String message) {
        super(message);
    }
}
