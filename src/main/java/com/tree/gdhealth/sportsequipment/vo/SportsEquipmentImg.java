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
public class SportsEquipmentImg {
    private int sportsEquipmentImgNo;
    private int sportsEquipmentNo;
    private String sportsEquipmentImgOriginName;
    private String sportsEquipmentImgFileName;
    private int sportsEquipmentImgSize;
    private ImageType sportsEquipmentImgType;
    private LocalDateTime createdate;
    private LocalDateTime updatedate;
}
