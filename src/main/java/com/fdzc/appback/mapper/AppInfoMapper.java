package com.fdzc.appback.mapper;

import com.fdzc.appback.entity.AppInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 21504
* @description 针对表【app_info】的数据库操作Mapper
* @createDate 2025-06-15 12:36:44
* @Entity com.fdzc.appback.entity.AppInfo
*/
@Mapper
public interface AppInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(AppInfo record);

    int insertSelective(AppInfo record);

    AppInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppInfo record);

    int updateByPrimaryKey(AppInfo record);

    List<AppInfo> selectBy(AppInfo appInfo);

    void update(AppInfo appInfo);
}
