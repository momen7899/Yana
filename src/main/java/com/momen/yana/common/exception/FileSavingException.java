package com.momen.yana.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class FileSavingException extends RuntimeException {

    public FileSavingException(String message) {
        super(message);
    }

}
