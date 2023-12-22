package com.tree.gdhealth.sportequipment.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author 정인호
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SportEquipmentOrder {
    private Integer orderNo;
    private Integer employeeOrderer;
    private Integer branchNo;
    private Integer sportEquipmentNo;
    private Integer quantity;
    private Integer totalPrice;
    private Integer employeeApprover;
    private OrderStatus orderStatus;
    private LocalDateTime createdate;
    private LocalDateTime updatedate;

    public void setOrderStatus(String statusStr) {
        this.orderStatus = OrderStatus.fromStatusText(statusStr);
    }

    public String getOrderStatusText(){
        return this.orderStatus.getStatusText();
    }
}
