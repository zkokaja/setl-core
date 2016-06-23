package com.kokaja.setl.tests.loaders;

import com.kokaja.setl.LoaderException;
import com.kokaja.setl.Record;
import com.kokaja.setl.csv.CSVConfig;
import com.kokaja.setl.load.CSVLoader;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCSVLoader {

    private static CSVLoader loader;
    private static StringBuilder sb;
    private static Record record;

    @BeforeClass
    public static void init() {
        sb = new StringBuilder();
        loader = new CSVLoader(sb);

        CSVConfig csvConfig = loader.getCsvConfig();
        csvConfig.setHeader("id", "first", "last");
        csvConfig.setHeaderFirstRow(true);
    }

    @Before
    public void createObject() {
        record = new Record();
        record.add("id", 1029382);
        record.add("first", "Jon");
        record.add("last", "Snow");
    }

    @Test
    public void testLoader() throws LoaderException {
        loader.init();
        loader.load(record);
        loader.close();

        String expected = "id,first,last\r\n" + "1029382,Jon,Snow\r\n";
        assertEquals(expected, sb.toString());
    }
}
