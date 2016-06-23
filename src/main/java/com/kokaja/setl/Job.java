package com.kokaja.setl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A Job describes the relationships between various extractors, validators,
 * transformers, and loaders.
 */
public class Job implements Serializable {

    private Extractor extractor;
    private Validator validator;
    private ErrorHandler errorHandler;
    private Map<Transformer, List<Loader>> transformerMap;

    // Constructors

    /**
     * Instantiates a new Job.
     */
    public Job() {
        transformerMap = new HashMap<>();

        try {
            errorHandler = new LoaderErrorHandler();
        } catch (LoaderException e) {
            throw new RuntimeException(e);
        }
    }

    // Getters and Setters

    /**
     * Add loader.
     *
     * @param loader      the loader
     * @param transformer the transformer
     */
    public void addLoader(Loader loader, Transformer transformer) {
        List<Loader> loaders = transformerMap.get(transformer);

        if (loaders == null) {
            loaders = new ArrayList<>();
            transformerMap.put(transformer, loaders);
        }

        loaders.add(loader);
    }

    /**
     * Gets extractor.
     *
     * @return the extractor
     */
    public Extractor getExtractor() {
        return extractor;
    }

    /**
     * Sets extractor.
     *
     * @param extractor the extractor
     */
    public void setExtractor(Extractor extractor) {
        this.extractor = extractor;
    }

    /**
     * Gets transformer map.
     *
     * @return the transformer map
     */
    public Map<Transformer, List<Loader>> getTransformerMap() {
        return transformerMap;
    }

    /**
     * Sets transformer map.
     *
     * @param transformerMap the transformer map
     */
    public void setTransformerMap(Map<Transformer, List<Loader>> transformerMap) {
        this.transformerMap = transformerMap;
    }

    /**
     * Gets error handler.
     *
     * @return the error handler
     */
    public ErrorHandler getErrorHandler() {
        return errorHandler;
    }

    /**
     * Sets error handler.
     *
     * @param errorHandler the error handler
     */
    public void setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    /**
     * Gets validator.
     *
     * @return the validator
     */
    public Validator getValidator() {
        return validator;
    }

    /**
     * Sets validator.
     *
     * @param validator the validator
     */
    public void setValidator(Validator validator) {
        this.validator = validator;
    }
}
