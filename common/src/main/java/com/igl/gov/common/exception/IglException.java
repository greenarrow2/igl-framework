package com.igl.gov.common.exception;

public class IglException extends RuntimeException {

    public IglException(String message) {
        super(message);
    }

    public IglException(String message, Throwable e) {
        super(message, e);
    }
}
