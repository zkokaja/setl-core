package com.kokaja.setl;

import java.util.HashMap;
import java.util.Map;

/**
 * A Record is a type of {@link Field} that maps properties to Field values.
 */
public class Record extends Field {

    private final Map<String,Field> properties;

    /**
     * Instantiates a new Record.
     */
    public Record() {
        properties = new HashMap<>();
    }

    // Add convenience methods

    /**
     * Add.
     *
     * @param property the property
     * @param string   the string
     */
    public void add(String property, String string) {
        add(property, getFieldForObject(string));
    }

    /**
     * Add.
     *
     * @param property the property
     * @param number   the number
     */
    public void add(String property, Number number) {
        add(property, getFieldForObject(number));
    }

    /**
     * Add.
     *
     * @param property the property
     * @param bool     the bool
     */
    public void add(String property, boolean bool) {
        add(property, getFieldForObject(bool));
    }

    /**
     * Add.
     *
     * @param property the property
     * @param field    the field
     */
    public void add(String property, Field field) {
        properties.put(property, field);
    }

    /**
     * Add.
     *
     * @param property the property
     * @param object   the object
     */
    public void add(String property, Object object) {
        add(property, getFieldForObject(object));
    }

    private Field getFieldForObject(Object value) {
        return value == null ? NullField.INSTANCE : new PrimitiveField(value);
    }

    // Get convenience methods

    /**
     * Get field.
     *
     * @param property the property
     * @return the field
     */
    public Field get(String property) {
        return properties.get(property);
    }

    /**
     * Gets as array.
     *
     * @param property the property
     * @return the as array
     */
    public ArrayField getAsArray(String property) {
        return (ArrayField) properties.get(property);
    }

    /**
     * Gets as primitive.
     *
     * @param property the property
     * @return the as primitive
     */
    public PrimitiveField getAsPrimitive(String property) {
        return (PrimitiveField) properties.get(property);
    }

    /**
     * Gets as record.
     *
     * @param property the property
     * @return the as record
     */
    public Record getAsRecord(String property) {
        return (Record) properties.get(property);
    }

    /**
     * Gets as int.
     *
     * @param property the property
     * @return the as int
     */
    public int getAsInt(String property) {
        return getAsPrimitive(property).getAsInt();
    }

    /**
     * Gets as double.
     *
     * @param property the property
     * @return the as double
     */
    public double getAsDouble(String property) {
        return getAsPrimitive(property).getAsDouble();
    }

    /**
     * Gets as string.
     *
     * @param property the property
     * @return the as string
     */
    public String getAsString(String property) {
        return getAsPrimitive(property).getAsString();
    }

    /**
     * Gets as boolean.
     *
     * @param property the property
     * @return the as boolean
     */
    public boolean getAsBoolean(String property) {
        return getAsPrimitive(property).getAsBoolean();
    }

    // Object methods

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Record that = (Record) obj;
        return properties.equals(that.properties);
    }

    @Override
    public int hashCode() {
        return properties.hashCode();
    }

    @Override
    public String toString() {
        return properties.toString();
    }
}
