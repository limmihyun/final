package com.tree.gdhealth.utility;

import com.tree.gdhealth.exception.MissMatchedContentTypeException;
import com.tree.gdhealth.sportsequipment.vo.ImageType;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**<p>이미지파일 저장을 위한 클래스</p>
 * @author 정인호
 * @apiNote 사용법: saveImage(MultipartFile imageFile)정적메소드를 실행하면 타입체크와 저장까지 마치고 저장시 활용된 정보가 담긴 ImageSaver 인스턴스를 반환한다.
 */
@ToString
@Slf4j
@Getter
public final class ImageSaver {
    private final static String DEFAULT_PATH = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\img\\";
    private final String originImageName;
    private final String savedImageName;
    private final String savedImagePath;
    private final Long imageSize;
    private final String contentType;

    private ImageSaver(String originImageName, String savedImageName, String savedImagePath, Long imageSize, String contentType){
        this.originImageName = originImageName;
        this.savedImageName = savedImageName;
        this.savedImagePath = savedImagePath;
        this.imageSize = imageSize;
        this.contentType = contentType;
    }

    private static boolean isImageType(String contentType){
        boolean result = false;
        for(ImageType imageType : ImageType.values()){
            result |= imageType.getContentType().equals(contentType);
        }
        return result;
    }

    public static ImageSaver saveImage(MultipartFile imageFile){
        String originImageName = imageFile.getOriginalFilename();
        String savedImageName = UUID.randomUUID() + originImageName;
        String savedImagePath = DEFAULT_PATH + savedImageName;
        Long imageSize = imageFile.getSize();
        String contentType = imageFile.getContentType();

        if(!isImageType(contentType)){
            throw new MissMatchedContentTypeException("이미지타입이 아닙니다. 받은 contentType="+contentType);
        }

        try {
            File file = new File(savedImagePath);
            imageFile.transferTo(file);
        } catch (IOException e) {
            log.error("이미지 저장에 실패하였습니다. 입력된 이미지{}",imageFile.toString());
            throw new RuntimeException(e);
        }
        log.debug("이미지 저장에 성공하였습니다.");
        return new ImageSaver(
                originImageName,
                savedImageName,
                savedImagePath,
                imageSize,
                contentType);
    }
}
