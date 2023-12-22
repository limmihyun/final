package com.tree.gdhealth.sportequipment.vo;
/**
 * @author 정인호
 * @todo 정확한 이미지확장자를 수정할 필요가 있습니다.
 */
public enum ImgType {
    PNG("image/gif"),
    JPG("image/png"),
    JPEG("image/jpeg"),
    GIF("image/gif");

    private final String contentType;
    ImgType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

    public static ImgType fromImgTypeText(String imgTypeStr) {
        for ( ImgType imgType : ImgType.values()) {
            if (imgType.contentType.equals(imgTypeStr)) {
                return imgType;
            }
        }
        throw new IllegalArgumentException( imgTypeStr + "에 해당하는 Constant가 없습니다");
    }
}
