package com.tree.gdhealth.utils.exception;

import lombok.NoArgsConstructor;

/**
 * @author 정인호
 * <p>필요한 것보다 많은 결과가 생성되었을 때 발생하는 예외</p>
 */
@NoArgsConstructor
public class TooManyResultsException extends RuntimeException{

    public TooManyResultsException(String message) {
        super(message);
    }
}
