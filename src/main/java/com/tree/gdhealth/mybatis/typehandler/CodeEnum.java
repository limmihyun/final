package com.tree.gdhealth.mybatis.typehandler;

/**
 * <p>마이바티스의 타입핸들러에 제네릭타입을 사용하기 위한 커스텀 자바이넘의 구현대상인터페이스</p>
 * @apiNote String code는 Enum 상수에 대응되는 첫번째 String 필드를 말함 (실제 DB에서 Enum으로 제한된 값과 일치해야 예외가 발생하지 않음
 * @author 정인호
 */
public interface CodeEnum {
    /**
     * @return db의 enum문자열을 반환
     */
    String getCode();

    /**
     * @param code db의 enum 문자열 e.g. : "월요일"
     * @return 커스텀 이넘의 상수 e.g. : MONDAY
     */
    CodeEnum fromCode(String code);
}
