package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.pojo.*;

import java.util.List;

public interface LoService {
    List<Grade> selectByGradeId(int gradeId);
    List<GradeUser> selectByUserId(int userid);
    List<Releasee> select7daycount(int gradeid);//根据班级号 去查找最近7次作业的信息
    List<Works> selectByRelid(int relid);//根据班级号去查
    List<Integer> select7daycountGrade(int gradeid);//根据班级号 去查找最近7天每天同学提交的作业总数量

    List<GradeUser> selectByUserIdd(int userID);//根据用户id查找该用户下有哪些班级
    List<Grade> selectByGid(int gid);//根据id查找班级信息
    int insertReleasee(Releasee releasee);//发布作业
    PageInfo<Releasee> selectByGradeIdd(Integer pageNum, Integer pageSize, int gradeId);//根据班级id查找作业表中相对应的值
    List<Works> selecyByRelId(int id);//根据作业id查找提交信息
    List<UserInfo> selectByAccid(int addid);//根据用户id查找userinfo信息
    int updateWorksIsverify(Works works);//根据works对象修改是否审核
    int insertReply(Reply reply);//插入作业回复
    Releasee selectByRid(int rid);//查询releasee表中rid符合数据的值


    /*试卷*/
    List<ExamItems> selectByepaperid(int id);//根据试卷id查找题目
    ExamPaper selectById(int id);//根据id查找该套题
    int insertexamscore(ExamScore examScore);//插入成绩数据
    ExamScore selectByUserIdAndPaperId(int userid, int paperid);//通过用户id和试题id查找相对应的成绩
    int insertExamScoreDetail(ExamScoreDetail examScoreDetail);//将每次做的题的数据添加到该数据库
    ExamScoreDetail selectByUseridAndScoreid(int shitiid, int paperid);//通过实体id和试题id查找做过的题
    List<ExamPaper> loSelectPaper();//查询试卷
    List<ExamScore> selectByUserIdAndPaperIdl(int userid, int paperid);//通过用户id和试题id查找相对应的成绩
    UserInfo uiselectByUserId(int id);//根据用户id查找userinfo中的信息
    List<ExamScore> selectByUserIdAndPaperIdAndPaperUserInfo(int userid, int paperid);//通过用户id和试题id查找相对应的成绩和试卷信息
}
