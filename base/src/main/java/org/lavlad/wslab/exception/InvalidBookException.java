package org.lavlad.wslab.exception;

public class InvalidBookException extends RuntimeException {

    private static final String TEMPLATE = "Invalid argument provided: %s";

    public InvalidBookException(String errorMsg) {
        super(String.format(TEMPLATE, errorMsg));
    }
}
