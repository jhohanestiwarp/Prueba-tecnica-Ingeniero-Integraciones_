package com.project.commons.properties;

import com.project.commons.ValidateData;

public class State {
    private static String FIELD_NAME = "state";
    private String value;

    public State(String value) {
        if(ValidateData.string(value, FIELD_NAME)){
            this.value = value;
        }
    }

    public String getValue(){ return value; }
}
