package com.kokaja.setl.tests.spring;

import com.kokaja.setl.Record;
import com.kokaja.setl.load.CSVLoader;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

public class TestSpringCSVLoader {

    private static ApplicationContext context;
    private static Record record;

    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext("loader_beans.xml");
    }

    @Before
    public void createObject() {
        record = new Record();
        record.add("id", 1029382);
        record.add("first", "Jon");
        record.add("last", "Snow");
    }

    @Test
    public void testLoader() throws Exception {

        CSVLoader loader = (CSVLoader) context.getBean("simpleLoader");

        loader.init();
        loader.load(record);
        loader.close();

        StringBuilder sb = (StringBuilder) loader.getOut();

        String expected = "1029382,Jon,Snow\r\n";
        assertEquals(expected, sb.toString());
    }

}
