package com.kokaja.setl.tests.spring;

import com.kokaja.setl.TransformationException;
import com.kokaja.setl.Record;
import com.kokaja.setl.Transformer;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class TestSpringTransformer {

    private static ApplicationContext context;
    private static Record record;

    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext("transformer_beans.xml");
        assertNotNull(context);
    }

    @Before
    public void createObject() {
        record = new Record();
        record.add("name", "tau");
        record.add("type", "symbol");
        record.add("value", "6.28");
        record.add("category", "math");
    }

    @Test
    public void testEmptyTransformer() throws TransformationException {
        Transformer transformer = (Transformer) context.getBean("emptyTransformer");

        Record copy = record; //(Record) record.clone(); TODO
        transformer.transform(copy);

        assertEquals(record, copy);
    }

    @Test
    public void testBasicTransformer() throws TransformationException {
        Transformer transformer = (Transformer) context.getBean("simpleTransformer");

        transformer.transform(record);

        assertEquals("M", record.getAsString("category"));
        assertEquals("symbol-tau", record.getAsString("type"));
    }

    @Test
    public void testCompositeTransformation() throws TransformationException {
        Transformer transformer = (Transformer) context.getBean("compositeTransformer");

        transformer.transform(record);

        assertEquals("symbol-tau-6.28", record.getAsString("type"));
    }
}

