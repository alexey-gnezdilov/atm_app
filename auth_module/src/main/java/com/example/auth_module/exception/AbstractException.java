package com.example.auth_module.exception;

import lombok.Getter;

@Getter
public abstract class AbstractException extends RuntimeException{

    private final int code;

    public AbstractException(String message, int code) {
        super(message);
        this.code = code;
    }

}
