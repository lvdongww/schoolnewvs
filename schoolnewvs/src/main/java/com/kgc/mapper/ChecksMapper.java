package com.kgc.mapper;

import com.kgc.pojo.Checks;
import com.kgc.pojo.ChecksExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChecksMapper {
    int countByExample(ChecksExample example);

    int deleteByExample(ChecksExample example);

    int deleteByPrimaryKey(Integer chid);

    int insert(Checks record);

    int insertSelective(Checks record);

    List<Checks> selectByExample(ChecksExample example);

    Checks selectByPrimaryKey(Integer chid);

    int updateByExampleSelective(@Param("record") Checks record, @Param("example") ChecksExample example);

    int updateByExample(@Param("record") Checks record, @Param("example") ChecksExample example);

    int updateByPrimaryKeySelective(Checks record);

    int updateByPrimaryKey(Checks record);
}