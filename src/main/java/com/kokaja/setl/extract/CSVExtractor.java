package com.kokaja.setl.extract;

import com.kokaja.setl.csv.CSVConfig;
import com.kokaja.setl.ExtractorException;
import com.kokaja.setl.Record;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.net.URL;
import java.util.Iterator;

/**
 * An {@link com.kokaja.setl.Extractor} that reads {@link Record}s from
 * a CSV file using the Apache Commons CSV library.
 */
public class CSVExtractor extends ReaderExtractor {

    private CSVConfig csvConfig;
    private CSVParser csvParser;

    // Constructors

    /**
     * Instantiates a new Csv extractor.
     *
     * @param fileName the file name
     * @throws FileNotFoundException the file not found exception
     */
    public CSVExtractor(String fileName) throws FileNotFoundException {
        this(new File(fileName));
    }

    /**
     * Instantiates a new Csv extractor.
     *
     * @param file the file
     * @throws FileNotFoundException the file not found exception
     */
    public CSVExtractor(File file) throws FileNotFoundException {
        this(new FileReader(file));
    }

    /**
     * Instantiates a new Csv extractor.
     *
     * @param url the url
     * @throws IOException the io exception
     */
    public CSVExtractor(URL url) throws IOException {
        this(new InputStreamReader(url.openStream()));
    }

    /**
     * Instantiates a new Csv extractor.
     *
     * @param stream the stream
     */
    public CSVExtractor(InputStream stream) {
        this(new InputStreamReader(stream));
    }

    /**
     * Instantiates a new Csv extractor.
     *
     * @param reader the reader
     */
    public CSVExtractor(Reader reader) {
        super(reader);

        csvConfig = new CSVConfig();
    }

    // Extractor implementation

   @Override
   public void init() throws ExtractorException {
       try {
           csvParser = csvConfig.getCsvFormat().parse(reader);
       } catch (IOException e) {
           throw new ExtractorException(e);
       }
   }

    @Override
    public void close() {}

    // Iterator implementation

    @Override
    public Iterator<Record> iterator() {
        return new CSVIterator();
    }

    private class CSVIterator implements Iterator<Record> {

        private final Iterator<CSVRecord> iterator;
        private final String[] header;

        /**
         * Instantiates a new Csv iterator.
         */
        CSVIterator() {
            header = csvParser.getHeaderMap().keySet().toArray(new String[0]);
            if (header == null || header.length == 0) {
                throw new IllegalStateException("Header cannot be null or empty");
            }

            iterator = csvParser.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Record next() {
            CSVRecord record = iterator.next();
            Record object = new Record();

            for (String name : header) {
                object.add(name, record.get(name)); // Everything is a string
            }

            return object;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    // Getters and setters

    /**
     * Gets csv config.
     *
     * @return the csv config
     */
    public CSVConfig getCsvConfig() {
        return csvConfig;
    }

    /**
     * Sets csv config.
     *
     * @param csvConfig the csv config
     */
    public void setCsvConfig(CSVConfig csvConfig) {
        this.csvConfig = csvConfig;
    }
}
