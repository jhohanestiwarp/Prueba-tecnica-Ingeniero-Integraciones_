package com.project.commons.properties;

public class Id {
    private static final String FIELD_NAME = "id";
    private final Long value;

    public Id(Long value) {
        if (value != null && value > 0) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("El campo " + FIELD_NAME + " no es válido");
        }
    }

    public Long getValue() {
        return value;
    }
}