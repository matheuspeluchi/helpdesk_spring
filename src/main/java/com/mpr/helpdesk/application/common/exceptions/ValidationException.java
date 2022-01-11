package com.mpr.helpdesk.application.common.exceptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ValidationException implements Serializable {

    private static final long serialVersionUID = 1273329434789112550L;

    private final List<Error> errors = new ArrayList<>();

    public ValidationException() {
        super();
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void addError(String detail, String source) {
        this.errors.add(new Error(source, detail));
    }
}
