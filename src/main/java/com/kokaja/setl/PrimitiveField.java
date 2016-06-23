package com.kokaja.setl;

/**
 * The type Primitive field.
 */
public class PrimitiveField extends Field {

    private static final Class<?>[] ALLOWED_TYPES = {int.class, long.class, short.class,
            float.class, double.class, byte.class, boolean.class, Integer.class, Long.class,
            Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    private Object value;

    // Constructors

    /**
     * Instantiates a new Primitive field.
     *
     * @param string the string
     */
    public PrimitiveField(String string) {
        setValue(string);
    }

    /**
     * Instantiates a new Primitive field.
     *
     * @param number the number
     */
    public PrimitiveField(Number number) {
        setValue(number);
    }

    /**
     * Instantiates a new Primitive field.
     *
     * @param bool the bool
     */
    public PrimitiveField(Boolean bool) {
        setValue(bool);
    }

    /**
     * Instantiates a new Primitive field.
     *
     * @param object the object
     */
    PrimitiveField(Object object) {
        setValue(object);
    }

    private void setValue(Object value) {

        if (value instanceof String) {
            this.value = value;
        }
        else {
            Class<?> objectType = value.getClass();
            for (Class<?> allowedType : ALLOWED_TYPES) {
                if (allowedType.isAssignableFrom(objectType)) {
                    this.value = value;
                    break;
                }
            }
        }
    }

    // Is-type methods

    /**
     * Is string boolean.
     *
     * @return the boolean
     */
    public boolean isString() {
        return value instanceof String;
    }

    /**
     * Is number boolean.
     *
     * @return the boolean
     */
    public boolean isNumber() {
        return value instanceof Number;
    }

    /**
     * Is boolean boolean.
     *
     * @return the boolean
     */
    public boolean isBoolean() {
        return value instanceof Boolean;
    }

    // Get methods

    @Override
    public String getAsString() {
        return (String) value;
    }

    @Override
    public Number getAsNumber() {
        return (Number) value;
    }

    @Override
    public int getAsInt() {
        return isNumber() ? getAsNumber().intValue() : Integer.parseInt(getAsString());
    }

    @Override
    public double getAsDouble() {
        return isNumber() ? getAsNumber().doubleValue() : Double.parseDouble(getAsString());
    }

    @Override
    public boolean getAsBoolean() {
        return isBoolean() ? (Boolean) value : Boolean.parseBoolean(getAsString());
    }

    /**
     * Gets primitive class.
     *
     * @return the primitive class
     */
    public Class<?> getPrimitiveClass() {
        return value.getClass();
    }

    // Object methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrimitiveField that = (PrimitiveField) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        if (isString()) return getAsString();
        if (isNumber()) return getAsNumber().toString();

        return value.toString();
    }
}
