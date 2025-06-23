package com.fdzc.appback.mapper;

import com.fdzc.appback.entity.AppCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 21504
* @description 针对表【app_category(手游类别)】的数据库操作Mapper
* @createDate 2025-06-15 12:36:44
* @Entity com.fdzc.appback.entity.AppCategory
*/
@Mapper
public interface AppCategoryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(AppCategory record);

    int insertSelective(AppCategory record);

    AppCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppCategory record);

    int updateByPrimaryKey(AppCategory record);

    List<AppCategory> selectAll();
}
