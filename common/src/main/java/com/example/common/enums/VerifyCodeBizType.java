package com.example.common.enums;

/**
 * @author nf
 * @since 2020/8/4 13:45
 */
public enum VerifyCodeBizType {

    /**
     * 注册
     */
    REGISTER("0","注册"),
    /**
     * 信息变更
     */
    RESET("1","信息变更"),
    /**
     * 修改
     */
    MODIFY("2","修改"),

    /**
     * 登录
     */
    LOGIN("3","登录"),

    /**
     * 身份认证
     */
    AUTHENTICATION("4","身份认证"),


    /**
     * 咨询
     */
    CONSULT("5","咨询"),

    ;

    /**
     * code
     */
    private String code;

    /**
     * description
     */
    private String description;

    VerifyCodeBizType(String code,String description){
        this.code = code;
        this.description = description;
    }

    public static VerifyCodeBizType from(String code){
        for (VerifyCodeBizType verifyCodeBizType : VerifyCodeBizType.values()){
            if (verifyCodeBizType.code.equals(code)){
                return verifyCodeBizType;
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
