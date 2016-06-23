package com.kokaja.setl.validate;

import com.kokaja.setl.Field;
import com.kokaja.setl.Record;
import com.kokaja.setl.ValidationException;
import com.kokaja.setl.Validation;

/**
 * The type Type validation.
 */
public class TypeValidation implements Validation {

    private String type;
    private Class typeClass;

    // Constructors

    /**
     * Instantiates a new Type validation.
     */
    public TypeValidation() { }

    /**
     * Instantiates a new Type validation.
     *
     * @param type the type
     * @throws ClassNotFoundException the class not found exception
     */
    public TypeValidation(String type) throws ClassNotFoundException {
        setType(type);
    }

    // Validation implementation

    @Override
    public void validate(Record record, String property, Field value) throws ValidationException {
        if (!typeClass.isAssignableFrom(value.getAsPrimitive().getPrimitiveClass())) {
            throw new ValidationException("Field [" + property + "] requires type: " + type);
        }
    }

    // Getters and setters

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     * @throws ClassNotFoundException the class not found exception
     */
    public void setType(String type) throws ClassNotFoundException {
        this.type = type;
        typeClass = Class.forName(type);
    }
}
