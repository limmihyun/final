package com.tree.gdhealth.utils.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TooManyResultsException extends RuntimeException{

    public TooManyResultsException(String message) {
        super(message);
    }
}
