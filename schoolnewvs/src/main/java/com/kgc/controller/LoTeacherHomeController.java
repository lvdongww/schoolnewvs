package com.kgc.controller;

import com.alibaba.druid.sql.dialect.oracle.ast.OracleDataTypeIntervalYear;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.pojo.*;
import com.kgc.service.LoService;
import com.kgc.service.LvDongService;

import com.sun.corba.se.spi.ior.ObjectKey;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
public class LoTeacherHomeController {

    @Resource
    LoService loService;
    @Resource
    LvDongService service;

    @RequestMapping("/sevenday")
    /*@ResponseBody*/
    public String sevenday(Model model, int aid, HttpSession session) {
        List<GradeUser> gradeUsers = loService.selectByUserId(aid);//根据用户id查找 管理那个班级
        List<Grade> banList = new ArrayList<Grade>();
        for (int j = 0; j < gradeUsers.size(); j++) {
            List<Grade> grades = loService.selectByGradeId(gradeUsers.get(j).getGradeid());//通过班级id查找班级名字
            banList.add(grades.get(0));
        }
        session.setAttribute("banList", banList);
        //查询最近七次作业提交情况
        List<Integer> sum = new ArrayList<>();
        List<Releasee> releasees = loService.select7daycount(gradeUsers.get(0).getGradeid());

        for (int j = 0; j < releasees.size(); j++) {
            sum.add(loService.selectByRelid(releasees.get(j).getRid()).size());//查找该次作业有几名同学提交
        }
        if (sum.size() < 6) {
            for (int i = 0; i < sum.size(); i++) {
                session.setAttribute("ci" + (i + 1) + "", sum.get(sum.size() - 1));
            }
        } else {
            session.setAttribute("ci1", sum.get(6));
            session.setAttribute("ci2", sum.get(5));
            session.setAttribute("ci3", sum.get(4));
            session.setAttribute("ci4", sum.get(3));
            session.setAttribute("ci5", sum.get(2));
            session.setAttribute("ci6", sum.get(1));
            session.setAttribute("ci7", sum.get(0));
        }
        System.out.println("sum:" + sum.toString());
        return "/ttongji";
    }

    @RequestMapping("/sevendaybancha")
    /*@ResponseBody*/
    public String sevendaybancha(Model model, int aid, String baneName, HttpSession session) {
        List<GradeUser> gradeUsers = loService.selectByUserId(aid);//根据用户id查找 管理那个班级
        List<Grade> banList = new ArrayList<Grade>();
        for (int j = 0; j < gradeUsers.size(); j++) {
            List<Grade> grades = loService.selectByGradeId(gradeUsers.get(j).getGradeid());//通过班级id查找班级名字
            banList.add(grades.get(0));
        }
        session.setAttribute("banList", banList);
        //查询最近七次作业提交情况
        List<Integer> sum = new ArrayList<>();
        List<Releasee> releasees = loService.select7daycount(gradeUsers.get(0).getGradeid());

        for (int j = 0; j < releasees.size(); j++) {
            sum.add(loService.selectByRelid(releasees.get(j).getRid()).size());//查找该次作业有几名同学提交
        }
        if (sum.size() < 6) {
            for (int i = 0; i < sum.size(); i++) {
                session.setAttribute("ci" + (i + 1) + "", sum.get(sum.size() - 1));
            }
        } else {
            session.setAttribute("ci1", sum.get(6));
            session.setAttribute("ci2", sum.get(5));
            session.setAttribute("ci3", sum.get(4));
            session.setAttribute("ci4", sum.get(3));
            session.setAttribute("ci5", sum.get(2));
            session.setAttribute("ci6", sum.get(1));
            session.setAttribute("ci7", sum.get(0));
        }
        System.out.println("sum:" + sum.toString());
        return "/ttongji";
    }

    @RequestMapping("/addHomeWork")//发布作业
    @ResponseBody
    public Map<String, Object> addHomeWork(HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        int userid = (int) session.getAttribute("aid");
        List<GradeUser> gradeUsers = loService.selectByUserIdd(userid);//根据用户id查找名下有多少个班级
        List<Grade> grades = new ArrayList<>();
        for (int i = 0; i < gradeUsers.size(); i++) {
            List<Grade> grades1 = loService.selectByGid(gradeUsers.get(i).getGradeid());
            grades.add(grades1.get(grades1.size() - 1));
        }
        if (grades.size() > 0) {
            map.put("status", false);
        } else {
            map.put("status", true);
        }
        map.put("data", grades);
        return map;
    }

    @RequestMapping("/addHomeWorkOver")
    @ResponseBody
    public Map<String, Object> addHomeWorkOver(Releasee releasee) {
        Map<String, Object> map = new HashMap<>();
        releasee.setReldate(new Date());
        int i = loService.insertReleasee(releasee);
        if (i > 0) {
            map.put("status", "true");
        } else {
            map.put("status", "false");
        }
        return map;
    }

