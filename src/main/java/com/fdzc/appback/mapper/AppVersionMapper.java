package com.fdzc.appback.mapper;

import com.fdzc.appback.entity.AppVersion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 21504
* @description 针对表【app_version】的数据库操作Mapper
* @createDate 2025-06-15 12:36:44
* @Entity com.fdzc.appback.entity.AppVersion
*/
@Mapper
public interface AppVersionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(AppVersion record);

    int insertSelective(AppVersion record);

    AppVersion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppVersion record);

    int updateByPrimaryKey(AppVersion record);

    List<AppVersion> selectByAppId(Long appid);
}
