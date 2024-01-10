package com.tree.gdhealth.utils;

import com.tree.gdhealth.utils.exception.TooManyResultsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 응답엔티티를 생성하는 컴포넌트 클래스
 */
@Component
public class ResponseEntityGenerator {

    /**<p>GET요청 응답엔티티를 생성하는 메서드</p>
     * @param responseObject object
     * @return responseObject 가 널? 404 notFound : 200 ok
     */
    public ResponseEntity<Object> respGET(Object responseObject){
        if(responseObject == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("serverMessage","조회결과가 없습니다."));
        }
        return  ResponseEntity.ok(responseObject);
    }

    /**
     * <p> 500 내부서버 에러 응답을 생성하는 메서드</p>
     * @param exception {@link TooManyResultsException}
     * @return 500 with serverMessage
     */
    public ResponseEntity<Object> respInternalServerError(TooManyResultsException exception){
        return ResponseEntity.internalServerError().body(Map.of("serverMessage","2개 이상 조회되었습니다."));
    }
}