    @RequestMapping("/teacherChaHomeWork")
    @ResponseBody
    public Map<String, Object> TeacherChaHomeWord(HttpSession session, Integer pageNum, Integer pageSize,Integer banji) {
        System.out.println("pageNum" + pageNum);
        System.out.println("pageSize" + pageSize);
        Map<String, Object> map = new HashMap<>();
        int aid = (int) session.getAttribute("aid");
        List<GradeUser> gradeUsers = loService.selectByUserIdd(aid);//根据id查找名下有多少个班级
        List<Integer> gradeid=new ArrayList<>();
        for (GradeUser gradeUser : gradeUsers) {
            System.out.println(gradeUser.toString());
            gradeid.add(gradeUser.getGradeid());
        }
        PageHelper.startPage(pageNum,pageSize);
            List<Releasee> releasees = loService.selectREByGradeId(gradeid,banji);
        PageInfo<Releasee> pageInfo = new PageInfo<>(releasees);
        map.put("data", pageInfo);
        return map;
    }

    @RequestMapping("/chuanRelid")//将布置的作业id传过来 将该值赋值到session作用域 为了给chaHomeWorkXiang取值用
    @ResponseBody
    public Map<String, Object> chuanRelid(int relid, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        session.setAttribute("relid", relid);
        return map;
    }

    @RequestMapping("/chaHomeWorkXiang")
    @ResponseBody
    public Map<String, Object> chaHomeWorkXiang(HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        int relid = (int) session.getAttribute("relid");
        System.out.println(relid);
        List<Works> works = loService.selecyByRelId(relid);
        for (Works work : works) {
            System.out.println(work.toString());
        }
        map.put("data", works);
        return map;
    }

    @RequestMapping("/teacherShenChaHomeWork")
    @ResponseBody
    public Map<String, Object> teacherShenChaHomeWork(int id) {
        Map<String, Object> map = new HashMap<>();
        Works works = new Works(id, 2);
        int i = loService.updateWorksIsverify(works);
        if (i > 0) {
            map.put("status", "true");
        } else {
            map.put("status", "false");
        }
        return map;
    }

    @RequestMapping("/chuanWid")
    @ResponseBody
    public Map<String, Object> chuanWid(int wid, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        session.setAttribute("wid", wid);
        return map;
    }

    @RequestMapping("/teacherAddHuiFu")
    @ResponseBody
    public Map<String, Object> teacherAddHuiFu(String neirong, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        int wid = (int) session.getAttribute("wid");
        Reply reply = new Reply(wid, neirong);
        int i = loService.insertReply(reply);
        if (i > 0) {
            map.put("status", "true");
        } else {
            map.put("status", "false");
        }
        return map;
    }

    /*试卷系统*/
    @RequestMapping("/stushijuan")
    /*@ResponseBody*/
    public String stushijian(int id, int papergrade, Model model, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        session.setAttribute("dangqianshijuanid", id);
        session.setAttribute("papergrade", papergrade);/*当前papergrade的pgid*/
        ExamPaper examPaper = loService.selectById(id);/*查询该试题的信息*/
        model.addAttribute("ti", examPaper);
        List<ExamItems> examItems = loService.selectByepaperid(id);/*查询所有试题*/
        List<ExamItems> xuanze = new ArrayList<>();//记录所有选择题
        int xuanzeScore = 0;//记录选择题的总分
        List<ExamItems> panduan = new ArrayList<>();//记录所有判断题
        int panduanScore = 0;//记录判断题的总分
        for (ExamItems examItem : examItems) {
            if (examItem.getEtype() == 3) {
                xuanze.add(examItem);
                xuanzeScore += examItem.getEscore();
            }
            if (examItem.getEtype() == 2) {
                panduan.add(examItem);
                panduanScore += examItem.getEscore();
            }
        }
        /*选择题*/
        model.addAttribute("xuanze", xuanze);
        model.addAttribute("xuanzeSize", xuanze.size());
        model.addAttribute("xuanzeScore", xuanzeScore);
        /*判断题*/
        model.addAttribute("panduan", panduan);
        model.addAttribute("panduanSize", panduan.size());
        model.addAttribute("panduanScore", panduanScore);
        return "/dostukaoshi";
    }

    /*试卷系统*/
    @RequestMapping("/tikustushijuan")
    /*@ResponseBody*/
    public String tikustushijian(int id, Model model, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        session.setAttribute("dangqiantikushijuanid", id);
        ExamPaper examPaper = loService.selectById(id);/*查询该试题的信息*/
        model.addAttribute("ti", examPaper);
        List<ExamItems> examItems = loService.selectByepaperid(id);/*查询所有试题*/
        List<ExamItems> xuanze = new ArrayList<>();//记录所有选择题
        int xuanzeScore = 0;//记录选择题的总分
        List<ExamItems> panduan = new ArrayList<>();//记录所有判断题
        int panduanScore = 0;//记录判断题的总分
        for (ExamItems examItem : examItems) {
            if (examItem.getEtype() == 3) {
                xuanze.add(examItem);
                xuanzeScore += examItem.getEscore();
            }
            if (examItem.getEtype() == 2) {
                panduan.add(examItem);
                panduanScore += examItem.getEscore();
            }
        }
        /*选择题*/
        model.addAttribute("xuanze", xuanze);
        model.addAttribute("xuanzeSize", xuanze.size());
        model.addAttribute("xuanzeScore", xuanzeScore);
        /*判断题*/
        model.addAttribute("panduan", panduan);
        model.addAttribute("panduanSize", panduan.size());
        model.addAttribute("panduanScore", panduanScore);
        return "/dotikukaoshi";
    }

