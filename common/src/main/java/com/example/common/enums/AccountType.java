package com.example.common.enums;

/**
 * @author nf
 * @since 2020/8/4 11:44
 */
public enum AccountType {

    /**
     * 手机号
     */
    MOBILE("0","手机号"),

    /**
     * 邮箱
     */
    EMAIL("1","邮箱"),
    /**
     * 昵称
     */
    NICKNAME("2","昵称"),
    /**
     * 身份证
     */
    IDENTITY("3","身份证")
    ;

    /**
     * code
     */
    private String code;

    /**
     * description
     */
    private String description;

    AccountType(String code, String description){
        this.code = code;
        this.description = description;
    }

    public static AccountType from(String code){
        for (AccountType accountType : AccountType.values()){
            if (accountType.code.equals(code)){
                return accountType;
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
