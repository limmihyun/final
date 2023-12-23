package com.tree.gdhealth.sportsequipment.vo;

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
public class SportsEquipment {
    private int sportsEquipmentNo;
    private String itemName;
    private int itemPrice;
    private String note;
    private LocalDateTime createdate;
    private LocalDateTime updatedate;
}