    /*交卷前最后一次验证为空的题*/
    @RequestMapping("/stushijuantijiao")
    @ResponseBody
    public Map<String, Object> stushijuantijiao(Model model, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        int id = (int) session.getAttribute("dangqianshijuanid");
        ExamPaper examPaper = loService.selectById(id);/*查询该试题的信息*/
        model.addAttribute("ti", examPaper);
        List<ExamItems> examItems = loService.selectByepaperid(id);/*查询所有试题*/
        map.put("data", examItems);
        return map;
    }

    /*交卷前最后一次验证为空的题*/
    @RequestMapping("/tikushijuantijiao")
    @ResponseBody
    public Map<String, Object> tikushijuantijiao(Model model, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        int id = (int) session.getAttribute("dangqiantikushijuanid");
        ExamPaper examPaper = loService.selectById(id);/*查询该试题的信息*/
        model.addAttribute("ti", examPaper);
        List<ExamItems> examItems = loService.selectByepaperid(id);/*查询所有试题*/
        map.put("data", examItems);
        return map;
    }

    /* @RequestMapping("/stupanti")
     public String stupandi( Model model, HttpServletRequest request, HttpSession session) {
         int sum = 0;*//*计算总分*//*
        int dui = 0;*//*计算对题数*//*
        int cuo = 0;*//*计算错题数*//*
        int id=(int)session.getAttribute("dangqianshijuanid");
        List<String> useranswer = new ArrayList<>();*//*记录用户的答案*//*
        List<Integer> userscore = new ArrayList<>();*//*记录用户的成绩*//*
        List<Integer> tinum = new ArrayList<>();*//*记录题号的成绩*//*

        ExamPaper examPaper = loService.selectById(id);*//*查询该试题的信息*//*
        List<ExamItems> examItems = loService.selectByepaperid(id);*//*查询所有试题*//*
        System.out.println("提交的答案");
        for (int i = 0; i < examItems.size(); i++) {
            System.out.println("题号" + examItems.get(i).getEid() + "，答案是" + examItems.get(i).getEkeys());
            tinum.add(examItems.get(i).getEid());
            String da = request.getParameter("" + examItems.get(i).getEid() + "");
            System.out.println("您的答案是" + da);
            useranswer.add(da);
            if (da.equals(examItems.get(i).getEkeys())) {
                System.out.println("答对了");
                sum = sum + examItems.get(i).getEscore();
                userscore.add(examItems.get(i).getEscore());
                dui++;
            } else if (da.equals("kong")) {
                System.out.println("不能为空");
                sum = sum + 0;
                userscore.add(0);
                cuo++;
            } else {
                System.out.println("答错了");
                sum = sum + 0;
                userscore.add(0);
                cuo++;
            }
            System.out.println("现在的成绩是" + sum);
            System.out.println("错题" + cuo);
            System.out.println("对题" + dui);
            System.out.println("============");
        }
        int aid = (int) session.getAttribute("aid");
        ExamScore examScore = new ExamScore();
        int insertexamscore = loService.insertexamscore(examScore);*//*将成绩数据添加到数据库*//*
        System.out.println("将成绩插入ExamScoer是否成功:" + insertexamscore);
        ExamScore inserthou = loService.selectByUserIdAndPaperId(aid, id);*//*查出刚才插入的成绩的实体类*//*
     *//*将答*//*
        for (int i = 0; i < tinum.size(); i++) {
            ExamScoreDetail examScoreDetail = new ExamScoreDetail(null, inserthou.getScoreid(), tinum.get(i), useranswer.get(i), userscore.get(i));
            int insert = loService.insertExamScoreDetail(examScoreDetail);
            System.out.println("添加到ExamScoreDetail是否成功" + insert);
            System.out.println(examScoreDetail.toString());
        }
        return "redirect:/score?id=" + id;
    }*/
    /*老师布置任务*/
    @RequestMapping("/gradestupanti")
    public String gradestupanti(Model model, HttpServletRequest request, HttpSession session) {
        int sum = 0;/*计算总分*/
        int dui = 0;/*计算对题数*/
        int cuo = 0;/*计算错题数*/
        int id = (int) session.getAttribute("dangqianshijuanid");/*获取当前试题id*/
        List<String> useranswer = new ArrayList<>();/*记录用户的答案*/
        List<Integer> userscore = new ArrayList<>();/*记录用户的成绩*/
        List<Integer> tinum = new ArrayList<>();/*记录题号的成绩*/

        ExamPaper examPaper = loService.selectById(id);/*查询该试题的信息*/
        List<ExamItems> examItems = loService.selectByepaperid(id);/*查询所有试题*/
        System.out.println("提交的答案");
        for (int i = 0; i < examItems.size(); i++) {
            System.out.println("题号" + examItems.get(i).getEid() + "，答案是" + examItems.get(i).getEkeys());
            tinum.add(examItems.get(i).getEid());
            String da = request.getParameter("" + examItems.get(i).getEid() + "");
            System.out.println("您的答案是" + da);
            if (da == null) {
                useranswer.add("未作答");
            } else {
                useranswer.add(da);
            }
            if (da == null) {
                System.out.println("答错了 不能为空");
                sum = sum + 0;
                userscore.add(0);
                cuo++;
            } else if (da.equals(examItems.get(i).getEkeys())) {
                System.out.println("答对了");
                sum = sum + examItems.get(i).getEscore();
                userscore.add(examItems.get(i).getEscore());
                dui++;
            } else {
                System.out.println("答错了");
                sum = sum + 0;
                userscore.add(0);
                cuo++;
            }

            System.out.println("现在的成绩是" + sum);
            System.out.println("错题" + cuo);
            System.out.println("对题" + dui);
            System.out.println("============");
        }

        int aid = (int) session.getAttribute("aid");/*获取当前用户id*/
        int papergrade = (int) session.getAttribute("papergrade");
        ExamScore examScore = new ExamScore(null, aid, id, papergrade, sum, dui, cuo, new Date());
        int insertexamscore = loService.insertexamscore(examScore);/*将成绩数据添加到数据库*/
        System.out.println("将成绩插入ExamScoer是否成功:" + insertexamscore);
        ExamScore inserthou = loService.selectByUserIdAndPaperId(aid, id, papergrade);/*查出刚才插入的成绩的实体类*/
        /*将答*/
        for (int i = 0; i < tinum.size(); i++) {
            ExamScoreDetail examScoreDetail = new ExamScoreDetail(null, inserthou.getScoreid(), tinum.get(i), useranswer.get(i), userscore.get(i));
            int insert = loService.insertExamScoreDetail(examScoreDetail);
            System.out.println("添加到ExamScoreDetail是否成功" + insert);
            System.out.println(examScoreDetail.toString());
        }
        model.addAttribute("dangqianshijuanid", id);
        session.setAttribute("dangqiankaoshichengji", sum);
        return "redirect:/score";
    }

