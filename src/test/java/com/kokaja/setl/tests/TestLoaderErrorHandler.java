package com.kokaja.setl.tests;

import com.kokaja.setl.*;
import com.kokaja.setl.load.CSVLoader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLoaderErrorHandler {

    private Record record;
    private ValidationException validationException;

    @Before
    public void init() {
        record = new Record();
        record.add("id", "");
        record.add("name", "Jon");

        validationException = new ValidationException("Field is required");
    }

    @Test
    public void testErrorHandler() throws LoaderException {

        StringBuilder sb = new StringBuilder();
        CSVLoader loader = new CSVLoader(sb);
        loader.getCsvConfig().setHeader("name", "_error");

        ErrorHandler handler = new LoaderErrorHandler(loader);

        handler.handleException(record, validationException);

        String expected = TestStringUtils.concat("name,_error", "Jon,Field is required");
        assertEquals(expected, sb.toString());
    }
}
