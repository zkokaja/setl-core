package com.kokaja.setl;

/**
 * The type Extractor exception.
 */
public class ExtractorException extends Exception {

    // Constructors

    /**
     * Instantiates a new Extractor exception.
     */
    public ExtractorException() {
    }

    /**
     * Instantiates a new Extractor exception.
     *
     * @param message the message
     */
    public ExtractorException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Extractor exception.
     *
     * @param cause the cause
     */
    public ExtractorException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Extractor exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ExtractorException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Extractor exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public ExtractorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
