package com.tree.gdhealth.vo;

import com.tree.gdhealth.headoffice.customValidation.ValidFile;
import com.tree.gdhealth.utils.enumtype.ImageType;
import com.tree.gdhealth.utils.typehandler.ImgTypeTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

/**<p>{@link ImageType} using {@link ImgTypeTypeHandler} </p>
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
    private long sportsEquipmentImgSize;
    private ImageType sportsEquipmentImgType;
    private LocalDateTime createdate;
    private LocalDateTime updatedate;
    
    @ValidFile
    private MultipartFile equipmentFile;
}
