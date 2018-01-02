/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.validation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pavikumbhar
 */
public class ValidationError {
    private List<FieldError> fieldErrors = new ArrayList<>();

    public ValidationError() {

    }

    public void addFieldError(String path, String message) {
        FieldError error = new FieldError(path, message);
        fieldErrors.add(error);
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
}
    
}
