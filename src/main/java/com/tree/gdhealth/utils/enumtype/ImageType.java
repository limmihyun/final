package com.tree.gdhealth.utils.enumtype;

import lombok.Getter;

/**
 * @author 정인호
 * @todo 정확한 이미지확장자를 수정할 필요가 있습니다.
 */
@Getter
public enum ImageType {
	
    PNG("image/gif"),
    JPG("image/png"),
    JPEG("image/jpeg"),
    GIF("image/gif"),
    WEBP("image/webp");
	

    private final String contentType;
    ImageType(String contentType) {
        this.contentType = contentType;
    }

    public static ImageType fromText(String text) {
        for ( ImageType imageType : ImageType.values()) {
            if (imageType.contentType.equals(text)) {
                return imageType;
            }
        }
        throw new IllegalArgumentException( text + "에 해당하는 Constant가 없습니다");
    }
}
