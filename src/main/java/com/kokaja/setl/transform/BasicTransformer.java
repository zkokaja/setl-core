package com.kokaja.setl.transform;

import com.kokaja.setl.Field;
import com.kokaja.setl.TransformationException;
import com.kokaja.setl.Record;
import com.kokaja.setl.Transformation;
import com.kokaja.setl.Transformer;

import java.util.HashMap;
import java.util.Map;

/**
 * A BasicTransformer is a type of {@link Transformer} that uses
 * {@link Transformation}s mapped to record properties to transform the
 * {@link Record}.
 */
public class BasicTransformer implements Transformer {

    private Map<String, Transformation> transformations;

    // Constructors

    /**
     * Instantiates a new Basic transformer.
     */
    public BasicTransformer() {
        transformations = new HashMap<>();
    }

    /**
     * Add transformation.
     *
     * @param field          the field
     * @param transformation the transformation
     */
    public void addTransformation(String field, Transformation transformation) {
        transformations.put(field, transformation);
    }

    // Transformer implementation

    @Override
    public void transform(Record record) throws TransformationException {

        for (Map.Entry<String, Transformation> entry : transformations.entrySet()) {
            String field = entry.getKey();
            Transformation transformation = entry.getValue();

            Field value = record.get(field);
            transformation.transform(record, field, value);
        }
    }

    // Getters and setters

    /**
     * Gets transformations.
     *
     * @return the transformations
     */
    public Map<String, Transformation> getTransformations() {
        return transformations;
    }

    /**
     * Sets transformations.
     *
     * @param transformations the transformations
     */
    public void setTransformations(Map<String, Transformation> transformations) {
        this.transformations = transformations;
    }
}
