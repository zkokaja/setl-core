package com.kokaja.setl.tests.spring;

import com.kokaja.setl.Engine;
import com.kokaja.setl.load.CSVLoader;
import com.kokaja.setl.Job;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

public class TestSpringEngine {

    private static ApplicationContext context;
    private static Job job;

    @BeforeClass
    public static void init() {

        context = new ClassPathXmlApplicationContext("basic_engine.xml");
        job = (Job) context.getBean("job");
    }

    @Test
    public void testEngine() throws Exception {
        Engine engine = new Engine(job);
        engine.start();

        CSVLoader csvLoader = (CSVLoader) context.getBean("csvLoader");
        StringBuilder sb = (StringBuilder) csvLoader.getOut();

        String expected = "832,Jon Snow,A\r\n" + "149,Ned Stark,D\r\n";
        assertEquals(expected, sb.toString());
    }
}
