package com.kgc.mapper;

import com.kgc.pojo.UserInfo;
import com.kgc.pojo.UserInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {
    int countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);
    List<UserInfo> selectByExample2(UserInfoExample example);
    List<UserInfo> selectByExample(UserInfoExample example);
    List<UserInfo> lvSelectToDay(Integer gid);
    List<UserInfo> lvSelectBenKao(Integer gid);
    UserInfo selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}