package com.tree.gdhealth.vo;

import com.tree.gdhealth.sportsequipment.vo.ImageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**<p>{@link ImageType} using {@link com.tree.gdhealth.mybatis.typehandler.ImgTypeTypeHandler} </p>
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
