package com.igl.gov.common.exception;

public class SerializeException extends  RuntimeException {

    public SerializeException(String message) {
        super(message);
    }

    public SerializeException(String message, Throwable e) {
        super(message, e);
    }
}
