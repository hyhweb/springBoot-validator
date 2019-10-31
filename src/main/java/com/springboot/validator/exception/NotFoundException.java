package com.springboot.validator.exception;

public class NotFoundException extends Exception {

    private static final long serialVersionUID = -3337173015423201991L;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

}
