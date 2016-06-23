package com.kokaja.setl;

/**
 * An ErrorHandler's responsibility is to handle exceptions thrown while
 * processing a {@link Job}.
 */
public interface ErrorHandler {

    /**
     * Handle a {@link LoaderException}.
     *
     * @param record the record
     * @param e      the e
     */
    void handleException(Record record, LoaderException e);

    /**
     * Handle a {@link TransformationException}.
     *
     * @param record the record
     * @param e      the e
     */
    void handleException(Record record, TransformationException e);

    /**
     * Handle a {@link ValidationException}.
     *
     * @param record the record
     * @param e      the e
     */
    void handleException(Record record, ValidationException e);
}
