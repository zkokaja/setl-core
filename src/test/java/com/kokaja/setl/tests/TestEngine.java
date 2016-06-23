package com.kokaja.setl.tests;

import com.kokaja.setl.*;
import com.kokaja.setl.extract.CSVExtractor;
import com.kokaja.setl.load.CSVLoader;
import com.kokaja.setl.transform.ConcatTransformation;
import com.kokaja.setl.transform.DVMTransformation;
import com.kokaja.setl.transform.BasicTransformer;
import com.kokaja.setl.validate.BasicValidator;
import com.kokaja.setl.validate.RequiredValidation;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

public class TestEngine {

    @Test
    public void testEngine() throws IOException, ExtractorException, LoaderException {

        StringBuilder output = new StringBuilder();

        Extractor extractor = new CSVExtractor(getClass().getResource("/people.csv"));
        BasicTransformer transformer = new BasicTransformer();
        CSVLoader loader = new CSVLoader(output);
        loader.getCsvConfig().setHeader("id", "first", "status");

        DVMTransformation transformation = new DVMTransformation();
        transformation.addMapping("Dead", "D");
        transformation.addMapping("Alive", "A");

        ConcatTransformation concatTransformation = new ConcatTransformation("last");

        transformer.addTransformation("status", transformation);
        transformer.addTransformation("first", concatTransformation);

        Job job = new Job();
        job.setExtractor(extractor);
        job.addLoader(loader, transformer);

        Engine engine = new Engine(job);
        engine.start();

        String expected = "id,first,status\r\n" + "832,Jon Snow,A\r\n" + "149,Ned Stark,D\r\n";
        assertEquals(expected, output.toString());
    }

    @Test
    public void testValidationEngine() throws ExtractorException, LoaderException {

        String input = TestStringUtils.concat("id,name", ",Jon");
        StringBuilder output = new StringBuilder();

        Extractor extractor = new CSVExtractor(new StringReader(input));
        CSVLoader csvLoader = new CSVLoader(output);
        csvLoader.getCsvConfig().setHeader("id,name");

        BasicValidator validator = new BasicValidator();
        validator.addValidation("id", new RequiredValidation());

        CSVLoader errorLoader = new CSVLoader(System.err);
        errorLoader.getCsvConfig().setHeader("id", "name", "_error");

        Job job = new Job();
        job.setExtractor(extractor);
        job.setValidator(validator);
        job.setErrorHandler(new LoaderErrorHandler(errorLoader));
        job.addLoader(csvLoader, new BasicTransformer());

        Engine engine = new Engine(job);
        engine.start();

        // TODO: assert
    }
}
