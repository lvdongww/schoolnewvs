package com.kgc.service.impl;

import com.kgc.mapper.*;
import com.kgc.pojo.*;
import com.kgc.service.DhnService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 */
@Service("dhnService")
public class DhnServiceImpl implements DhnService {
    @Resource
    UserInfoMapper userInfoMapper;

    @Resource
    WorksMapper worksMapper;

    @Resource
    ReleaseeMapper releaseeMapper;

    @Resource
    GradeUserMapper gradeUserMapper;

    @Resource
    ReplyMapper replyMapper;

    @Resource
    PositionMapper positionMapper;

    @Resource
    TimetableMapper timetableMapper;

    @Resource
    ChecksMapper checksMapper;

    @Resource
    ApplyMapper applyMapper;

    @Resource
    AccountMapper accountMapper;

    @Override
    public List<UserInfo> seluserid(Integer aid) {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andAccidEqualTo(aid);
        return userInfoMapper.selectByExample(example);
    }

    @Override
    public GradeUser selGradeId(Integer userid) {
        GradeUserExample example = new GradeUserExample();
        GradeUserExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<GradeUser> gradeUsers = gradeUserMapper.selectByExample(example);
        GradeUser gradeUser = gradeUsers.get(0);
        return gradeUser;
    }

    @Override
    public List<Releasee> selwork(Integer gradeid, Integer Num, Integer pageSize) {
        ReleaseeExample example = new ReleaseeExample();
        ReleaseeExample.Criteria criteria = example.createCriteria();
        criteria.andGradeidEqualTo(gradeid);
        return releaseeMapper.selectByExample(example);
    }

    @Override
    public List<Reply> selhuifu(Integer workid, Integer Num, Integer pageSize) {
        ReplyExample example = new ReplyExample();
        ReplyExample.Criteria criteria = example.createCriteria();
        criteria.andWoridEqualTo(workid);
        return replyMapper.selectByExample(example);
    }

    @Override
    public int tijiaozuoye(Works works) {
        return worksMapper.insert(works);
    }

    @Override
    public Position selPosition(Integer pid) {
        return positionMapper.selectByPrimaryKey(pid);
    }

    @Override
    public Timetable selgtime(Integer gid) {
        TimetableExample example = new TimetableExample();
        TimetableExample.Criteria criteria = example.createCriteria();
        criteria.andGidEqualTo(gid);
        List<Timetable> timetables = timetableMapper.selectByExample(example);
        Timetable timetable = timetables.get(0);
        return timetable;
    }

    @Override
    public int qiandao(Checks checks) {
        return checksMapper.insert(checks);
    }

    @Override
    public Checks getByaid(Integer aid) {
        ChecksExample example = new ChecksExample();
        ChecksExample.Criteria criteria = example.createCriteria();
        criteria.andAidEqualTo(aid);
        Date date = new Date();
        String qiandate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        String substring = qiandate.substring(0, 10);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = simpleDateFormat.parse(substring);
            criteria.andAidEqualTo(aid);
            criteria.andSignindateGreaterThanOrEqualTo(parse);
            List<Checks> checks = checksMapper.selectByExample(example);
            if (checks.size() > 0) {
                return checks.get(0);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Checks gettui(Integer aid) {
        ChecksExample example = new ChecksExample();
        ChecksExample.Criteria criteria = example.createCriteria();
        criteria.andAidEqualTo(aid);
        Date date = new Date();
        String qiandate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        String substring = qiandate.substring(0, 10);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = simpleDateFormat.parse(substring);
            criteria.andAidEqualTo(aid);
            criteria.andSignoutdateGreaterThanOrEqualTo(parse);
            List<Checks> checks = checksMapper.selectByExample(example);
            if (checks.size() > 0) {
                return checks.get(0);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int qiantui(Checks checks) {
        return checksMapper.updateByPrimaryKey(checks);
    }

    @Override
    public List<GradeUser> selaid(Integer gradeid) {
        GradeUserExample example = new GradeUserExample();
        GradeUserExample.Criteria criteria = example.createCriteria();
        criteria.andGradeidEqualTo(gradeid);
        return gradeUserMapper.selectByExample(example);
    }

    @Override
    public Account selpid(Integer aid) {
        AccountExample example = new AccountExample();
        AccountExample.Criteria criteria = example.createCriteria();
        criteria.andAidEqualTo(aid);
        List<Account> accounts = accountMapper.selectByExample(example);
        if (accounts.size() > 0) {
            return accounts.get(0);
        }
        return null;
    }

    @Override
    public Account selbanid(Integer pid) {
        AccountExample example = new AccountExample();
        AccountExample.Criteria criteria = example.createCriteria();
        criteria.andPosidEqualTo(pid);
        List<Account> accounts = accountMapper.selectByExample(example);
        if (accounts.size() > 0) {
            return accounts.get(0);
        }
        return null;
    }

    @Override
    public int qingjia(Apply apply) {
        return applyMapper.insert(apply);
    }

    @Override
    public List<Works> selimg() {
        List<Works> works = worksMapper.selectByExample(null);
        return works;
    }
}
