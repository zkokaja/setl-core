package com.kokaja.setl;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Schema.
 */
public class Schema {

    private Map<String, String> fieldNameMap;

    // Constructors

    /**
     * Instantiates a new Schema.
     */
    public Schema() {
        fieldNameMap = new HashMap<>();
    }

    /**
     * Instantiates a new Schema.
     *
     * @param fieldNames the field names
     */
    public Schema(String... fieldNames) {
        this();

        for (String fieldName : fieldNames) {
            addField(fieldName, null);
        }
    }

    // Convenience methods

    /**
     * Add field.
     *
     * @param fieldName the field name
     */
    public void addField(String fieldName) {
        addField(fieldName, null);
    }

    /**
     * Add field.
     *
     * @param fieldName        the field name
     * @param fieldDisplayName the field display name
     */
    public void addField(String fieldName, String fieldDisplayName) {
        fieldNameMap.put(fieldName, fieldDisplayName);
    }

    /**
     * Gets display name.
     *
     * @param fieldName the field name
     * @return the display name
     */
    public String getDisplayName(String fieldName) {
        String displayName = fieldNameMap.get(fieldName);
        return displayName != null ? displayName : fieldName;
    }

    // Getters and setters

    /**
     * Gets field name map.
     *
     * @return the field name map
     */
    public Map<String, String> getFieldNameMap() {
        return fieldNameMap;
    }

    /**
     * Sets field name map.
     *
     * @param fieldNameMap the field name map
     */
    public void setFieldNameMap(Map<String, String> fieldNameMap) {
        this.fieldNameMap = fieldNameMap;
    }
}
