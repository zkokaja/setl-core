package com.kokaja.setl;

import java.io.Serializable;

/**
 * An Extractor's responsibility is to extract {@link Record}s from some source
 * and provide and iterator.
 */
public interface Extractor extends Iterable<Record>, Serializable {

    /**
     * Optionally initialize the extractor.
     *
     * For example, to establish a connection.
     *
     * @throws ExtractorException the extractor exception
     */
    void init() throws ExtractorException;

    /**
     * Optionally close the extractor.
     */
    void close();
}
