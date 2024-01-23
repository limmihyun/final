package com.tree.gdhealth.utils.enumtype;

import lombok.Getter;

/** 물품발주의 처리상태를 나타내는 열거타입
 * @author 정인호
 */
@Getter
public enum OrderStatus {
    WAITING("대기"),
    APPROVED("승인"),
    DENIED("거부");

    private final String code;
    private OrderStatus(String code) {
        this.code = code;
    }

    /**
     * @param code 문자열  e.g. 대기, 승인, 거부
     * @return 문자열에 대응하는 열거타입
     */
    public static OrderStatus fromCode(String code) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if (orderStatus.code.equals(code)) {
                return orderStatus;
            }
        }
        throw new IllegalArgumentException( code + "에 해당하는 열거타입이 없습니다");
    }
}
