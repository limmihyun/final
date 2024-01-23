package com.tree.gdhealth.utils.exception;

import lombok.NoArgsConstructor;

/**
 * @author 파일의 컨텐츠타입이 일치하지 않는 경우 예외 (요구하는 타입이 아닌경우)
 */
@NoArgsConstructor
public class MisMatchedContentTypeException extends RuntimeException{

    public MisMatchedContentTypeException(String message) {
        super(message);
    }
}
