package com.kokaja.setl.transform;

import com.kokaja.setl.Field;
import com.kokaja.setl.Record;
import com.kokaja.setl.Transformation;

/**
 * The type Concat transformation.
 */
public class ConcatTransformation implements Transformation {

    private String concatProperty;
    private String delimiter;

    /**
     * Instantiates a new Concat transformation.
     */
    public ConcatTransformation() {
       this(null);
    }

    /**
     * Instantiates a new Concat transformation.
     *
     * @param concatProperty the concat property
     */
    public ConcatTransformation(String concatProperty) {
        this.concatProperty = concatProperty;
        this.delimiter = " ";
    }

    @Override
    public void transform(Record record, String property, Field value) {
        Field concatValue = record.get(concatProperty);

        if (concatValue != null) {
            record.add(property, value + delimiter + concatValue); // TODO: how to concat?
        }
    }

    /**
     * Gets concat property.
     *
     * @return the concat property
     */
    public String getConcatProperty() {
        return concatProperty;
    }

    /**
     * Sets concat property.
     *
     * @param concatProperty the concat property
     */
    public void setConcatProperty(String concatProperty) {
        this.concatProperty = concatProperty;
    }

    /**
     * Gets delimiter.
     *
     * @return the delimiter
     */
    public String getDelimiter() {
        return delimiter;
    }

    /**
     * Sets delimiter.
     *
     * @param delimiter the delimiter
     */
    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }
}
