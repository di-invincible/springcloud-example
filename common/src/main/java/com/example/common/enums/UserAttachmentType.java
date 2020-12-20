package com.example.common.enums;

/**
 * @author nf
 * @since 2020/8/5 13:04
 */
public enum UserAttachmentType {

    /** 头像原件图片  */
    AVATAR_ORIGINAL("10","头像原件图片"),
    /** 证件原件照片  */
    IDENTITY_ORIGINAL("20","证件原件照片"),
    /** 证件缩略件照片  */
    IDENTITY_THUMB("21","证件缩略件照片"),
    /** 现场照原件照片  */
    SCENE_ORIGINAL("30","现场照原件照片"),
    /** 现场照缩略件照片  */
    SCENE_THUMB("31","现场照缩略件照片"),
    /** 肖像原件照片  */
    PORTRAIT_ORIGINAL("40","肖像原件照片"),
    ;
    /**
     * code
     */
    private String code;

    /**
     * description
     */
    private String description;

    UserAttachmentType(String code,String description){
        this.code = code;
        this.description = description;
    }

    public static UserAttachmentType from(String code){
        for (UserAttachmentType userAttachmentType : UserAttachmentType.values()){
            if (userAttachmentType.code.equals(code)){
                return userAttachmentType;
            }
        }
        return null;
    }

    public String getCode(){
        return code;
    }

    public String getDescription(){
        return description;
    }
}
