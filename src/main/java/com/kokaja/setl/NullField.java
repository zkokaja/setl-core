package com.kokaja.setl;

/**
 * The type Null field.
 */
public class NullField extends Field {

    /**
     * The constant INSTANCE.
     */
    public static final NullField INSTANCE = new NullField();

    /**
     * Instantiates a new Null field.
     */
    public NullField() {

    }

    // Object methods

    @Override
    public int hashCode() {
        return NullField.class.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj instanceof NullField;
    }
}
