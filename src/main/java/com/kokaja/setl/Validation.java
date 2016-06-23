package com.kokaja.setl;

/**
 * A Validation's responsibility is to validate a particular {@link Field} on
 * a given {@link Reocrd}.
 */
public interface Validation {

    /**
     * Validate the field on the record.
     *
     * @param record   the record
     * @param property the property or field name to validate
     * @param value    the value of the field to validate
     * @throws ValidationException if this field is invalid
     */
    void validate(Record record, String property, Field value) throws ValidationException;
}
