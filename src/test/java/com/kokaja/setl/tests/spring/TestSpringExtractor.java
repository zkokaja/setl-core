package com.kokaja.setl.tests.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.kokaja.setl.Extractor;
import com.kokaja.setl.Record;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;

public class TestSpringExtractor {

    private static ApplicationContext context;

    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext("extractor_beans.xml");
        assertNotNull(context);
    }

    @Test
    public void testExtractor() throws Exception {

        Extractor extractor = (Extractor) context.getBean("simpleExtractor");
        assertNotNull(extractor);

        extractor.init();

        Iterator<Record> iterator = extractor.iterator();
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());

        Record object = iterator.next();
        assertEquals("832", object.getAsString("id"));
        assertTrue(iterator.hasNext());

        object = iterator.next();
        assertEquals("149", object.getAsString("id"));

        extractor.close();
    }
}
