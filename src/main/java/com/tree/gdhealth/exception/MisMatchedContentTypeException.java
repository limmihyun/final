package com.tree.gdhealth.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MisMatchedContentTypeException extends RuntimeException{

    public MisMatchedContentTypeException(String message) {
        super(message);
    }
}
