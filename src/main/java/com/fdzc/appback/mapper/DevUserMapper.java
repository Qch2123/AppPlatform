package com.fdzc.appback.mapper;

import com.fdzc.appback.entity.DevUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 21504
* @description 针对表【dev_user】的数据库操作Mapper
* @createDate 2025-06-15 12:36:44
* @Entity com.fdzc.appback.entity.DevUser
*/
@Mapper
public interface DevUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DevUser record);

    int insertSelective(DevUser record);

    DevUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DevUser record);

    int updateByPrimaryKey(DevUser record);

    DevUser selectByUserCode(String usercode);

    List<DevUser> selectBy(DevUser devUser);

    Long selectIdByUserCode(String userCode);
}
