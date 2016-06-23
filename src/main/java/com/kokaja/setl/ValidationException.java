package com.kokaja.setl;

/**
 * The type Validation exception.
 */
public class ValidationException extends Exception {

    // Constructors

    /**
     * Instantiates a new Validation exception.
     */
    public ValidationException() {
    }

    /**
     * Instantiates a new Validation exception.
     *
     * @param cause the cause
     */
    public ValidationException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Validation exception.
     *
     * @param message the message
     */
    public ValidationException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Validation exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Validation exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public ValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
