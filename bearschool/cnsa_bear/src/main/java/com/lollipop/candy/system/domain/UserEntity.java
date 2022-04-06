package com.lollipop.candy.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author bear
 * @since 2022-02-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
@ApiModel(value="UserEntity对象", description="用户表")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    @ApiModelProperty(value = "用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "盐")
    @TableField("salt")
    private String salt;

    @ApiModelProperty(value = "姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "性别 (0未知 1男 2女 9未说明)")
    @TableField("sex")
    private String sex;

    @ApiModelProperty(value = "联系电话")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty(value = "昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty(value = "部门ID")
    @TableField("dept_id")
    private Long deptId;

    @ApiModelProperty(value = "单位-部门ID")
    @TableField("unit_dept_id")
    private Long unitDeptId;

    @ApiModelProperty(value = "邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "用户头像")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty(value = "个性签名备注")
    @TableField("comment")
    private String comment;

    @ApiModelProperty(value = "用户类型 (1普通人员 2 教师 3学生)")
    @TableField("user_type")
    private String userType;

    @ApiModelProperty(value = "状态 (0正常 1冻结)")
    @TableField("status")
    private String status;

    @ApiModelProperty(value = "钉钉用户ID")
    @TableField("dingding_user_id")
    private String dingdingUserId;

    @ApiModelProperty(value = "最近访问时间")
    @TableField("last_login_time")
    private Date lastLoginTime;

    @ApiModelProperty(value = "创建人")
    @TableField("creator")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改人")
    @TableField("modifier")
    private String modifier;

    @ApiModelProperty(value = "修改时间")
    @TableField("modify_time")
    private Date modifyTime;

    @ApiModelProperty(value = "删除标记 (0未删除 1已删除)")
    @TableField("flag")
    private String flag;


}
