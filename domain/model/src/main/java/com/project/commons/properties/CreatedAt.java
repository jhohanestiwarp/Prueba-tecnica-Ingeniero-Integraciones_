package com.project.commons.properties;

import com.project.commons.ValidateData;

import java.time.LocalDateTime;

public class CreatedAt {
    private static String FIELD_NAME = "createdAt";
    private LocalDateTime value;

    public CreatedAt(LocalDateTime value) {
        if(ValidateData.date(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public LocalDateTime getValue(){ return value; }
}
