package com.kokaja.setl;

/**
 * A Validator must validate an entire {@link Record}.
 */
public interface Validator {

    /**
     * Validate the given record.
     *
     * @param record the record
     * @throws ValidationException if the given record is invalid
     */
    void validate(Record record) throws ValidationException;
}
