package com.kgc.service;


import com.kgc.pojo.*;

import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 */
public interface DhnService {
    //根据账号id查询用户id
    List<UserInfo> seluserid(Integer aid);

    //根据用户userid查班级id
    GradeUser selGradeId(Integer userid);

    //根据班级id查作业
    List<Releasee> selwork(Integer gradeid, Integer Num, Integer pageSize);

    //根据作业id查看回复
    List<Reply> selhuifu(Integer workid, Integer Num, Integer pageSize);

    //提交作业
    int tijiaozuoye(Works works);

    //查询职位
    Position selPosition(Integer pid);

    //根据班级id查询班级考勤时间
    Timetable selgtime(Integer gid);

    //签到
    int qiandao(Checks checks);

    //根据aid和早上签到时间查询
    Checks getByaid(Integer aid);

    //根据aid和晚上签到时间查询
    Checks gettui(Integer aid);

    //签退
    int qiantui(Checks checks);

    //根据学生id查询班主任id
    List<GradeUser> selaid(Integer gradeid);
    Account selpid(Integer aid);
    Account selbanid(Integer pid);

    //请假
    int qingjia(Apply apply);

    List<Works> selimg();
}
