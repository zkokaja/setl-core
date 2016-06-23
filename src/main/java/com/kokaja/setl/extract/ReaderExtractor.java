package com.kokaja.setl.extract;

import com.kokaja.setl.Extractor;

import java.io.Reader;

/**
 * The type Reader extractor.
 */
public abstract class ReaderExtractor implements Extractor {

    /**
     * The Reader.
     */
    protected final Reader reader;

    /**
     * Instantiates a new Reader extractor.
     *
     * @param reader the reader
     */
    public ReaderExtractor(Reader reader) {
        this.reader = reader;
    }

}