    @RequestMapping("/tikupanti")
    public String tikupanti(Model model, HttpServletRequest request, HttpSession session) {
        int sum = 0;/*计算总分*/
        int dui = 0;/*计算对题数*/
        int cuo = 0;/*计算错题数*/
        int id = (int) session.getAttribute("dangqiantikushijuanid");/*获取当前试题id*/
        List<String> useranswer = new ArrayList<>();/*记录用户的答案*/
        List<Integer> userscore = new ArrayList<>();/*记录用户的成绩*/
        List<Integer> tinum = new ArrayList<>();/*记录题号的成绩*/

        ExamPaper examPaper = loService.selectById(id);/*查询该试题的信息*/
        List<ExamItems> examItems = loService.selectByepaperid(id);/*查询所有试题*/
        System.out.println("提交的答案");
        for (int i = 0; i < examItems.size(); i++) {
            System.out.println("题号" + examItems.get(i).getEid() + "，答案是" + examItems.get(i).getEkeys());
            tinum.add(examItems.get(i).getEid());
            String da = request.getParameter("" + examItems.get(i).getEid() + "");
            System.out.println("您的答案是" + da);
            if (da == null) {
                useranswer.add("未作答");
            } else {
                useranswer.add(da);
            }
            if (da == null) {
                System.out.println("答错了 不能为空");
                sum = sum + 0;
                userscore.add(0);
                cuo++;
            } else if (da.equals(examItems.get(i).getEkeys())) {
                System.out.println("答对了");
                sum = sum + examItems.get(i).getEscore();
                userscore.add(examItems.get(i).getEscore());
                dui++;
            } else {
                System.out.println("答错了");
                sum = sum + 0;
                userscore.add(0);
                cuo++;
            }

            System.out.println("现在的成绩是" + sum);
            System.out.println("错题" + cuo);
            System.out.println("对题" + dui);
            System.out.println("============");
        }
        int aid = (int) session.getAttribute("aid");/*获取当前用户id*/
        ExamScore examScore = new ExamScore(null, aid, id, sum, dui, cuo, new Date());
        System.out.println("!!!" + examScore.toString());
        int insertexamscore = loService.insertexamscore(examScore);/*将成绩数据添加到数据库*/
        System.out.println("将成绩插入ExamScoer是否成功:" + insertexamscore);
        ExamScore inserthou = loService.selectByUserIdAndPaperId(aid, id, -1);/*查出刚才插入的成绩的实体类*/
        /*将答*/
        for (int i = 0; i < tinum.size(); i++) {
            ExamScoreDetail examScoreDetail = new ExamScoreDetail(null, inserthou.getScoreid(), tinum.get(i), useranswer.get(i), userscore.get(i));
            int insert = loService.insertExamScoreDetail(examScoreDetail);
            System.out.println("添加到ExamScoreDetail是否成功" + insert);
            System.out.println(examScoreDetail.toString());
        }
        model.addAttribute("dangqianshijuanid", id);
        session.setAttribute("dangqiankaoshichengji", sum);
        return "redirect:/tikuscore?id=" + id;
    }

    @RequestMapping("/chajiexi")
    public String chajiexi(HttpSession session, Model model) {
        int id = (int) session.getAttribute("dangqianshijuanid");
        int aid = (int) session.getAttribute("aid");
        int papergrade = (int) session.getAttribute("papergrade");
        ExamScore examScore = loService.selectByUserIdAndPaperId(aid, id, papergrade);
        List<ExamItems> examItems = loService.selectByepaperid(id);/*查询所有试题*/
        ExamPaper examPaper = loService.selectById(id);/*查询该试题的信息*/
        List<ExamScoreDetail> list = new ArrayList<>();
        for (int i = 0; i < examItems.size(); i++) {
            ExamScoreDetail examScoreDetail = loService.selectByUseridAndScoreid(examItems.get(i).getEid(), examScore.getScoreid());
            examItems.get(i).setExamScoreDetail(examScoreDetail);
            examItems.get(i).setTiNum(i + 1);
            list.add(examScoreDetail);
        }
        model.addAttribute("items", examItems);/*查询所有试题*/
        model.addAttribute("examScore", examScore);/*查询这个考试score表里的信息*/
        model.addAttribute("examPaper", examPaper);/*查询该试题的信息*/
        return "testjiexi";
    }

