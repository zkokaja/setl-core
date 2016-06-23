package com.kokaja.setl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The type Array field.
 */
public class ArrayField extends Field implements Iterable<Field> {

    private final List<Field> elements;

    /**
     * Instantiates a new Array field.
     */
    public ArrayField() {
        elements = new ArrayList<>();
    }

    /**
     * Add.
     *
     * @param string the string
     */
    public void add(String string) {
        add(new PrimitiveField(string));
    }

    /**
     * Add.
     *
     * @param integer the integer
     */
    public void add(int integer) {
        add(new PrimitiveField(integer));
    }

    /**
     * Add.
     *
     * @param field the field
     */
    public void add(Field field) {
        elements.add(field);
    }

    @Override
    public Iterator<Field> iterator() {
        return elements.iterator();
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        return elements.size();
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * Remove boolean.
     *
     * @param field the field
     * @return the boolean
     */
    public boolean remove(Field field) {
        return elements.remove(field);
    }

    /**
     * Remove field.
     *
     * @param index the index
     * @return the field
     */
    public Field remove(int index) {
        return elements.remove(index);
    }

    /**
     * Sets field.
     *
     * @param index the index
     * @param field the field
     * @return the field
     */
    public Field setField(int index, Field field) {
        return elements.set(index, field);
    }

    @Override
    public int hashCode() {
        return elements.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ArrayField that = (ArrayField) obj;
        return elements.equals(that.elements);
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
