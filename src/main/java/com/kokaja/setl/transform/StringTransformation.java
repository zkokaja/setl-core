package com.kokaja.setl.transform;

import com.kokaja.setl.Field;
import com.kokaja.setl.Record;
import com.kokaja.setl.Transformation;
import com.kokaja.setl.TransformationException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * The type String transformation.
 */
public class StringTransformation implements Transformation {

    private String function;
    private Method method;

    // Constructors

    /**
     * Instantiates a new String transformation.
     */
    public StringTransformation() { }

    /**
     * Instantiates a new String transformation.
     *
     * @param function the function
     * @throws NoSuchMethodException the no such method exception
     */
    public StringTransformation(String function) throws NoSuchMethodException {
        setFunction(function);
    }

    // Transformation implementation

    @Override
    public void transform(Record record, String property, Field value) throws TransformationException {

        if (!value.isPrimitive()) throw new TransformationException("Value must be a string.");

        try {
            String result = (String) method.invoke(value.getAsString());
            record.add(property, result);
        } catch (IllegalAccessException e) {
            throw new TransformationException(e);
        } catch (InvocationTargetException e) {
            throw new TransformationException(e);
        }
    }

    // Getters and setters

    /**
     * Gets function.
     *
     * @return the function
     */
    public String getFunction() {
        return function;
    }

    /**
     * Sets function.
     *
     * @param function the function
     * @throws NoSuchMethodException the no such method exception
     */
    public void setFunction(String function) throws NoSuchMethodException {
        this.function = function;
        method = String.class.getMethod(function);
    }
}
