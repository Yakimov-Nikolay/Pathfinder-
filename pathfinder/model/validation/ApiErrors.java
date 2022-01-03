package com.example.pathfinder.model.validation;

import org.springframework.http.HttpStatus;
import java.util.*;

public class ApiErrors {

    private final HttpStatus status;
    private List<String> fieldWhitErrors = new ArrayList<>();

    public ApiErrors(HttpStatus status) {
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
    public void addFieldWhitError(String error){

    }


    public List<String> getFieldWhitErrors() {
        return fieldWhitErrors;
    }

    public ApiErrors setFieldWhitErrors(List<String> fieldWhitErrors) {
        this.fieldWhitErrors = fieldWhitErrors;
        return this;
    }
}
