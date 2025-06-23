package com.fdzc.appback.mapper;

import com.fdzc.appback.entity.BackendUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 21504
* @description 针对表【backend_user】的数据库操作Mapper
* @createDate 2025-06-15 12:36:44
* @Entity com.fdzc.appback.entity.BackendUser
*/
@Mapper
public interface BackendUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(BackendUser record);

    int insertSelective(BackendUser record);

    BackendUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BackendUser record);

    int updateByPrimaryKey(BackendUser record);

    BackendUser selectByUserCode(String usercode);

    List<BackendUser> selectBy(BackendUser backendUser);
}