    @RequestMapping("/tikuchajiexi")/*题库查解析*/
    public String chajiexi(int id, HttpSession session, Model model) {
        int aid = (int) session.getAttribute("aid");
        ExamScore examScore = loService.selectByUserIdAndPaperId(aid, id, -1);
        List<ExamItems> examItems = loService.selectByepaperid(id);/*查询所有试题*/
        ExamPaper examPaper = loService.selectById(id);/*查询该试题的信息*/
        List<ExamScoreDetail> list = new ArrayList<>();
        for (int i = 0; i < examItems.size(); i++) {
            ExamScoreDetail examScoreDetail = loService.selectByUseridAndScoreid(examItems.get(i).getEid(), examScore.getScoreid());
            examItems.get(i).setExamScoreDetail(examScoreDetail);
            examItems.get(i).setTiNum(i + 1);
            list.add(examScoreDetail);
        }
        model.addAttribute("items", examItems);/*查询所有试题*/
        model.addAttribute("examScore", examScore);/*查询这个考试score表里的信息*/
        model.addAttribute("examPaper", examPaper);/*查询该试题的信息*/
        return "testjiexi";
    }

    @RequestMapping("/tikuchajiexiyouse")/*题库查解析*/
    public String tikuchajiexiyouse(HttpSession session, Model model) {
        int aid = (int) session.getAttribute("aid");
        int id = (int) session.getAttribute("dangqiantikushijuanid");
        ExamScore examScore = loService.selectByUserIdAndPaperId(aid, id, -1);
        List<ExamItems> examItems = loService.selectByepaperid(id);/*查询所有试题*/
        ExamPaper examPaper = loService.selectById(id);/*查询该试题的信息*/
        List<ExamScoreDetail> list = new ArrayList<>();
        for (int i = 0; i < examItems.size(); i++) {
            ExamScoreDetail examScoreDetail = loService.selectByUseridAndScoreid(examItems.get(i).getEid(), examScore.getScoreid());
            examItems.get(i).setExamScoreDetail(examScoreDetail);
            examItems.get(i).setTiNum(i + 1);
            list.add(examScoreDetail);
        }
        model.addAttribute("items", examItems);/*查询所有试题*/
        model.addAttribute("examScore", examScore);/*查询这个考试score表里的信息*/
        model.addAttribute("examPaper", examPaper);/*查询该试题的信息*/
        return "tikujiexi";
    }

    @RequestMapping("/chajiexiwei")/*没有提前获取id(试卷)的时候*/
    public String chajiexiwei(Integer id, HttpSession session, Model model, int papergrade) {
        int aid = (int) session.getAttribute("aid");
        session.setAttribute("dangqianshijuanid", id);
        session.setAttribute("papergrade", papergrade);/*当前papergrade的pgid*/
        ExamScore examScore = loService.selectByUserIdAndPaperId(aid, id, papergrade);
        List<ExamItems> examItems = loService.selectByepaperid(id);/*查询所有试题*/
        ExamPaper examPaper = loService.selectById(id);/*查询该试题的信息*/
        List<ExamScoreDetail> list = new ArrayList<>();
        for (int i = 0; i < examItems.size(); i++) {
            ExamScoreDetail examScoreDetail = loService.selectByUseridAndScoreid(examItems.get(i).getEid(), examScore.getScoreid());
            examItems.get(i).setExamScoreDetail(examScoreDetail);
            examItems.get(i).setTiNum(i + 1);
            list.add(examScoreDetail);
        }
        model.addAttribute("items", examItems);/*查询所有试题*/
        model.addAttribute("examScore", examScore);/*查询这个考试score表里的信息*/
        model.addAttribute("examPaper", examPaper);/*查询该试题的信息*/
        return "testjiexi";
    }

    @RequestMapping("/score")
    public String score(Model model, HttpSession session) {
        int aid = (int) session.getAttribute("aid");
        int id = (int) session.getAttribute("dangqianshijuanid");
        UserInfo userInfo = loService.uiselectByUserId(aid);
        model.addAttribute("suserinfo", userInfo);
        int papergrade = (int) session.getAttribute("papergrade");
        ExamScore examScore = loService.selectByUserIdAndPaperId(aid, id, papergrade);
        model.addAttribute("examScore", examScore);
        return "score";
    }

    @RequestMapping("/tikuscore")
    public String score(int id, Model model, HttpSession session) {
        int aid = (int) session.getAttribute("aid");
        UserInfo userInfo = loService.uiselectByUserId(aid);
        model.addAttribute("suserinfo", userInfo);
        ExamScore examScore = loService.selectByUserIdAndPaperId(aid, id, -1);
        model.addAttribute("examScore", examScore);
        return "/tikuscore";
    }

