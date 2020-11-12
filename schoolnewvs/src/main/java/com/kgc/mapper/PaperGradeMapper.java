package com.kgc.mapper;

import com.kgc.pojo.PaperGrade;
import com.kgc.pojo.PaperGradeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperGradeMapper {
    int countByExample(PaperGradeExample example);

    int deleteByExample(PaperGradeExample example);

    int deleteByPrimaryKey(Integer pgid);

    int insert(PaperGrade record);

    int insertSelective(PaperGrade record);

    List<PaperGrade> selectByExample(PaperGradeExample example);

    PaperGrade selectByPrimaryKey(Integer pgid);

    int updateByExampleSelective(@Param("record") PaperGrade record, @Param("example") PaperGradeExample example);

    int updateByExample(@Param("record") PaperGrade record, @Param("example") PaperGradeExample example);

    int updateByPrimaryKeySelective(PaperGrade record);

    int updateByPrimaryKey(PaperGrade record);
}