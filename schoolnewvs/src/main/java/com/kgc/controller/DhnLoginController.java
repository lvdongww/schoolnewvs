package com.kgc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.mapper.AccountMapper;
import com.kgc.pojo.*;
import com.kgc.service.DhnService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author shkstart
 */
@Controller
public class DhnLoginController {
    @Resource
    AccountMapper accountMapper;

    @Resource
    DhnService dhnService;


    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("/dologin")
    public String toindex(Model model, @RequestParam String username, @RequestParam String password, HttpSession session) {
        AccountExample example = new AccountExample();
        AccountExample.Criteria criteria = example.createCriteria();
        criteria.andAccountnameEqualTo(username);
        List<Account> user = accountMapper.selectByExample(example);
        if (user.size() > 0) {
            for (int i = 0; i < user.size(); i++) {
                if (user.get(i).getPassword().equals(password)) {
                    Integer posid = user.get(i).getPosid();
                    if (posid == 1) {
                        Position selPosition = dhnService.selPosition(posid);
                        session.setAttribute("Position", selPosition);
                        //账号id
                        Integer aid = user.get(i).getAid();
                        session.setAttribute("aid", aid);
                        List<UserInfo> seluserid = dhnService.seluserid(aid);
                        //用户名
                        session.setAttribute("username", seluserid.get(i).getNickname());
                        //用户id
                        session.setAttribute("userid", seluserid.get(i).getUid());
                        //班级id
                        GradeUser gradeUsers = dhnService.selGradeId(aid);
                        Integer gradeid = gradeUsers.getGradeid();
                        session.setAttribute("gradeid", gradeid);
                        return "student";
                    } else if (posid == 2) {
                        Position selPosition = dhnService.selPosition(posid);
                        session.setAttribute("Position", selPosition);
                        //账号id
                        Integer aid = user.get(i).getAid();
                        List<UserInfo> seluserid = dhnService.seluserid(aid);
                        //用户名
                        session.setAttribute("username", seluserid.get(i).getNickname());
                        //用户id
                        session.setAttribute("aid", aid);
                        session.setAttribute("userid", seluserid.get(i).getUid());
                        return "student";
                    } else if (posid == 3) {
                        Position selPosition = dhnService.selPosition(posid);
                        session.setAttribute("Position", selPosition);
                        //账号id
                        Integer aid = user.get(i).getAid();
                        List<UserInfo> seluserid = dhnService.seluserid(aid);
                        //用户名
                        session.setAttribute("username", seluserid.get(i).getNickname());
                        //用户id
                        session.setAttribute("aid", aid);
                        session.setAttribute("userid", seluserid.get(i).getUid());
                        return "student";
                    }
                }
            }
            model.addAttribute("error", "账号或密码错误");
            return "login";
        } else {
            model.addAttribute("error", "您输入的账号不存在");
            return "login";
        }
    }

    @RequestMapping("/selzuoye")
    public String tijiaozuoye(HttpSession session, Model model, HttpServletRequest request) {
        int Num = 1;
        String pn = request.getParameter("pn");
        if (pn != null) {
            Num = Integer.parseInt(pn);
        }
        Integer userid = (Integer) session.getAttribute("aid");
        GradeUser gradeUsers = dhnService.selGradeId(userid);
        //班级id
        Integer gradeid = gradeUsers.getGradeid();
        session.setAttribute("gradeid", gradeid);
        int PageSize = 3;
        PageHelper.startPage(Num, PageSize);
        List<Releasee> selwork = dhnService.selwork(gradeid, Num, PageSize);
        for (int i = 0; i < selwork.size(); i++) {
            //作业标题
            String reltitle = selwork.get(i).getReltitle();
            session.setAttribute("worktitle", reltitle);
            //作业id
            Integer rid = selwork.get(i).getRid();
            session.setAttribute("rid", rid);
            PageInfo pageInfo = new PageInfo(selwork);
            model.addAttribute("list", pageInfo);
            List<Works> selimg = dhnService.selimg();
            for (int o = 0; o < selimg.size(); o++) {
            }
        }
        return "selzuoye";
    }

    @RequestMapping("stukaoshi")
    public String stukaoshi() {
        return "stukaoshi";
    }

    @RequestMapping("/selhuifu")
    public String selhuifu(Integer rid, Model model, HttpServletRequest request) {
        int Num = 1;
        String pn = request.getParameter("pn");
        if (pn != null) {
            Num = Integer.parseInt(pn);
        }
        int PageSize = 4;
        PageHelper.startPage(Num, PageSize);
        List<Reply> selhuifu = dhnService.selhuifu(rid, Num, PageSize);
        PageInfo pageInfo = new PageInfo(selhuifu);
        model.addAttribute("list", pageInfo);
        return "huifu";
    }

    @RequestMapping("tijiao")
    public String tijiao() {
        return "tijiaozuoye";
    }

