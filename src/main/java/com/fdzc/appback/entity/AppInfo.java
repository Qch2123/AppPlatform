package com.fdzc.appback.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName app_info
 */
@Data
public class AppInfo implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 软件名称
     */
    private String softwarename;

    /**
     * APK名称（唯一）
     */
    private String apkname;

    /**
     * 支持ROM
     */
    private String supportrom;

    /**
     * 界面语言
     */
    private String interfacelanguage;

    /**
     * 软件大小（单位：M）
     */
    private BigDecimal softwaresize;

    /**
     * 更新日期
     */
    private Date updatedate;

    /**
     * 开发者id（来源于：dev_user表的开发者id）
     */
    private Long devid;

    //开发者账号
    private String devCode;

    //开发者姓名
    private String devName;

    /**
     * 应用简介
     */
    private String appinfo;

    /**
     * 状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）
     */
    private Long status;

    /**
     * 上架时间
     */
    private Date onsaledate;

    /**
     * 下架时间
     */
    private Date offsaledate;

    /**
     * 所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）
     */
    private Long flatformid;

    /**
     * 所属三级分类（来源于：data_dictionary）
     */
    private Long categorylevel3;

    /**
     * 下载量（单位：次）
     */
    private Long downloads;

    /**
     * 创建者（来源于dev_user开发者信息表的用户id）
     */
    private Long createdby;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creationdate;

    /**
     * 更新者（来源于dev_user开发者信息表的用户id）
     */
    private Long modifyby;

    /**
     * 最新更新时间
     */
    private Date modifydate;

    /**
     * 所属一级分类（来源于：data_dictionary）
     */
    private Long categorylevel1;

    private String level1Name;
    private String level2Name;
    private String level3Name;
    /**
     * 所属二级分类（来源于：data_dictionary）
     */
    private Long categorylevel2;

    /**
     * LOGO图片url路径
     */
    private String logopicpath;

    /**
     * LOGO图片的服务器存储路径
     */
    private String logolocpath;

    /**
     * 最新的版本id
     */
    private Long versionid;

    private List<AppVersion> versions;

    private static final long serialVersionUID = 1L;
}