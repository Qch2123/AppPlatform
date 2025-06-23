package com.fdzc.appback.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName app_version
 */
@Data
public class AppVersion implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * appId（来源于：app_info表的主键id）
     */
    private Long appid;

    /**
     * 版本号
     */
    private String versionno;

    /**
     * 版本介绍
     */
    private String versioninfo;

    /**
     * 发布状态（来源于：data_dictionary，1 不发布 2 已发布 3 预发布）
     */
    private Long publishstatus;

    /**
     * 下载链接
     */
    private String downloadlink;

    /**
     * 版本大小（单位：M）
     */
    private BigDecimal versionsize;

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
     * apk文件的服务器存储路径
     */
    private String apklocpath;

    /**
     * 上传的apk文件名称
     */
    private String apkfilename;

    private static final long serialVersionUID = 1L;
}