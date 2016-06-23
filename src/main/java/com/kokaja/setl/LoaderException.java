package com.kokaja.setl;

/**
 * The type Loader exception.
 */
public class LoaderException extends Exception {

    // Constructors

    /**
     * Instantiates a new Loader exception.
     */
    public LoaderException() { }

    /**
     * Instantiates a new Loader exception.
     *
     * @param message the message
     */
    public LoaderException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Loader exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public LoaderException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Loader exception.
     *
     * @param cause the cause
     */
    public LoaderException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Loader exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public LoaderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
