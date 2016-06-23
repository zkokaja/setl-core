package com.kokaja.setl.tests.transformations;

import com.kokaja.setl.Record;
import com.kokaja.setl.TransformationException;
import com.kokaja.setl.transform.StringTransformation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStringTransformation {

    private static Record record;

    @Before
    public void setup() {
        record = new Record();
        record.add("Kingdom", "Mammal");
        record.add("Type", "Cat");
        record.add("Pet", true);
    }

    @Test
    public void testToUpperCase() throws NoSuchMethodException, TransformationException {
        StringTransformation transformation = new StringTransformation();
        transformation.setFunction("toUpperCase");

        transformation.transform(record, "Type", record.get("Type"));

        assertEquals("CAT", record.getAsString("Type"));
    }

    @Test
    public void testToLowerCase() throws TransformationException, NoSuchMethodException {
        StringTransformation transformation = new StringTransformation("toLowerCase");

        transformation.transform(record, "Type", record.get("Type"));

        assertEquals("cat", record.getAsString("Type"));
    }

    @Test(expected = NoSuchMethodException.class)
    public void testTransformationError() throws NoSuchMethodException {
        new StringTransformation("blah");
    }
}
