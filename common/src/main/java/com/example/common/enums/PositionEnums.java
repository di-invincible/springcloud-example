package com.example.common.enums;

/**
 * @author nf
 * @since 2020/8/6 14:39
 */
public enum PositionEnums {

    /**
     * 左侧菜单
     */
    LEFT(0,"左侧菜单"),

    /**
     * 顶部菜单
     */
    TOP(1,"顶部菜单"),
    /**
     * 用户菜单
     */
    USER(2,"用户菜单"),
    ;

    /**
     * code
     */
    private Integer code;

    /**
     * description
     */
    private String description;

    PositionEnums(Integer code, String description){
        this.code = code;
        this.description = description;
    }

    public static PositionEnums from(Integer code){
        for (PositionEnums type : PositionEnums.values()){
            if (type.code.equals(code)){
                return type;
            }
        }
        return null;
    }

    public Integer getCode(){
        return code;
    }

    public String getDescription(){
        return description;
    }
}
