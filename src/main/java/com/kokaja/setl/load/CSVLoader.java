package com.kokaja.setl.load;

import com.kokaja.setl.Field;
import com.kokaja.setl.LoaderException;
import com.kokaja.setl.Record;
import com.kokaja.setl.csv.CSVConfig;
import com.kokaja.setl.Loader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;

/**
 * A {@link Loader} that loads {@link Record}s formatted as CSV using the
 * Apache Commons CSV library.
 */
public class CSVLoader implements Loader {

    private Appendable out;
    private CSVConfig csvConfig;

    private CSVPrinter printer;
    private String[] header;

    // Constructors

    /**
     * Instantiates a new Csv loader.
     */
    public CSVLoader() {
        this(System.out);
    }

    /**
     * Instantiates a new Csv loader.
     *
     * @param out the out
     */
    public CSVLoader(Appendable out) {
        this.out = out;
        csvConfig = new CSVConfig(CSVFormat.DEFAULT);
    }

    // Loader implementation

    @Override
    public void init() throws LoaderException {
        try {
            printer = csvConfig.getCsvFormat().print(out);
            header = csvConfig.getHeader();

            if (header == null || header.length == 0) {
                throw new IllegalStateException("Header cannot be null or empty");
            }

        } catch (IOException e) {
            throw new LoaderException(e);
        }
    }

    @Override
    public void load(Record record) throws LoaderException {

        try {
            for (int i = 0; i < header.length; i++) {
                Field value = record.get(header[i]);
                printer.print(value);
            }

            printer.println();
        }
        catch (IOException e) {
            throw new LoaderException(e);
        }
    }

    @Override
    public void close() { }

    // Getters and setters

    /**
     * Gets out.
     *
     * @return the out
     */
    public Appendable getOut() {
        return out;
    }

    /**
     * Sets out.
     *
     * @param out the out
     */
    public void setOut(Appendable out) {
        this.out = out;
    }

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
