package com.kokaja.setl;

import java.io.Serializable;

/**
 * A Transformation's responsibility is to transform a particular {@link Field}
 * on a given {@link Record}.
 */
public interface Transformation extends Serializable {

    /**
     * Transform the given record, field, and value.
     *
     * @param Record   the record
     * @param property the property or field name being transformed
     * @param value    the value the value of the property on the record
     * @throws TransformationException if transformation fails
     */
    void transform(Record Record, String property, Field value) throws TransformationException;
}
