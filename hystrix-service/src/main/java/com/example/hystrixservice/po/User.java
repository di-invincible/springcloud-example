package com.example.hystrixservice.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author aaron
 * @since 2020-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户登录密码
     */
    private String password;

    /**
     * 用户昵称帐号
     */
    private String nickname;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 出生日期
     */
    private LocalDate birthday;

    /**
     * 性别 男1女0
     */
    private String sex;

    /**
     * 头像
     */
    private String headPortrait;

    /**
     * 手机绑定时间
     */
    private LocalDateTime mobileBindTime;

    /**
     * 邮箱绑定时间
     */
    private LocalDateTime emailBindTime;

    /**
     * 最后登录时间
     */
    private LocalDateTime loginTime;

    /**
     * 用户状态 0 禁用 1启用
     */
    private String userStatus;

    /**
     * 创建人
     */
    private Integer createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private Integer updateBy;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 1 表示删除，0 表示未删除
     */
    private String delFlag;

    /**
     * 备注

     */
    private String remarks;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
