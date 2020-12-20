package com.example.common.enums;

/**
 * @author nf
 * @since 2020/8/4 11:30
 */
public enum UserType {

    /**
     * 未定义
     */
    UNDEFINED("0","未定义"),

    /**
     * 个人
     */
    PERSONAL("1","个人"),

    /**
     * 公司
     */
    UNIT("2","公司"),
    ;

    /**
     * code
     */
    private String code;

    /**
     * description
     */
    private String description;

    UserType(String code,String description){
        this.code = code;
        this.description = description;
    }

    public static UserType from(String code){
        for (UserType userType : UserType.values()){
            if (userType.code.equals(code)){
                return userType;
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
