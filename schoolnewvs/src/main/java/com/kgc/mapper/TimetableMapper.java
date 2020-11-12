package com.kgc.mapper;

import com.kgc.pojo.Timetable;
import com.kgc.pojo.TimetableExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TimetableMapper {
    int countByExample(TimetableExample example);

    int deleteByExample(TimetableExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(Timetable record);

    int insertSelective(Timetable record);

    List<Timetable> selectByExample(TimetableExample example);

    Timetable selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") Timetable record, @Param("example") TimetableExample example);

    int updateByExample(@Param("record") Timetable record, @Param("example") TimetableExample example);

    int updateByPrimaryKeySelective(Timetable record);

    int updateByPrimaryKey(Timetable record);
}