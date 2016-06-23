package com.kokaja.setl;

/**
 * A Field is an property value on a {@link Record}.
 *
 * This Field is an abstraction for different types of Fields. A Field may be
 * a String, integer, or other {@link PrimitiveField}. It also may be a
 * collection of values or a {@link ArrayField}. It's also possible that this
 * field is explicitly null, which may be represented as a {@link NullField}.
 * Finally, a field can be a {@link Record} which is a collection of Fields
 * mapped by String property names (like a map). This also implies that a
 * record can have other records as fields to accommodate complex types.
 */
public abstract class Field {

    /**
     * Is record boolean.
     *
     * @return the boolean
     */
    public boolean isRecord() {
        return this instanceof Record;
    }

    /**
     * Is primitive boolean.
     *
     * @return the boolean
     */
    public boolean isPrimitive() {
        return this instanceof PrimitiveField;
    }

    /**
     * Is array boolean.
     *
     * @return the boolean
     */
    public boolean isArray() {
        return this instanceof ArrayField;
    }

    /**
     * Is null boolean.
     *
     * @return the boolean
     */
    public boolean isNull() {
        return this instanceof NullField;
    }

    /**
     * Gets as record.
     *
     * @return the as record
     */
    public Record getAsRecord() {
        if (!isRecord()) {
            throw new IllegalStateException("This field is not a record.");
        }

        return (Record) this;
    }

    /**
     * Gets as array.
     *
     * @return the as array
     */
    public ArrayField getAsArray() {
        if (!isArray()) {
            throw new IllegalStateException("Field is not an array.");
        }

        return (ArrayField) this;
    }

    /**
     * Gets as primitive.
     *
     * @return the as primitive
     */
    public PrimitiveField getAsPrimitive() {
        if (!isPrimitive()) {
            throw new IllegalStateException("Field is not an array.");
        }

        return (PrimitiveField) this;
    }

    /**
     * Gets as string.
     *
     * @return the as string
     */
    public String getAsString() {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets as number.
     *
     * @return the as number
     */
    public Number getAsNumber() {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets as int.
     *
     * @return the as int
     */
    public int getAsInt() {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets as double.
     *
     * @return the as double
     */
    public double getAsDouble() {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets as boolean.
     *
     * @return the as boolean
     */
    public boolean getAsBoolean() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        if (isPrimitive()) return getAsPrimitive().toString();
        if (isArray()) return getAsArray().toString();
        if (isRecord()) return getAsRecord().toString();

        return "";
    }
}
