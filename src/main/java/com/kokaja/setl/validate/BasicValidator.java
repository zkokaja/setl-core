package com.kokaja.setl.validate;

import com.kokaja.setl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * A BasicValidator is a type of {@link Validator} that uses
 * {@link Validation}s mapped to record properties to validate the {@link Record}.
 */
public class BasicValidator implements Validator {

    private Map<String, Validation> validations;

    // Constructors

    /**
     * Instantiates a new Basic validator.
     */
    public BasicValidator() {
        validations = new HashMap<>();
    }

    /**
     * Add validation.
     *
     * @param field      the field
     * @param validation the validation
     */
    public void addValidation(String field, Validation validation) {
        validations.put(field, validation);
    }

    // Transformer implementation

    @Override
    public void validate(Record record) throws ValidationException {

        for (Map.Entry<String, Validation> entry : validations.entrySet()) {
            String field = entry.getKey();
            Validation validation = entry.getValue();

            Field value = record.get(field);
            validation.validate(record, field, value);
        }
    }

    // Getters and setters

    /**
     * Gets validations.
     *
     * @return the validations
     */
    public Map<String, Validation> getValidations() {
        return validations;
    }

    /**
     * Sets validations.
     *
     * @param validations the validations
     */
    public void setValidations(Map<String, Validation> validations) {
        this.validations = validations;
    }
}
