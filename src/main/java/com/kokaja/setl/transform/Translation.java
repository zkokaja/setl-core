package com.kokaja.setl.transform;

import com.kokaja.setl.Field;
import com.kokaja.setl.Record;
import com.kokaja.setl.Transformation;

/**
 * The type Translation.
 */
public class Translation implements Transformation {

    private String newProperty;

    // Constructors

    /**
     * Instantiates a new Translation.
     */
    public Translation() { }

    /**
     * Instantiates a new Translation.
     *
     * @param newProperty the new property
     */
    public Translation(String newProperty) {
        this.newProperty = newProperty;
    }

    // Transformation implementation

    @Override
    public void transform(Record record, String property, Field value) {
        record.add(newProperty, value);
    }

    // Getters and setters

    /**
     * Gets new property.
     *
     * @return the new property
     */
    public String getNewProperty() {
        return newProperty;
    }

    /**
     * Sets new property.
     *
     * @param newProperty the new property
     */
    public void setNewProperty(String newProperty) {
        this.newProperty = newProperty;
    }
}
