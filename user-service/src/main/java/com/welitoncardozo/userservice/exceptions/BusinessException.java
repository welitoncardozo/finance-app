package com.welitoncardozo.userservice.exceptions;

public class BusinessException extends RuntimeException {
    public BusinessException() {
        super();
    }

    public BusinessException(final String message, final Object... messageData) {
        super(String.format(message, messageData));
    }

    public BusinessException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BusinessException(final String message, final Throwable cause, final Object... messageData) {
        super(String.format(message, messageData), cause);
    }
}
