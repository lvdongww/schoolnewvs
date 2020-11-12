package com.kgc.mapper;

import com.kgc.pojo.Check;
import com.kgc.pojo.CheckExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckMapper {
    int countByExample(CheckExample example);

    int deleteByExample(CheckExample example);

    int deleteByPrimaryKey(Integer chid);

    int insert(Check record);

    int insertSelective(Check record);

    List<Check> selectByExample(CheckExample example);

    Check selectByPrimaryKey(Integer chid);

    int updateByExampleSelective(@Param("record") Check record, @Param("example") CheckExample example);

    int updateByExample(@Param("record") Check record, @Param("example") CheckExample example);

    int updateByPrimaryKeySelective(Check record);

    int updateByPrimaryKey(Check record);
}