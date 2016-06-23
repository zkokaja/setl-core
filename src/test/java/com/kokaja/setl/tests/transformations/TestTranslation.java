package com.kokaja.setl.tests.transformations;

import com.kokaja.setl.Record;
import com.kokaja.setl.transform.Translation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestTranslation {

    private static Record record;

    @Before
    public void setup() {
        record = new Record();
        record.add("Kingdom", "Mammal");
        record.add("Type", "Cat");
        record.add("Pet", true);
    }

    @Test
    public void testTransformation() {
        Translation transformation = new Translation("isPet");
        transformation.transform(record, "Pet", record.get("Pet"));

        assertTrue(record.getAsPrimitive("isPet").getAsBoolean());
    }
}
