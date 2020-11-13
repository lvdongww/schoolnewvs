package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.mapper.*;
import com.kgc.pojo.*;
import com.kgc.service.LoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("loService")
public class LoServiceImpl implements LoService {
    @Resource
    GradeMapper gradeMapper;
    @Resource
    GradeUserMapper gradeUserMapper;
    @Resource
    ReleaseeMapper releaseeMapper;
    @Resource
    WorksMapper worksMapper;
    @Resource
    LoService loService;
    @Resource
    UserInfoMapper userInfoMapper;
    @Resource
    ReplyMapper replyMapper;
    @Resource
    ExamItemsMapper examItemsMapper;
    @Resource
    ExamPaperMapper examPaperMapper;
    @Resource
    ExamScoreMapper examScoreMapper;
    @Resource
    ExamScoreDetailMapper examScoreDetailMapper;
    @Override
    public List<Grade> selectByGradeId(int gradeId) {
        GradeExample example=new GradeExample();
        GradeExample.Criteria criteria = example.createCriteria();
        criteria.andGidEqualTo(gradeId);
        List<Grade> grades = gradeMapper.selectByExample(example);
        return grades;
    }
    @Override
    public List<GradeUser> selectByUserId(int userid) {
        GradeUserExample example=new GradeUserExample();
        GradeUserExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<GradeUser> gradeUsers = gradeUserMapper.selectByExample(example);
        return gradeUsers;
    }
    @Override
    public List<Releasee> select7daycount(int gradeid) {
        System.out.println("gradeid:"+gradeid);
        ReleaseeExample example=new ReleaseeExample();
        example.setOrderByClause("rid");
        ReleaseeExample.Criteria criteria = example.createCriteria();
        criteria.andGradeidEqualTo(gradeid);
        List<Releasee> releasees = releaseeMapper.selectByExample(example);
        List<Releasee> rList=new ArrayList<>();
        if(releasees.size()<6){
            for (int i=0;i<releasees.size();i++){
                rList.add(releasees.get(i));
            }
        }else{
            for (int i=0;i<=6;i++){
                rList.add(releasees.get(i));
            }
        }
        return rList;
    }
    @Override
    public List<Works> selectByRelid(int relid) {
        WorksExample example=new WorksExample();
        WorksExample.Criteria criteria = example.createCriteria();
        criteria.andRelidEqualTo(relid);
        List<Works> works = worksMapper.selectByExample(example);
        return works;
    }
    @Override
    public List<Integer> select7daycountGrade(int gradeid) {
        WorksExample example=new WorksExample();
        example.setOrderByClause("wid");
        WorksExample.Criteria criteria = example.createCriteria();
        criteria.andGradeidEqualTo(gradeid);
        List<Works> wList=worksMapper.selectByExample(example);
        List<Integer> sum=new ArrayList();
      /* for(int i=0;i<wList.size();i++){
           if(sum.size()!=0){
               for(int j=0;j<)
           }
       }*/
        return sum;
    }

