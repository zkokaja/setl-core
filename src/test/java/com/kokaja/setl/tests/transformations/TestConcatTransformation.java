package com.kokaja.setl.tests.transformations;

import com.kokaja.setl.TransformationException;
import com.kokaja.setl.Record;
import com.kokaja.setl.transform.ConcatTransformation;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestConcatTransformation {

    private static ConcatTransformation transformation;

    @BeforeClass
    public static void init() {
        transformation = new ConcatTransformation("Type");
    }

    @Test
    public void testTransformation() throws TransformationException {
        Record record = new Record();
        record.add("Kingdom", "Mammal");
        record.add("Type", "Cat");
        record.add("Pet", true);

        transformation.transform(record, "Kingdom", record.get("Kingdom"));

        assertEquals("Mammal Cat", record.getAsString("Kingdom"));
        assertEquals("Cat", record.getAsString("Type"));
        assertEquals(true, record.getAsBoolean("Pet"));
    }
}