    @RequestMapping("/tijiaozuoye")
    public String tijiaozuoye(HttpSession session, MultipartFile wornei1, Works works) {
        Integer gradeid = (Integer) session.getAttribute("gradeid");
        Integer aid = (Integer) session.getAttribute("aid");
        Integer rid = (Integer) session.getAttribute("rid");
        works.setGradeid(gradeid);
        works.setUserid(aid);
        works.setRelid(rid);
        works.setWordate(new Date());
        String realPath = session.getServletContext().getRealPath("static/image");
        String originalFilename = wornei1.getOriginalFilename();
        String extension = FilenameUtils.getExtension(originalFilename);
        String newName = System.currentTimeMillis() + (RandomUtils.nextInt(10000)) + "_." + extension;
        File file = new File(realPath, newName);
        try {
            wornei1.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        works.setIsverify(0);
        works.setWorimg(newName);
        int tijiaozuoye = dhnService.tijiaozuoye(works);
        if (tijiaozuoye > 0) {
            session.setAttribute("msg", "提交成功");
        } else {
            session.setAttribute("msg", "提交失败");
        }
        return "redirect:/selzuoye";
    }

    @RequestMapping("/toChange")
    public String toChange() {
        return "changepwd";
    }

    @RequestMapping("/qiandao")
    @ResponseBody
    public Map<String, Object> qiandao(HttpSession session, Checks checks) {
        Map<String, Object> map = new HashMap<>();
        Integer aid = (Integer) session.getAttribute("aid");
        if (dhnService.getByaid(aid) != null) {
            map.put("yi", "今天已签到");
        } else {
            GradeUser gradeUsers = dhnService.selGradeId(aid);
            //班级id
            Integer gid = gradeUsers.getGradeid();
            //添加签到信息
            checks.setAid(aid);
            Date date = new Date();
            checks.setSignindate(date);
            String qiandate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            //签到时间截取小时转为int
            String indate = qiandate.substring(11, 13);
            int qianh = Integer.parseInt(indate);
            //根据班级id查询对应班级的时间表截取小时
            Timetable selgtime = dhnService.selgtime(gid);
            String gindate = selgtime.getTsignindate();
            String goutdate = selgtime.getTsignoutdate();
            //转为int
            String substring = gindate.substring(0, 2);
            int inh = Integer.parseInt(substring);
            //比较
            if (qianh < inh && qianh == inh) {
                map.put("qian", "签到成功");
                checks.setRemark("考勤成功");
                checks.setChtype(1);
            } else if (qianh > inh) {
                map.put("qian", "迟到");
                checks.setRemark("迟到");
                checks.setChtype(3);
            }
            dhnService.qiandao(checks);
        }
        return map;
    }

    @RequestMapping("/qiantui")
    @ResponseBody
    public Map<String, Object> qiantui(HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        Integer aid = (Integer) session.getAttribute("aid");
        if (dhnService.gettui(aid) != null) {
            map.put("yi", "今天已签退");
        } else {
            Checks checks = dhnService.getByaid(aid);
            GradeUser gradeUsers = dhnService.selGradeId(aid);
            //班级id
            Integer gid = gradeUsers.getGradeid();
            //添加签到信息
            Date date = new Date();
            checks.setSignoutdate(date);
            String qiandate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            //签到时间截取小时转为int
            String indate = qiandate.substring(11, 13);
            int qianh = Integer.parseInt(indate);
            //根据班级id查询对应班级的时间表截取小时
            Timetable selgtime = dhnService.selgtime(gid);
            String goutdate = selgtime.getTsignoutdate();
            //转为int
            String substring1 = goutdate.substring(0, 2);
            int outh = Integer.parseInt(substring1);
            //比较
            if (qianh > outh) {
                map.put("qian", "考勤成功");
            } else if (qianh < outh) {
                if (checks.getChtype() == 1) {
                    checks.setRemark("早退");
                    checks.setChtype(2);
                }
                map.put("qian", "早退");
            }
            dhnService.qiantui(checks);
        }
        return map;
    }

    @RequestMapping("/toqingjia")
    public String toqingjia() {
        return "qingjia";
    }

    @RequestMapping("/qingjia")
    public String qingjia(Apply apply, HttpSession session) {
        Integer aid = (Integer) session.getAttribute("aid");
        Integer gradeid = (Integer) session.getAttribute("gradeid");
        //查出本班级所有的aid
        List<GradeUser> selaid = dhnService.selaid(gradeid);
        for (int i = 0; i < selaid.size(); i++) {
            Integer userid = selaid.get(i).getUserid();
            //根据aid查职位为3的取出id
            Account selpid = dhnService.selpid(userid);
            Integer posid = selpid.getPosid();
            if (posid == 3) {
                Account selbanid = dhnService.selbanid(posid);
                //班主任id
                Integer banid = selbanid.getAid();
                apply.setAid(aid);
                apply.setTeacherid(banid);
                apply.setApptype(1);
                dhnService.qingjia(apply);
            }
        }
        return "redirect:/toqingjia";
    }
}