    @Override
    public List<GradeUser> selectByUserIdd(int userID) {
        GradeUserExample example=new GradeUserExample();
        GradeUserExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userID);
        List<GradeUser> gradeUsers = gradeUserMapper.selectByExample(example);
        return gradeUsers;
    }

    @Override
    public List<Grade> selectByGid(int gid) {
        GradeExample example=new GradeExample();
        GradeExample.Criteria criteria = example.createCriteria();
        criteria.andGidEqualTo(gid);
        List<Grade> grades = gradeMapper.selectByExample(example);
        return grades;
    }

    @Override
    public int insertReleasee(Releasee releasee) {
        int i = releaseeMapper.insertSelective(releasee);
        return i;
    }

    @Override
    public PageInfo<Releasee> selectByGradeIdd(Integer pageNum, Integer pageSize, int gradeId) {
        ReleaseeExample example=new ReleaseeExample();
        ReleaseeExample.Criteria criteria = example.createCriteria();
        criteria.andGradeidEqualTo(gradeId);
        PageHelper.startPage(pageNum, pageSize);
        List<Releasee> releasees = releaseeMapper.selectByExample(example);
        for(int i=0;i<releasees.size();i++){
            List<Grade> grades = loService.selectByGid(releasees.get(i).getGradeid());
            releasees.get(i).setGrade(grades.get(grades.size()-1));
        }
        PageInfo<Releasee> pageInfo = new PageInfo<>(releasees);
        return pageInfo;
    }

    @Override
    public List<Works> selecyByRelId(int id) {
        WorksExample example=new WorksExample();
        WorksExample.Criteria criteria = example.createCriteria();
        criteria.andRelidEqualTo(id);
        List<Works> works = worksMapper.selectByExample(example);
        for(int i=0;i<works.size();i++){
            List<Grade> grades = loService.selectByGid(works.get(i).getGradeid());
            works.get(i).setGrade(grades.get(grades.size()-1));
            List<UserInfo> userInfos = loService.selectByAccid(works.get(i).getUserid());
            works.get(i).setUserInfo(userInfos.get(0));
        }
        return works;
    }

    @Override
    public List<UserInfo> selectByAccid(int addid) {
        UserInfoExample example=new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andAccidEqualTo(addid);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(example);
        return userInfos;
    }

    @Override
    public int updateWorksIsverify(Works works) {
        int i = worksMapper.updateByPrimaryKeySelective(works);
        return i;
    }

    @Override
    public int insertReply(Reply reply) {
        int i = replyMapper.insertSelective(reply);
        return i;
    }

    @Override
    public Releasee selectByRid(int rid) {
        Releasee releasee = releaseeMapper.selectByPrimaryKey(rid);
        return releasee;
    }

    @Override
    public UserInfo uiselectByUserId(int id) {
        UserInfoExample example=new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andAccidEqualTo(id);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(example);
        return userInfos.get(0);
    }

    @Override
    public List<ExamItems> selectByepaperid(int id) {
        ExamItemsExample example=new ExamItemsExample();
        ExamItemsExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("eid asc");
        criteria.andEpaperidEqualTo(id);
        List<ExamItems> examItems = examItemsMapper.selectByExample(example);
        return examItems;
    }

    @Override
    public ExamPaper selectById(int id) {
        return examPaperMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertexamscore(ExamScore examScore) {
        return examScoreMapper.insertSelective(examScore);
    }

    @Override
    public ExamScore selectByUserIdAndPaperId(int userid, int paperid) {
        ExamScoreExample example=new ExamScoreExample();
        ExamScoreExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userid);
        criteria.andPaperidEqualTo(paperid);
        List<ExamScore> examScores = examScoreMapper.selectByExample(example);
        return examScores.get(0);
    }

    @Override
    public int insertExamScoreDetail(ExamScoreDetail examScoreDetail) {
        return examScoreDetailMapper.insertSelective(examScoreDetail);
    }

    @Override
    public ExamScoreDetail selectByUseridAndScoreid(int shitiid, int paperid) {
        ExamScoreDetailExample example=new ExamScoreDetailExample();
        ExamScoreDetailExample.Criteria criteria = example.createCriteria();
        criteria.andScoreidEqualTo(paperid);
        criteria.andEidEqualTo(shitiid);
        List<ExamScoreDetail> examScoreDetails = examScoreDetailMapper.selectByExample(example);
        return examScoreDetails.get(0);
    }

    @Override
    public List<ExamPaper> loSelectPaper() {
        ExamPaperExample examPaperExample=new ExamPaperExample();
        examPaperExample.setOrderByClause("create_time desc");
        return examPaperMapper.selectByExample(examPaperExample);
    }

    @Override
    public List<ExamScore> selectByUserIdAndPaperIdl(int userid, int paperid) {
        ExamScoreExample example=new ExamScoreExample();
        ExamScoreExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userid);
        criteria.andPaperidEqualTo(paperid);
        List<ExamScore> examScores = examScoreMapper.selectByExample(example);
        return examScores;
    }
    @Override
    public List<ExamScore> selectByUserIdAndPaperIdAndPaperUserInfo(int userid, int paperid) {
        ExamScoreExample example=new ExamScoreExample();
        example.setOrderByClause("scoreid desc");
        ExamScoreExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userid);
        criteria.andPaperidEqualTo(paperid);
        List<ExamScore> examScores = examScoreMapper.selectByExample(example);
        for (ExamScore examScore : examScores) {
            ExamPaper examPaper = loService.selectById(examScore.getPaperid());
            examScore.setExamPaper(examPaper);
        }
        return examScores;
    }
}
