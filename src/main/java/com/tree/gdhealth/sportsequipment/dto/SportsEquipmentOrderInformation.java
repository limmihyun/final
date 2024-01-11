package com.tree.gdhealth.sportsequipment.dto;

import com.tree.gdhealth.utils.enumtype.OrderStatus;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
@Data
/**<p>물품주문정보를 담은 dto</p>
 * @author 정인호
 */
public class SportsEquipmentOrderInformation {
    private int orderNo;
    private int employeeOrderer;
    private String employeeOrdererName;
    private int branchNo;
    private String branchName;
    private int sportsEquipmentNo;
    private String itemName;
    private String note;
    private int itemPrice;
    private int quantity;
    private int totalPrice;
    private int employeeApprover;
    private String employeeApproverName;
    private OrderStatus orderStatus;
    private LocalDateTime createdate;
    private LocalDateTime updatedate;
}
