package com.kokaja.setl.transform;

import com.kokaja.setl.Field;
import com.kokaja.setl.Record;
import com.kokaja.setl.Transformation;
import com.kokaja.setl.TransformationException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The type Composite transformation.
 */
public class CompositeTransformation implements Transformation {

    private Collection<Transformation> transformations;

    // Constructors

    /**
     * Instantiates a new Composite transformation.
     */
    public CompositeTransformation() {
        transformations = new ArrayList<>();
    }

    // Transformation implementation

    @Override
    public void transform(Record record, String property, Field value) throws TransformationException {
       for (Transformation transformation : transformations) {
           Field newValue = record.get(property);
           transformation.transform(record, property, newValue);
       }
    }

    // Getters and setters

    /**
     * Add transformation.
     *
     * @param transformation the transformation
     */
    public void addTransformation(Transformation transformation) {
        transformations.add(transformation);
    }

    /**
     * Remove transformation boolean.
     *
     * @param transformation the transformation
     * @return the boolean
     */
    public boolean removeTransformation(Transformation transformation) {
        return transformations.remove(transformation);
    }

    /**
     * Gets transformations.
     *
     * @return the transformations
     */
    public Collection<Transformation> getTransformations() {
        return transformations;
    }

    /**
     * Sets transformations.
     *
     * @param transformations the transformations
     */
    public void setTransformations(Collection<Transformation> transformations) {
        this.transformations = transformations;
    }
}
