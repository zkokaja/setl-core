package com.kokaja.setl;

import java.util.*;

/**
 * The Engine executes a {@link Job}.
 *
 * This default engine does so by extracting each {@link Record} one at a time,
 * validating each record with the job's {@link Validator}. If invalid, the
 * job's {@link ErrorHandler} handles the exception.
 *
 * Then the engine transforms the record any number of times per
 * {@link Transformer}, and for each transformer, loads the transformed record
 * into its mapped {@link Loader}s. If any transformation fails, the exception
 * is again sent to the {@link ErrorHandler}.
 *
 * The Engine itself throws an exception if the {@link Extractor} fails to
 * initialize, or a RuntimeException is thrown by it. It is also possible that
 * the {@link Loader} fails to initialize, in which case an error is thrown.
 */
public class Engine {

    private Job job;

    /**
     * Instantiates a new Engine.
     */
    public Engine() { }

    /**
     * Instantiates a new Engine.
     *
     * @param job the job
     */
    public Engine(Job job) {
        this.job = job;
    }

    /**
     * Start.
     *
     * @throws ExtractorException the extractor exception
     * @throws LoaderException    the loader exception
     */
    public void start() throws ExtractorException, LoaderException {

        Extractor extractor = job.getExtractor();
        Validator validator = job.getValidator();
        ErrorHandler errorHandler = job.getErrorHandler();
        Map<Transformer, List<Loader>> transformerMap = job.getTransformerMap();

        // Set up
        boolean oneTransformer = transformerMap.size() == 1;
        Collection<List<Loader>> loaderLists = transformerMap.values();
        Set<Loader> uniqueLoaders = new HashSet<>();

        for (List<Loader> loaderList : loaderLists) {
            uniqueLoaders.addAll(loaderList);
        }

        // Initialize the extractor and load
        extractor.init();
        for (Loader loader : uniqueLoaders) {
            loader.init();
        }

        // Extract one object at a time
        for (Record record : extractor) {

            // Validate the record
            if (validator != null) {
                try {
                    validator.validate(record);
                } catch (ValidationException e) {
                    errorHandler.handleException(record, e);
                    continue;
                }
            }

            // Pass the record to each transformer
            for (Map.Entry<Transformer, List<Loader>> entry : transformerMap.entrySet()) {

                //Field clone = (oneTransformer) ? record : (Field) record.clone();
                Record clone = (oneTransformer) ? record : null; // TODO

                // Transform record
                try {
                    Transformer transformer = entry.getKey();
                    transformer.transform(clone);
                }
                catch(TransformationException e) {
                    errorHandler.handleException(clone, e);
                    continue;
                }

                // Load record
                List<Loader> loaders = entry.getValue();
                for (Loader loader : loaders) {
                    try {
                        loader.load(clone);
                    }
                    catch (LoaderException e) {
                        errorHandler.handleException(clone, e);
                    }
                }
            }
        }

        // Close the extractor and load
        extractor.close();
        for (Loader loader : uniqueLoaders) {
            loader.close();
        }

    }

    // Getters and setters

    /**
     * Gets job.
     *
     * @return the job
     */
    public Job getJob() {
        return job;
    }

    /**
     * Sets job.
     *
     * @param job the job
     */
    public void setJob(Job job) {
        this.job = job;
    }
}
