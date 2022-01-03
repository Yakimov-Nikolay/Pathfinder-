package com.example.pathfinder.model.binding;

import org.apache.coyote.http11.filters.SavedRequestInputFilter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewCommentBindingModel {

    private String message;

    public NewCommentBindingModel() {
    }

    @NotBlank
    @Size(min = 10)
    public String getMessage() {
        return message;
    }

    public NewCommentBindingModel setMessage(String message) {
        this.message = message;
        return this;
    }
}
