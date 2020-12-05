package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.mapper.*;
import com.kgc.pojo.*;
import com.kgc.service.LvDongService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-15 18:32
 */
@Service
public class LvDongServiceImpl implements LvDongService {
    @Resource
    XiaoXiMapper xiaoXiMapper;
    @Resource
    ChitchatMapper chitchatMapper;
    @Resource
    UserInfoMapper userinfoMapper;
    @Resource
    AccountMapper accountMapper;
    @Resource
    BacklogMapper backlogMapper;
    @Resource
    ExamPaperMapper examPaperMapper;
    @Resource
    ExamItemsMapper examItemsMapper;
    @Resource
    ChecksMapper checksMapper;
    @Resource
    GradeMapper gradeMapper;
    @Resource
    GradeUserMapper gradeUserMapper;
    @Resource
    ApplyMapper applyMapper;
    //添加消息
    @Override
    public int addXiaoXi(XiaoXi xiaoXi) {
        int i = xiaoXiMapper.insertSelective(xiaoXi);
        return i;
    }

    @Override
    public List<Chitchat> lvSelectByHao(Integer aid) {
        List<Chitchat> chitchats = chitchatMapper.selectByHao(aid);
        return chitchats;
    }
    @Override
    public UserInfo lvSelectHaoXinXi(Integer haoid) {
        UserInfoExample userinfoExample=new UserInfoExample();
        UserInfoExample.Criteria criteria = userinfoExample.createCriteria();
        criteria.andAccidEqualTo(haoid);
        criteria.andUtypeNotEqualTo(0);
        List<UserInfo> userinfos = userinfoMapper.selectByExample(userinfoExample);
        UserInfo userinfo1 = userinfos.get(0);
        return userinfo1;
    }

    @Override
    public synchronized Chitchat lvSelectByHaoXiao(Integer aid, Integer haoid) {
        List<Chitchat> chitchats = chitchatMapper.selectByXiao(aid, haoid);
        if (chitchats.size()!=0){
            return chitchats.get(0);
        }
        return null;
    }
    @Override
    public  List<Chitchat> lvSelectByHaoXiao11(Integer aid, Integer haoid) {
        List<Chitchat> chitchats = chitchatMapper.selectByXiao1(aid, haoid);
        return chitchats;
    }

    @Override
    public List<Chitchat> lvSelectNiCeName(Integer aid, String nickname) {
        return chitchatMapper.selectNiCeName(aid,"%"+nickname+"%");
    }

    @Override
    public Account selectUserName(String acc) {
        AccountExample accountExample=new AccountExample();
        AccountExample.Criteria criteria = accountExample.createCriteria();
        criteria.andAccountnameEqualTo(acc);
        List<Account> accounts = accountMapper.selectByExample(accountExample);
        if (accounts.size()>0){
            return accounts.get(0);
        }
        return null;
    }

    @Override
    public UserInfo selectUserByAid(Integer id) {
        UserInfoExample userInfoExample=new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andAccidEqualTo(id);
        List<UserInfo> userInfos = userinfoMapper.selectByExample(userInfoExample);
        if (userInfos.size()>0){
            return userInfos.get(0);
        }
        return null;
    }

    public int lvAddBacklog(Backlog backlog) {
        int i = backlogMapper.insertSelective(backlog);
        return i;
    }

    @Override
    public List<Backlog> lvSelectFriend(Integer id) {
        BacklogExample backlogExample=new BacklogExample();
        BacklogExample.Criteria criteria = backlogExample.createCriteria();
        criteria.andHaoidEqualTo(id);
        List<Backlog> backlogs = backlogMapper.selectByExample(backlogExample);
        return backlogs;
    }

    @Override
    public int lvAddChitchat(Chitchat chitchat) {
        int i = chitchatMapper.insertSelective(chitchat);
        return i;
    }

    @Override
    public int lvDelChitchat(Integer backid) {
        return backlogMapper.deleteByPrimaryKey(backid);
    }

    @Override
    public Chitchat lvChitchatId(Integer aid, Integer haoid) {
        ChitchatExample chitchatExample=new ChitchatExample();
        ChitchatExample.Criteria criteria = chitchatExample.createCriteria();
        criteria.andUseridEqualTo(aid);
        criteria.andHaoidEqualTo(haoid);
        List<Chitchat> chitchats = chitchatMapper.selectByExample(chitchatExample);
        return chitchats.get(0);
    }

    @Override
    public Account lvSelectByAcc(Integer aid) {
        return accountMapper.selectByPrimaryKey(aid);
    }

    @Override
    public UserInfo lvSelectByUserInfo(Integer aid) {
        UserInfoExample userInfoExample=new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andAccidEqualTo(aid);
        criteria.andUtypeEqualTo(1);
        return userinfoMapper.selectByExample(userInfoExample).get(0);
    }

    @Override
    public UserInfo lvSelectByEamilAid(String e) {
        UserInfoExample userInfoExample=new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andEamilEqualTo(e);
        criteria.andUtypeEqualTo(1);
        return userinfoMapper.selectByExample(userInfoExample).get(0);
    }

    @Override
    public int lvUpdateAccPwd(Account account) {
        return accountMapper.updateByPrimaryKeySelective(account);
    }

