package com.example.common.entity.user;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**L
 * @author nf
 * @since 2020/6/19 9:55
 */
@Data
@Accessors(chain = true)
public class LoginUser implements Serializable {

    private static final long serialVersionUID = -8507698342815979249L;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 租户id
     */
    private Long tenantId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户昵称
     */
    private String userNickname;

    /**
     * 用户全名
     */
    private String userFullName;

    /**
     * 用户简名
     */
    private String userBriefName;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 是否已经实名认证（0：否；1：是）
     */
    private String isAuth;
    /**
     * 实名认证类型（0：个人；1：企业）
     */
    private String authType;

    /**
     * 手机号
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;

}
