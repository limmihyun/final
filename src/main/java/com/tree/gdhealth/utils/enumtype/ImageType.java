package com.tree.gdhealth.utils.enumtype;

import lombok.Getter;

/**<p>웹에서 전송된 멀티파트 이미지 파일의 컨텐츠타입(String)을 대응시키는 enum</p>
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

    /**
     * @param contentType String
     * @return 대응되는 enum
     * @throws IllegalArgumentException 대응되는 enum이 없는경우
     */
    public static ImageType fromText(String contentType) {
        for ( ImageType imageType : ImageType.values()) {
            if (imageType.contentType.equals(contentType)) {
                return imageType;
            }
        }
        throw new IllegalArgumentException( contentType + "에 해당하는 enum 이 없습니다");
    }
}
