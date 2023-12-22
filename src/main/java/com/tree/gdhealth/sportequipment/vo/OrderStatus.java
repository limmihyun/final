package com.tree.gdhealth.sportequipment.vo;
/**
 * @author 정인호
 */
public enum OrderStatus {
    WAITING("대기"),
    APPROVED("승인"),
    DENIED("거부");

    private final String status;
    private OrderStatus(String str) {
        this.status = str;
    }
    public String getStatusText() {
        return status;
    }

    public static OrderStatus fromStatusText(String statusStr) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if (orderStatus.status.equals(statusStr)) {
                return orderStatus;
            }
        }
        throw new IllegalArgumentException( statusStr + "에 해당하는 Constant가 없습니다");
    }
}
