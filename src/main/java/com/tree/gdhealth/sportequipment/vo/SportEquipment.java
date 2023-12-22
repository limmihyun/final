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
public class SportEquipment {
    private Integer sportEquipmentNo;
    private String itemName;
    private Integer price;
    private String note;
    private LocalDateTime createdate;
    private LocalDateTime updatedate;
}
