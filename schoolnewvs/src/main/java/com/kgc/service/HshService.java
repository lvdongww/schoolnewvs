package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.pojo.*;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-17 11:32
 */
public interface HshService {
    Grade hshGrade();
    List<Grade> hshList();
    PageInfo<UserInfo> selfenye(Integer pageIndex, int pageSize, Integer accid, String name, Integer utype, Integer posid);
    //根据gradeid查询userid

    List<GradeUser> hshselg(Integer gradeid);
    //查询个人信息
    UserInfo hshselect(int aid, int tid);
    UserInfo hshselect1(int aid, int tid);
    //修改个人信息
    int hshupdate(UserInfo userinfo);
    //根据aid修改可见状态
    int hshupdz(Integer accid, Integer utype);
    int hshins(UserInfo userInfo);

    //查询总人数
    List<UserInfo> hshsunm();
    //添加学生基本信息
    int hshins2(UserInfo userInfo);
    //添加学生账号
    int hshaccount(Account account);
    //添加学生和班级关联
    int hshgradeuser(GradeUser gradeUser);

    Account accsel(String accountname);
    //查看学生请假情况
    PageInfo<Apply> selapply(Integer pageIndex, Integer pageSize);
    //修改学生请假状态
    int updateapply(Apply apply);
    int insapply(Checks Checks);
    //查询所有班级
    List<Grade> grade();
    //学生的请假
    PageInfo<Apply> hshapplysel(Integer pageIndex, Integer pageSize, Integer aid);
    List<Account> selaccount();
    Account selhh(Integer userid);
    int addgrade(Grade grade);
    int addgradeuser(GradeUser gradeUser);
   List<Grade>  addsel(String grade);
   List<Grade> addsel2();
}
