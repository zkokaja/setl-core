package com.kokaja.setl.validate;

import com.kokaja.setl.Field;
import com.kokaja.setl.Record;
import com.kokaja.setl.ValidationException;
import com.kokaja.setl.Validation;

/**
 * The type Required validation.
 */
public class RequiredValidation implements Validation {

    @Override
    public void validate(Record record, String property, Field value) throws ValidationException {
        if (value == null || value.isNull()) throw new ValidationException(property + " is a required field.");
    }
}
