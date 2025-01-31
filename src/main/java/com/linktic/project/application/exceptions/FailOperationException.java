package com.linktic.project.application.exceptions;

public class FailOperationException extends RuntimeException {
    public FailOperationException() {
        super("Error interno del sistema");
    }

    public FailOperationException(String message) {
        super(message);
    }
}
