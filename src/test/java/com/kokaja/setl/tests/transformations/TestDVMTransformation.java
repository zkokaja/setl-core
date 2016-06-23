package com.kokaja.setl.tests.transformations;

import static org.junit.Assert.assertEquals;

import com.kokaja.setl.TransformationException;
import com.kokaja.setl.PrimitiveField;
import com.kokaja.setl.Record;
import com.kokaja.setl.transform.DVMTransformation;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDVMTransformation {

    private static Record record;
    private static DVMTransformation transformation;

    @BeforeClass
    public static void init() {
        transformation = new DVMTransformation();
        transformation.addMapping("Cat", "Kitten");
        transformation.addMapping("Dog", "Puppy");
    }

    @Before
    public void setup() {
        record = new Record();
        record.add("Kingdom", "Mammal");
        record.add("Type", "Cat");
        record.add("Pet", true);
    }

    @Test
    public void testTransformation() throws TransformationException {
        transformation.transform(record, "Type", record.get("Type"));

        assertEquals("Kitten", record.getAsString("Type"));
        assertEquals("Mammal", record.getAsString("Kingdom"));
        assertEquals(true, record.getAsBoolean("Pet"));
    }

    @Test(expected = TransformationException.class)
    public void testTransformationError() throws TransformationException {
        transformation.transform(record, "Type", new PrimitiveField("Kitty"));
    }
}
