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
public class SportEquipmentImg {
    private Integer sportEquipmentImgNo;
    private Integer sportEquipmentNo;
    private String sportEquipmentImgOriginName;
    private String sportEquipmentImgFileName;
    private Integer sportEquipmentImgSize;
    private ImgType sportEquipmentImgType;
    private LocalDateTime createdate;
    private LocalDateTime updatedate;
}
