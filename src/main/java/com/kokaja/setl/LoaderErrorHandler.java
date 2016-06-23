package com.kokaja.setl;

import com.kokaja.setl.load.CSVLoader;

/**
 * The type Loader error handler.
 */
public class LoaderErrorHandler implements ErrorHandler {

    private final Loader loader;

    // Constructors

    /**
     * Instantiates a new Loader error handler.
     *
     * @throws LoaderException the loader exception
     */
    public LoaderErrorHandler() throws LoaderException {
        CSVLoader loader = new CSVLoader(System.err);
        loader.getCsvConfig().setHeader("_error");
        loader.init();

        this.loader = loader;
    }

    /**
     * Instantiates a new Loader error handler.
     *
     * @param loader the loader
     * @throws LoaderException the loader exception
     */
    public LoaderErrorHandler(Loader loader) throws LoaderException {
        this.loader = loader;
        this.loader.init();
    }

    // ErrorHandler implementation

    @Override
    public void handleException(Record object, LoaderException e) {
        object.add("_error", e.getMessage());
        try {
            loader.load(object);
        } catch (LoaderException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void handleException(Record object, TransformationException e) {
        object.add("_error", e.getMessage());
        try {
            loader.load(object);
        } catch (LoaderException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void handleException(Record object, ValidationException e) {
        object.add("_error", e.getMessage());
        try {
            loader.load(object);
        } catch (LoaderException ex) {
            throw new RuntimeException(ex);
        }
    }

}