    @Override
    public UserInfo lvSelectByPhoneAid(String e) {
        UserInfoExample userInfoExample=new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andPhoneEqualTo(e);
        criteria.andUtypeEqualTo(1);
        return userinfoMapper.selectByExample(userInfoExample).get(0);
    }

    @Override
    public List<ExamPaper> lvSelectPaper() {
        ExamPaperExample examPaperExample=new ExamPaperExample();
        examPaperExample.setOrderByClause("create_time desc");
        return examPaperMapper.selectByExample(examPaperExample);
    }

    @Override
    public int lvAddExamPapar(ExamPaper examPaper) {
        return examPaperMapper.insertSelective(examPaper);
    }

    @Override
    public int lvSelectByPaper(String papername) {
        ExamPaperExample paperExample=new ExamPaperExample();
        paperExample.setOrderByClause("create_time desc");
        ExamPaperExample.Criteria criteria = paperExample.createCriteria();
        criteria.andPapernameEqualTo(papername);
        List<ExamPaper> examPapers = examPaperMapper.selectByExample(paperExample);
        return examPapers.get(0).getPaperid();
    }

    @Override
    public int lvAddExamItems(ExamItems examItems) {
        return examItemsMapper.insertSelective(examItems);
    }

    @Override
    public List<Checks> lvSelectCheck(int aid, String first, String last) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        ChecksExample checkExample=new ChecksExample();
        checkExample.setOrderByClause("signindate asc");
        ChecksExample.Criteria criteria = checkExample.createCriteria();
        Date date;
        Date date1;
        try {
            date= simpleDateFormat.parse(first);
            date1=simpleDateFormat.parse(last);
            criteria.andAidEqualTo(aid);
            criteria.andSignindateBetween(date,date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Checks> checks = checksMapper.selectByExample(checkExample);
        return checks;
    }

    @Override
    public List<Grade> lvSelectGrade(Integer aid) {
        GradeUserExample gradeExample=new GradeUserExample();
        GradeUserExample.Criteria criteria = gradeExample.createCriteria();
        GradeExample gradeExample1=new GradeExample();
        GradeExample.Criteria criteria1 = gradeExample1.createCriteria();
        criteria.andUseridEqualTo(aid);
        List<GradeUser> gradeUsers = gradeUserMapper.selectByExample(gradeExample);
        List<Grade> grades=new ArrayList<>();
        for (GradeUser gradeUser : gradeUsers) {
            Grade grade = gradeMapper.selectByPrimaryKey(gradeUser.getGradeid());
            grades.add(grade);
        }
        return grades;
    }

    @Override
    public PageInfo<UserInfo> lvSelectToDay(Integer pageIndex, Integer pageSize, Integer gid) {
        PageHelper.startPage(pageIndex,pageSize);
        List<UserInfo> userInfos = userinfoMapper.lvSelectToDay(gid);
        PageInfo<UserInfo> pageInfo=new PageInfo<>(userInfos);
        return pageInfo;
    }

    @Override
    public PageInfo<UserInfo> lvSelectBenKao(Integer pageIndex, Integer pageSize, Integer gid,String firstDayont,String lastDay) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        PageHelper.startPage(pageIndex,pageSize);
        List<UserInfo> userInfos = userinfoMapper.lvSelectBenKao(gid);
        Date date;
        Date date1;
        for (UserInfo userInfo : userInfos) {
            try {
                ChecksExample checksExample=new ChecksExample();
                ChecksExample.Criteria criteria = checksExample.createCriteria();
                date= simpleDateFormat.parse(firstDayont);
                date1=simpleDateFormat.parse(lastDay);
                criteria.andAidEqualTo(userInfo.getAccid());
                criteria.andSignindateBetween(date,date1);
                List<Checks> checks = checksMapper.selectByExample(checksExample);
                userInfo.setCount(checks.size());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        PageInfo<UserInfo> pageInfo=new PageInfo<>(userInfos);
        return pageInfo;
    }

    @Override
    public List<Apply> lvSelectSheng(Integer aid) {
        ApplyExample applyExample=new ApplyExample();
        ApplyExample.Criteria criteria = applyExample.createCriteria();
        criteria.andTeacheridEqualTo(aid);
        criteria.andApptypeEqualTo(1);
        List<Apply> applies = applyMapper.selectByExample(applyExample);
        return applies;
    }

    @Override
    public List<UserInfo> lvSelectJiao() {
        AccountExample accountExample=new AccountExample();
        AccountExample.Criteria criteria = accountExample.createCriteria();
        criteria.andPosidEqualTo(2);
        List<Account> accounts = accountMapper.selectByExample(accountExample);
        List<UserInfo> userInfos=new ArrayList<>();
        for (Account account : accounts) {
            UserInfoExample userInfoExample=new UserInfoExample();
            UserInfoExample.Criteria criteria1 = userInfoExample.createCriteria();
            criteria1.andAccidEqualTo(account.getAid());
            criteria1.andUtypeEqualTo(1);
            List<UserInfo> userInfos1 = userinfoMapper.selectByExample(userInfoExample);
            userInfos.add(userInfos1.get(0));
        }
        return userInfos;
    }


}
