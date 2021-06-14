package org.lavlad.wslab.exception;

public class UmbrellaException extends RuntimeException {

    private static final String message = "Request produced an error: %s";

    public UmbrellaException(String errorMsg) {
        super(String.format(errorMsg, errorMsg));
    }
}
