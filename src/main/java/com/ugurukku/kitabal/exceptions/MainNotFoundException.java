package com.ugurukku.kitabal.exceptions;

public class MainNotFoundException extends RuntimeException {
    public MainNotFoundException(String className,Long id) {
        super(className + " not found for id : " + id);
    }
}
