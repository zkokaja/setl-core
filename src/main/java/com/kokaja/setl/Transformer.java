package com.kokaja.setl;

import java.io.Serializable;

/**
 * A Transformer's responsibility is to transform a {@link Record}.
 */
public interface Transformer extends Serializable {

    /**
     * Transform the given record.
     *
     * @param record the record
     * @throws TransformationException if transformation fails
     */
    void transform(Record record) throws TransformationException;
}
