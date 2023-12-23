package com.tree.gdhealth.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MissMatchedContentTypeException extends RuntimeException{

    public MissMatchedContentTypeException(String message) {
        super(message);
    }
}
