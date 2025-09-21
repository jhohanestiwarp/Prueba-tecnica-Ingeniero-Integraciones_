package com.project.commons.exception;

public class EmailAlreadyExistsException  extends RuntimeException {
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
