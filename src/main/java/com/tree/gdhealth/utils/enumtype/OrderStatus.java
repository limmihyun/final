package com.tree.gdhealth.utils.enumtype;

import lombok.Getter;

/** 물품발주의 처리상태
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

    public static OrderStatus fromCode(String code) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if (orderStatus.code.equals(code)) {
                return orderStatus;
            }
        }
        throw new IllegalArgumentException( code + "에 해당하는 Constant가 없습니다");
    }
}
