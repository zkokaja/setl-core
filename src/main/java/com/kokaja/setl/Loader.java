package com.kokaja.setl;

import java.io.Serializable;

/**
 * A Loader's responsibility is to load a {@link Record} into some destination.
 */
public interface Loader extends Serializable {

    /**
     * Optionally initialize the loader.
     *
     * @throws LoaderException the loader exception
     */
    void init() throws LoaderException;

    /**
     * Load the given record.
     *
     * @param record the record
     * @throws LoaderException the loader exception
     */
    void load(Record record) throws LoaderException;

    /**
     * Optionally close the loader.
     */
    void close();
}
