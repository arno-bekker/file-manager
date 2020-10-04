package com.mycompany.exception;

public class InvalidDirectoryException extends RuntimeException {
    public InvalidDirectoryException(String exception) {
        super(exception);
    }
}
