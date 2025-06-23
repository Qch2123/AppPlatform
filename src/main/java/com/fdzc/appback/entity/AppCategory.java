package com.fdzc.appback.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 手游类别
 * @TableName app_category
 */
@Data
public class AppCategory implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 分类编码
     */
    private String categorycode;

    /**
     * 分类名称
     */
    private String categoryname;

    /**
     * 父级节点id
     */
    private Long parentid;

    /**
     * 创建者（来源于backend_user用户表的用户id）
     */
    private Long createdby;

    /**
     * 创建时间
     */
    private Date creationtime;

    /**
     * 更新者（来源于backend_user用户表的用户id）
     */
    private Long modifyby;

    /**
     * 最新更新时间
     */
    private Date modifydate;

    private static final long serialVersionUID = 1L;

    private List<AppCategory> children;
}