package com.kokaja.setl.transform;

import com.kokaja.setl.Field;
import com.kokaja.setl.PrimitiveField;
import com.kokaja.setl.TransformationException;
import com.kokaja.setl.Record;
import com.kokaja.setl.Transformation;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Dvm transformation.
 */
public class DVMTransformation implements Transformation {

    private Map<Field,Field> domainValueMap;
    private boolean errorOnNoMapping;

    // Constructors

    /**
     * Instantiates a new Dvm transformation.
     */
    public DVMTransformation() {
        domainValueMap = new HashMap<>();
        errorOnNoMapping = true;
    }

    // Transformation implementation

    @Override
    public void transform(Record record, String property, Field value) throws TransformationException {
        Field newValue = domainValueMap.get(value);
        if (newValue == null && errorOnNoMapping) {
            throw new TransformationException("No mapping found for value: " + value);
        }

        record.add(property, newValue);
    }

    // Getters and setters

    /**
     * Add mapping.
     *
     * @param from the from
     * @param to   the to
     */
    public void addMapping(Field from, Field to) {
        domainValueMap.put(from, to);
    }

    /**
     * Add mapping.
     *
     * @param from the from
     * @param to   the to
     */
    public void addMapping(String from, String to) {
        addMapping(new PrimitiveField(from), new PrimitiveField(to));
    }

    /**
     * Gets domain value map.
     *
     * @return the domain value map
     */
    public Map getDomainValueMap() {
        return domainValueMap;
    }

    /**
     * Sets domain value map.
     *
     * @param domainValueMap the domain value map
     */
    public void setDomainValueMap(Map<Field,Field> domainValueMap) {
        this.domainValueMap = domainValueMap;
    }

    /**
     * Is error on no mapping boolean.
     *
     * @return the boolean
     */
    public boolean isErrorOnNoMapping() {
        return errorOnNoMapping;
    }

    /**
     * Sets error on no mapping.
     *
     * @param errorOnNoMapping the error on no mapping
     */
    public void setErrorOnNoMapping(boolean errorOnNoMapping) {
        this.errorOnNoMapping = errorOnNoMapping;
    }
}
