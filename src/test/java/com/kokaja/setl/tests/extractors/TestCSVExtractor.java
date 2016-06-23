package com.kokaja.setl.tests.extractors;

import com.kokaja.setl.extract.CSVExtractor;
import com.kokaja.setl.csv.CSVConfig;
import com.kokaja.setl.Record;
import com.kokaja.setl.tests.TestStringUtils;
import org.junit.Test;

import java.io.StringReader;
import java.util.Iterator;

import static org.junit.Assert.*;

public class TestCSVExtractor {

    @Test
    public void testDefaultExtractor() throws Exception {

        final String csv = TestStringUtils.concat("id,first,last", "832,Jon,Snow", "149,Ned,Stark");

        CSVExtractor extractor = new CSVExtractor(new StringReader(csv));

        extractor.init();
        assertExtractedObjects(extractor.iterator());
        extractor.close();
    }

    @Test
    public void testDelimiter() throws Exception {

        final String csv = TestStringUtils.concat("id|first|last", "832|Jon|Snow", "149|Ned|Stark");

        CSVExtractor extractor = new CSVExtractor(new StringReader(csv));

        CSVConfig csvConfig = extractor.getCsvConfig();
        csvConfig.setDelimiter('|');

        extractor.init();
        assertExtractedObjects(extractor.iterator());
        extractor.close();
    }

    @Test
    public void testWithHeader() throws Exception {

        final String csv = TestStringUtils.concat("id,first,last", "832,Jon,Snow", "149,Ned,Stark");

        CSVExtractor extractor = new CSVExtractor(new StringReader(csv));

        CSVConfig csvConfig = extractor.getCsvConfig();
        csvConfig.setHeader("id", "first", "last");

        extractor.init();
        assertExtractedObjects(extractor.iterator());
        extractor.close();
    }

    @Test
    public void testIgnoreEmptyLines() throws Exception {

        final String csv = TestStringUtils.concat("id,first,last", "", "832,Jon,Snow", "149,Ned,Stark");

        CSVExtractor extractor = new CSVExtractor(new StringReader(csv));

        CSVConfig csvConfig = extractor.getCsvConfig();
        csvConfig.setIgnoreEmptyLines(true);

        extractor.init();
        assertExtractedObjects(extractor.iterator());
        extractor.close();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIgnoreEmptyLinesException() throws Exception {

        final String csv = TestStringUtils.concat("id,first,last", "", "832,Jon,Snow", "149,Ned,Stark");

        CSVExtractor extractor = new CSVExtractor(new StringReader(csv));

        CSVConfig csvConfig = extractor.getCsvConfig();
        csvConfig.setIgnoreEmptyLines(false);

        extractor.init();
        assertExtractedObjects(extractor.iterator());
        extractor.close();
    }

    private void assertExtractedObjects(Iterator<Record> iterator) {
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());

        Record object = iterator.next();
        assertEquals("832", object.getAsString("id"));
        assertEquals("Jon", object.getAsString("first"));
        assertEquals("Snow", object.getAsString("last"));

        assertTrue(iterator.hasNext());
        object = iterator.next();

        assertEquals("149", object.getAsString("id"));
        assertEquals("Ned", object.getAsString("first"));
        assertEquals("Stark", object.getAsString("last"));
    }

}
