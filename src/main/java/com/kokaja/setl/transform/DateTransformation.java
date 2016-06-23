package com.kokaja.setl.transform;

import com.kokaja.setl.Field;
import com.kokaja.setl.Record;
import com.kokaja.setl.Transformation;
import com.kokaja.setl.TransformationException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The type Date transformation.
 */
public class DateTransformation implements Transformation {

    private String existingFormat;
    private String desiredFormat;

    private SimpleDateFormat existingDateFormat;
    private SimpleDateFormat desiredDateFormat;

    // Constructors

    /**
     * Instantiates a new Date transformation.
     */
    public DateTransformation() { }

    /**
     * Instantiates a new Date transformation.
     *
     * @param existingFormat the existing format
     * @param desiredFormat  the desired format
     */
    public DateTransformation(String existingFormat, String desiredFormat) {
        setExistingFormat(existingFormat);
        setDesiredFormat(desiredFormat);
    }

    // Transformation implementation

    @Override
    public void transform(Record record, String property, Field value) throws TransformationException {

        if (!value.isPrimitive()) throw new TransformationException("Value must be a string");

        try {
            String dateValue = value.getAsString();

            Date date = existingDateFormat.parse(dateValue);
            String newDate = desiredDateFormat.format(date);

            record.add(property, newDate);
        } catch (ParseException e) {
            throw new TransformationException(e);
        }
    }

    // Getters and setters

    /**
     * Gets existing format.
     *
     * @return the existing format
     */
    public String getExistingFormat() {
        return existingFormat;
    }

    /**
     * Sets existing format.
     *
     * @param existingFormat the existing format
     */
    public void setExistingFormat(String existingFormat) {
        this.existingFormat = existingFormat;
        existingDateFormat  = new SimpleDateFormat(existingFormat);
    }

    /**
     * Gets desired format.
     *
     * @return the desired format
     */
    public String getDesiredFormat() {
        return desiredFormat;
    }

    /**
     * Sets desired format.
     *
     * @param desiredFormat the desired format
     */
    public void setDesiredFormat(String desiredFormat) {
        this.desiredFormat = desiredFormat;
        desiredDateFormat  = new SimpleDateFormat(desiredFormat);
    }
}
