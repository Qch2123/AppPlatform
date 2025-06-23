package com.fdzc.appback.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName backend_user
 */
@Data
public class BackendUser implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户编码
     */
    private String usercode;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户角色类型（来源于数据字典表，分为：超管、财务、市场、运营、销售）
     */
    private Long usertype;

    /**
     * 创建者（来源于backend_user用户表的用户id）
     */
    private Long createdby;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creationdate;

    /**
     * 更新者（来源于backend_user用户表的用户id）
     */
    private Long modifyby;

    /**
     * 最新更新时间
     */
    private Date modifydate;

    /**
     * 用户密码
     */
    private String userpassword;

    private static final long serialVersionUID = 1L;
}