    @RequestMapping("/tikuscoreyouse")
    public String tikuscoreyouse(Model model, HttpSession session) {
        int id = (int) session.getAttribute("dangqiantikushijuanid");
        int aid = (int) session.getAttribute("aid");
        UserInfo userInfo = loService.uiselectByUserId(aid);
        model.addAttribute("suserinfo", userInfo);
        ExamScore examScore = loService.selectByUserIdAndPaperId(aid, id, -1);
        model.addAttribute("examScore", examScore);
        return "/tikuscore";
    }

    @RequestMapping("/loSelectPaper")
    @ResponseBody
    public Map<String, Object> lvSelectPaper(Integer pageIndex, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageIndex, pageSize);
        List<ExamPaper> examPapers = service.lvSelectPaper();
        PageInfo<ExamPaper> pageInfo = new PageInfo<>(examPapers);
        map.put("data", pageInfo);
        return map;
    }

    @RequestMapping("/chazuo")
    @ResponseBody
    public Map<String, Object> chazuo(int id, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        int userid = (int) session.getAttribute("aid");
        List<ExamScore> examScores = loService.selectByUserIdAndPaperIdl(userid, id);
        if (examScores.size() > 0) {
            map.put("status", false);
        } else {
            map.put("status", true);
        }
        return map;
    }

    /*完善*/
    @RequestMapping("/loSelectTiKu")
    @ResponseBody
    public Map<String, Object> loSelectTiKu(Integer pageNum, Integer pageSize, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        int userid = (int) session.getAttribute("aid");/*获取当前用户id*/
        PageHelper.startPage(pageNum, pageSize);
        List<ExamPaper> examPapers = loService.loSelectPaper();/*读取题库里的所有信息*/

        for (ExamPaper examPaper : examPapers) {
            List<ExamScore> examScores = loService.selectByUserIdAndPaperIdl(userid, examPaper.getPaperid());
            examPaper.setScoreList(examScores);
        }
        PageInfo<ExamPaper> pageInfo = new PageInfo<>(examPapers);
        map.put("data", pageInfo);
        return map;
    }

    @RequestMapping("/toDoWorkHistory")/*跳转查询历史做题记录页面*/
    public String toDoWorkHistory() {
        return "stuDoWorkHistory";
    }

    @RequestMapping("/toDoWorkHistoryChuanZhi")/*接收试卷的值*/
    @ResponseBody
    public Map<String, Object> toDoWorkHistoryChuanZhi(int paperid, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        session.setAttribute("HistoryPaperId", paperid);
        map.put("status", true);
        return map;
    }

    @RequestMapping("/chaDoWorkHistoryChuanZhi")/*查询接收过来试卷值的历史做题记录*/
    @ResponseBody
    public Map<String, Object> chaDoWorkHistoryChuanZhi(Integer pageNum, Integer pageSize, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        int parperid = (int) session.getAttribute("HistoryPaperId");
        int userid = (int) session.getAttribute("aid");
        List<ExamScore> examScores = loService.selectByUserIdAndPaperIdAndPaperUserInfo(userid, parperid);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<ExamScore> pageInfo = new PageInfo<>(examScores);
        map.put("data", pageInfo);
        return map;
    }

    @RequestMapping("banjiceshi")
    public String banjiceshi(HttpSession session) {
        int userid = (int) session.getAttribute("aid");
        GradeUser gradeUser = loService.selectGradeUserByUserId(userid);/*根据用户id查找属于内个班级*/
        Grade gradeuserinfo = loService.selcetByGradeId(gradeUser.getGradeid());//根据班级id查找详细信息
        session.setAttribute("gradeuserinfo", gradeuserinfo);
        return "gradekaoshi";
    }

    @RequestMapping("/dobanjiceshi")
    @ResponseBody
    public Map<String, Object> banjiceshi(HttpSession session, Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", defaultValue = "3") Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        int userid = (int) session.getAttribute("aid");
        GradeUser gradeUser = loService.selectGradeUserByUserId(userid);/*根据用户id查找属于内个班级*/
        Grade gradeuserinfo = loService.selcetByGradeId(gradeUser.getGuid());//根据班级id查找详细信息
        List<PaperGrade> paperGrade = loService.selectPGByGradeId(gradeUser.getGradeid());/*查询该班级下所有的题*/
        List<ExamPaper> zong = new ArrayList<>();/*记录所有的题的详细信息*/
        PageHelper.startPage(pageNum, pageSize);
        map.put("status", false);
        if (paperGrade.size() > 0) {
            for (PaperGrade grade : paperGrade) {
                ExamPaper examPaper = loService.selectById(grade.getPid());
                examPaper.setPaperGrade(grade);
                zong.add(examPaper);
            }
            map.put("status", true);
        }
        PageInfo<ExamPaper> pageInfo = new PageInfo<>(zong);
        map.put("data", pageInfo);
        return map;
    }

    @RequestMapping("/gradetestpanduan")
    @ResponseBody
    public Map<String, Object> gradetestpanduan(HttpSession session, Integer paperid, Integer pgid) {
        Map<String, Object> map = new HashMap<>();
        int userid = (int) session.getAttribute("aid");
        ExamScore examScore = loService.selectByUserIdPaperIdPgid(userid, paperid, pgid);
        if (examScore != null) {
            map.put("status", false);
        } else {
            map.put("status", true);
        }
        return map;
    }


    /*教员功能*/
    @RequestMapping("/addGradeTest")
    @ResponseBody
    public Map<String, Object> addGradeTest(Integer pid, Integer gid, String startTime, String stopTime) {
        Map<String, Object> map = new HashMap<>();
        /*转换时间类型*/
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String kai = startTime;
        String jie = stopTime;
        Date kk = new Date(kai);
        Date jj = new Date(jie);
        System.out.println(format.format(kk));
        System.out.println(format.format(jj));
        /*赋值*/
        PaperGrade paperGrade = new PaperGrade(pid, gid, kk, jj, 0);
        /*添加数据库数据*/
        int insert = loService.insertPaperGrade(paperGrade);
        if (insert > 0) {
            map.put("status", true);
        } else {
            map.put("status", false);
        }
        System.out.println(paperGrade.toString());
        return map;
    }

    @RequestMapping("/chaTeacherBuZhiGradeTest")
    @ResponseBody
    public Map<String, Object> chaTeacherBuZhiGradeTest(HttpSession session, @RequestParam(name = "grade", defaultValue = "0") Integer grade, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", defaultValue = "3") Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        int userid = (int) session.getAttribute("aid");
        PageHelper.startPage(pageNum, pageSize);
        if (grade == 0) {
            List<GradeUser> gradeUsers = loService.selectByUserIdd(userid);
            if (gradeUsers.size() < 0) {
            } else {
                List<PaperGrade> zong = new ArrayList<>();
                for (GradeUser gradeUser : gradeUsers) {
                    List<PaperGrade> paperGrades = loService.selectPGByGradeId(gradeUser.getGradeid());
                    for (PaperGrade paperGrade : paperGrades) {
                        List<Grade> grades = loService.selectByGid(paperGrade.getGid());
                        paperGrade.setGrade(grades.get(0));
                        ExamPaper examPaper = loService.selectById(paperGrade.getPid());
                        paperGrade.setExamPaper(examPaper);
                        zong.add(paperGrade);
                    }
                }
                PageInfo<PaperGrade> pageInfo = new PageInfo<>(zong);
                map.put("data", pageInfo);
            }
        } else {
            List<PaperGrade> zong = new ArrayList<>();
            List<PaperGrade> paperGrades = loService.selectPGByGradeId(grade);
            for (PaperGrade paperGrade : paperGrades) {
                List<Grade> grades = loService.selectByGid(paperGrade.getGid());
                paperGrade.setGrade(grades.get(0));
                ExamPaper examPaper = loService.selectById(paperGrade.getPid());
                paperGrade.setExamPaper(examPaper);
                zong.add(paperGrade);
            }
            PageInfo<PaperGrade> pageInfo = new PageInfo<>(zong);
            map.put("data", pageInfo);
        }
        return map;
    }

    @RequestMapping("/chakaoshixiang")
    public String chakaoshixiang(Integer pgid, Model model) {
        System.out.println("pgid" + pgid);
        List<ExamScore> examScores = loService.selectByPGid(pgid);//根据papergradeid查找examscore表中的提交人员
        for (ExamScore examScore : examScores) {
            UserInfo userInfo = loService.uiselectByUserId(examScore.getUserid());
            examScore.setUserInfo(userInfo);
        }
        PaperGrade paperGrade = loService.selectBypgid(pgid);/*查找该papergrade的数据*/
        System.out.println("papergrade" + paperGrade.toString());
        List<GradeUser> gradeUsers = loService.selectGUbyGradeId(paperGrade.getGid());/*根据班级id查找班里的所有学生*/
        model.addAttribute("zongrenshu", gradeUsers.size());/*记录总人数*/
        for (GradeUser gradeUser : gradeUsers) {
            UserInfo userInfo = loService.uiselectByUserId(gradeUser.getUserid());
            gradeUser.setUserInfo(userInfo);
        }
        for (int i = 0; i < examScores.size(); i++) {
            if (examScores.get(i).getUserid() == gradeUsers.get(i).getUserid()) {
                gradeUsers.remove(i);
            }
        }
        List<Integer> userid=new ArrayList<>();
        for (int i = 0; i <examScores.size() ; i++) {/*将已经完成的同学在没完成的list中删除*/
            userid.add(examScores.get(i).getUserid());
            /*System.out.println(examScores.get(i).getUserid());*/
        }
        System.out.println("======");
        for (int i = 0; i <userid.size() ; i++) {
            for (int j = 0; j <gradeUsers.size() ; j++) {
                System.out.println("mei"+gradeUsers.get(j).getUserid()+":wan"+userid.get(i));
                if(gradeUsers.get(j).getUserid()==userid.get(i)){
                    gradeUsers.remove(j);
                    /*System.out.println("删除了"+gradeUsers.get(i).getUserid());*/
                }
            }
        }
        model.addAttribute("meicheng", gradeUsers);
        model.addAttribute("meirenshu", gradeUsers.size());
        System.out.println("meicheng" + gradeUsers.toString());
        model.addAttribute("wancheng", examScores);
        model.addAttribute("wanrenshu", examScores.size());
        System.out.println("wancheng" + examScores.toString());
        return "kaoshixiangqing";
    }

    @RequestMapping("/chaHomeWorkTiJiaoQingKuang")
    public String chaHomeWorkTiJiaoQingKuang(Integer gradeid, Model model) {
        List<Releasee> releasees = loService.selectByREGradeId(gradeid);/*查询出该班级的所有作业*/
        model.addAttribute("zuoye", releasees);
        List<GradeUser> gradeUsers = loService.selectGUbyGradeId(gradeid);/*查出这个班所有的学生*/
        for (int i = 0; i < gradeUsers.size(); i++) {
            List<Integer> zong = new ArrayList<>();
            for (int j = 0; j < releasees.size(); j++) {
                List<Works> works = loService.selectByRelid(releasees.get(j).getRid(), gradeUsers.get(i).getUserid());
                if (works.size() > 0) {
                    zong.add(1);
                    gradeUsers.get(i).setList(zong);
                } else {
                    zong.add(0);
                    gradeUsers.get(i).setList(zong);
                }
            }
        }
        model.addAttribute("xuesheng", gradeUsers);
        for (GradeUser gradeUser : gradeUsers) {
            UserInfo userInfo = loService.uiselectByUserId(gradeUser.getUserid());
            gradeUser.setUserInfo(userInfo);
            System.out.println(gradeUser.toString());
        }
        return "HomeWorkTiJiaoQingKuang";
    }

    @RequestMapping("/chaZuoXiShiJian")
    @ResponseBody
    public Map<String,Object> chaZuoXiShiJian(HttpSession session, @RequestParam(name = "grade", defaultValue = "0") Integer grade, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", defaultValue = "3") Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Map<String, Object> map=new HashMap<>();
        int userid=(int)session.getAttribute("aid");
        List<GradeUser> gradeUsers = loService.selectByUserIdd(userid);
        if(gradeUsers.size()<=0){
            map.put("data",null);
        }else{
            List<Integer> zhi=new ArrayList<>();
            for (GradeUser gradeUser : gradeUsers) {
                zhi.add(gradeUser.getGradeid());
            }
            List<Timetable> timetables = loService.selectByGradeId(zhi,grade);
            PageInfo<Timetable> pageInfo = new PageInfo<>(timetables);
           map.put("data",pageInfo);
        }
        return map;
    }
    @RequestMapping("/xiutimetable")
    public String xiutimetable(int tiz,Model model){
        if(tiz==-1){
            model.addAttribute("lei","-1");
            System.out.println("-1");
        }else{
            Timetable timetable = loService.selectByTid(tiz);
            model.addAttribute("zhi",timetable);
            System.out.println("1");
        }
        return "updateZuoXiShiJian";
    }
    @RequestMapping("/overXiuTimeTable")
    @ResponseBody
    public Map<String,Object> overXiuTimeTable(Timetable timetable){
        Map<String,Object> map=new HashMap<>();
        int i = loService.updateTimeTable(timetable);
        if(i>0){
            map.put("status",true);
        }else{
            map.put("status",false);
        }
        return map;
    }
    @RequestMapping("/addXiuTimeTable")
    @ResponseBody
    public Map<String,Object> addXiuTimeTable(Timetable timetable){
        Map<String,Object> map=new HashMap<>();
        List<Timetable> timetable1 = loService.selectByGGid(timetable.getGid());
        int i =0;
        if(timetable1.size()<=0){
             i = loService.insertTimeTable(timetable);
            if(i>0){
                map.put("status",true);
            }
        }
        if(i<=0){
            map.put("status",false);
        }
        return map;
    }

    /*跳转页面*/
    @RequestMapping("/toshujutongji")
    public String toshujutongji() {
        return "ttongji";
    }

    @RequestMapping("/tofabuzuoye")
    public String tofabuzuoye() {
        return "LoClassUserInfo";
    }

    @RequestMapping("/toshitizhongxin")
    public String toshitizhongxin() {
        return "lvkaoshi";
    }

    @RequestMapping("/tofabuhomework")
    public String tofabuhomework() {
        return "LoAddHomeWork";
    }

    @RequestMapping("/tochazuoye")
    public String tochazuoye() {
        return "LoTeacherChaHomeWork";
    }

    @RequestMapping("/toaddshijuan")
    public String toaddshijuan() {
        return "lvaddkaoshi";
    }

    @RequestMapping("/tozhuye")
    public String tozhuye() {
        return "student";
    }

    @RequestMapping("/teacherbuzhikaoshi")
    public String teacherbuzhikaoshi() {
        return "teacherbuzhikaoshi";
    }

    @RequestMapping("/toteacherBuZhi")
    public String toteacherBuZhi() {
        return "teacherBuZhi";
    }

    @RequestMapping("/toHomeWorkTiJiaoQingKuang")
    public String toHomeWorkTiJiaoQingKuang() {
        return "HomeWorkTiJiaoQingKuang";
    }

    @RequestMapping("/toTeacherChaZuoYeXiShiJian")
    public String toTeacherChaZuoYeXiShiJian() {
        return "teacherChaZuoXishiJian";
    }
    @RequestMapping("/toaddZuoXiShiJian")
    public String toaddZuoXiShiJian(){
        return "addZuoXiShiJian";
    }

    /*测试*/
    @RequestMapping("/tostukaoshi")
    public String tostukaoshi() {
        return "stukaoshi";
    }

    @RequestMapping("/todostukaoshi")
    public String todostukaoshi() {
        return "dostukaoshi";
    }


}
