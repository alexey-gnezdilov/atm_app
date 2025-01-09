package com.example.auth_module.exception;

import lombok.Getter;

@Getter
public class UserExistsException extends AbstractException{

    public UserExistsException(String message, int code) {
        super(message, code);
    }

}
