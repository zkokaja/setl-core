package com.kokaja.setl;

/**
 * The type Transformation exception.
 */
public class TransformationException extends Exception {

    // Constructors

    /**
     * Instantiates a new Transformation exception.
     */
    public TransformationException() { }

    /**
     * Instantiates a new Transformation exception.
     *
     * @param message the message
     */
    public TransformationException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Transformation exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public TransformationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Transformation exception.
     *
     * @param cause the cause
     */
    public TransformationException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Transformation exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public TransformationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
