package com.kokaja.setl.validate;

import com.kokaja.setl.ValidationException;
import com.kokaja.setl.Field;
import com.kokaja.setl.Record;
import com.kokaja.setl.Validation;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The type Composite validation.
 */
public class CompositeValidation implements Validation {

    private Collection<Validation> validations;

    // Constructors

    /**
     * Instantiates a new Composite validation.
     */
    public CompositeValidation() {
        validations = new ArrayList<>();
    }

    // Validation implementation

    @Override
    public void validate(Record record, String property, Field value) throws ValidationException {
       for (Validation transformation : validations) {
           transformation.validate(record, property, value);
       }
    }

    // Getters and setters

    /**
     * Add validation.
     *
     * @param transformation the transformation
     */
    public void addValidation(Validation transformation) {
        validations.add(transformation);
    }

    /**
     * Remove validation boolean.
     *
     * @param transformation the transformation
     * @return the boolean
     */
    public boolean removeValidation(Validation transformation) {
        return validations.remove(transformation);
    }

    /**
     * Gets validations.
     *
     * @return the validations
     */
    public Collection<Validation> getValidations() {
        return validations;
    }

    /**
     * Sets validations.
     *
     * @param transformations the transformations
     */
    public void setValidations(Collection<Validation> transformations) {
        this.validations = transformations;
    }
}
