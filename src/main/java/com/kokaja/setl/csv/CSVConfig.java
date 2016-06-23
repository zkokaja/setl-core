package com.kokaja.setl.csv;

import org.apache.commons.csv.CSVFormat;

/**
 * A wrapper for configuring an Apache Commons {@link CSVFormat} using
 * Java Bean getters and setters.
 */
public class CSVConfig {

    private String[] header;
    private String nullString;
    private String recordSeparator;
    private char delimiter;
    private char escape;
    private char quote;
    private boolean trim;
    private boolean headerFirstRow;
    private boolean ignoreEmptyLines;
    private boolean ignoreHeaderCase;
    private boolean ignoreSurroundingSpace;
    private CSVFormat csvFormat;

    // Constructors

    /**
     * Instantiates a new Csv config.
     */
    public CSVConfig() {
        this(CSVFormat.DEFAULT.withFirstRecordAsHeader().withNullString(""));
    }

    /**
     * Instantiates a new Csv config.
     *
     * @param csvFormat the csv format
     */
    public CSVConfig(CSVFormat csvFormat) {
        this.csvFormat = csvFormat;
    }


    // Getters and Setters

    /**
     * Get header string [ ].
     *
     * @return the string [ ]
     */
    public String[] getHeader() {
        return csvFormat.getHeader();
    }

    /**
     * Sets header.
     *
     * @param header the header
     */
    public void setHeader(String... header) {
        csvFormat = csvFormat.withHeader(header);
    }

    /**
     * Gets null string.
     *
     * @return the null string
     */
    public String getNullString() {
        return csvFormat.getNullString();
    }

    /**
     * Sets null string.
     *
     * @param nullString the null string
     */
    public void setNullString(String nullString) {
        csvFormat = csvFormat.withNullString(nullString);
    }

    /**
     * Gets delimiter.
     *
     * @return the delimiter
     */
    public char getDelimiter() {
        return csvFormat.getDelimiter();
    }

    /**
     * Sets delimiter.
     *
     * @param delimiter the delimiter
     */
    public void setDelimiter(char delimiter) {
        csvFormat = csvFormat.withDelimiter(delimiter);
    }

    /**
     * Gets escape.
     *
     * @return the escape
     */
    public char getEscape() {
        return csvFormat.getEscapeCharacter();
    }

    /**
     * Sets escape.
     *
     * @param escape the escape
     */
    public void setEscape(char escape) {
        csvFormat = csvFormat.withEscape(escape);
    }

    /**
     * Gets quote.
     *
     * @return the quote
     */
    public char getQuote() {
        return csvFormat.getQuoteCharacter();
    }

    /**
     * Sets quote.
     *
     * @param quote the quote
     */
    public void setQuote(char quote) {
        csvFormat = csvFormat.withQuote(quote);
    }

    /**
     * Gets record separator.
     *
     * @return the record separator
     */
    public String getRecordSeparator() {
        return csvFormat.getRecordSeparator();
    }

    /**
     * Sets record separator.
     *
     * @param recordSeparator the record separator
     */
    public void setRecordSeparator(String recordSeparator) {
        csvFormat = csvFormat.withRecordSeparator(recordSeparator);
    }

    /**
     * Is trim boolean.
     *
     * @return the boolean
     */
    public boolean isTrim() {
        return csvFormat.getTrim();
    }

    /**
     * Sets trim.
     *
     * @param trim the trim
     */
    public void setTrim(boolean trim) {
        csvFormat = csvFormat.withTrim(trim);
    }

    /**
     * Is header first row boolean.
     *
     * @return the boolean
     */
    public boolean isHeaderFirstRow() {
        return !csvFormat.getSkipHeaderRecord();
    }

    /**
     * Sets header first row.
     *
     * @param headerFirstRow the header first row
     */
    public void setHeaderFirstRow(boolean headerFirstRow) {
        csvFormat = csvFormat.withSkipHeaderRecord(!headerFirstRow);
    }

    /**
     * Is ignore empty lines boolean.
     *
     * @return the boolean
     */
    public boolean isIgnoreEmptyLines() {
        return csvFormat.getIgnoreEmptyLines();
    }

    /**
     * Sets ignore empty lines.
     *
     * @param ignoreEmptyLines the ignore empty lines
     */
    public void setIgnoreEmptyLines(boolean ignoreEmptyLines) {
        csvFormat = csvFormat.withIgnoreEmptyLines(ignoreEmptyLines);
    }

    /**
     * Is ignore header case boolean.
     *
     * @return the boolean
     */
    public boolean isIgnoreHeaderCase() {
        return csvFormat.getIgnoreHeaderCase();
    }

    /**
     * Sets ignore header case.
     *
     * @param ignoreHeaderCase the ignore header case
     */
    public void setIgnoreHeaderCase(boolean ignoreHeaderCase) {
        csvFormat = csvFormat.withIgnoreHeaderCase(ignoreHeaderCase);
    }

    /**
     * Is ignore surrounding space boolean.
     *
     * @return the boolean
     */
    public boolean isIgnoreSurroundingSpace() {
        return csvFormat.getIgnoreSurroundingSpaces();
    }

    /**
     * Sets ignore surrounding space.
     *
     * @param ignoreSurroundingSpace the ignore surrounding space
     */
    public void setIgnoreSurroundingSpace(boolean ignoreSurroundingSpace) {
        csvFormat = csvFormat.withIgnoreSurroundingSpaces(ignoreSurroundingSpace);
    }

    /**
     * Gets csv format.
     *
     * @return the csv format
     */
    public CSVFormat getCsvFormat() {
        return csvFormat;
    }

    /**
     * Sets csv format.
     *
     * @param csvFormat the csv format
     */
    public void setCsvFormat(CSVFormat csvFormat) {
        this.csvFormat = csvFormat;
    }
}
