package com.kgc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.pojo.*;
import com.kgc.service.LoService;
import com.kgc.service.LvDongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public Map<String, Object> TeacherChaHomeWord(HttpSession session, Integer pageNum, Integer pageSize) {
        System.out.println("pageNum" + pageNum);
        System.out.println("pageSize" + pageSize);

        Map<String, Object> map = new HashMap<>();
        int aid = (int) session.getAttribute("aid");

        List<GradeUser> gradeUsers = loService.selectByUserIdd(aid);//根据id查找名下有多少个班级

        List<Releasee> releaseesZong = new ArrayList<>();
        PageInfo<Releasee> releaseePageInfo = null;
        for (int i = 0; i < gradeUsers.size(); i++) {
            releaseePageInfo = loService.selectByGradeIdd(pageNum, pageSize, gradeUsers.get(i).getGradeid());
            for (int j = 0; j < releaseePageInfo.getList().size(); j++) {
                releaseesZong.add(releaseePageInfo.getList().get(j));
            }
        }

        map.put("data", releaseePageInfo);
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
    public String stushijian(int id, Model model) {
        Map<String, Object> map = new HashMap<>();
        ExamPaper examPaper = loService.selectById(id);/*查询该试题的信息*/
        model.addAttribute("ti", examPaper);
        List<ExamItems> examItems = loService.selectByepaperid(id);/*查询所有试题*/
        model.addAttribute("examItems", examItems);
        return "testPaper";
    }

    @RequestMapping("/stupanti")
    public String stupandi(int id, Model model, HttpServletRequest request, HttpSession session) {
        int sum = 0;/*计算总分*/
        int dui = 0;/*计算对题数*/
        int cuo = 0;/*计算错题数*/
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
            useranswer.add(da);
            if (da.equals(examItems.get(i).getEkeys())) {
                System.out.println("答对了");
                sum = sum + examItems.get(i).getEscore();
                userscore.add(examItems.get(i).getEscore());
                dui++;
            }else if(da.equals("kong")){
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
        ExamScore examScore = new ExamScore(null, aid, id, sum, dui, cuo);
        int insertexamscore = loService.insertexamscore(examScore);/*将成绩数据添加到数据库*/
        System.out.println("将成绩插入ExamScoer是否成功:" + insertexamscore);
        ExamScore inserthou = loService.selectByUserIdAndPaperId(aid, id);/*查出刚才插入的成绩的实体类*/
        /*将答*/
        for (int i = 0; i < tinum.size(); i++) {
            ExamScoreDetail examScoreDetail = new ExamScoreDetail(null, inserthou.getScoreid(), tinum.get(i), useranswer.get(i), userscore.get(i));
            int insert = loService.insertExamScoreDetail(examScoreDetail);
            System.out.println("添加到ExamScoreDetail是否成功" + insert);
            System.out.println(examScoreDetail.toString());
        }
        return "redirect:/score?id="+id;
    }

    @RequestMapping("/chajiexi")
    public String chajiexi(int id, HttpSession session, Model model) {
        int aid = (int) session.getAttribute("aid");
        ExamScore examScore = loService.selectByUserIdAndPaperId(aid, id);
        List<ExamItems> examItems = loService.selectByepaperid(id);/*查询所有试题*/
        ExamPaper examPaper = loService.selectById(id);/*查询该试题的信息*/
        List<ExamScoreDetail> list = new ArrayList<>();
        for (int i = 0; i < examItems.size(); i++) {
            ExamScoreDetail examScoreDetail = loService.selectByUseridAndScoreid(examItems.get(i).getEid(), examScore.getScoreid());
            examItems.get(i).setExamScoreDetail(examScoreDetail);
            list.add(examScoreDetail);
        }
        model.addAttribute("items", examItems);
        model.addAttribute("examScore", examScore);
        model.addAttribute("examPaper",examPaper);
        return "testjiexi";
    }
    @RequestMapping("/score")
    public String score(int id, Model model, HttpSession session){
        int aid = (int) session.getAttribute("aid");
        UserInfo userInfo = loService.uiselectByUserId(aid);
        model.addAttribute("suserinfo",userInfo);
        ExamScore examScore = loService.selectByUserIdAndPaperId(aid, id);
        model.addAttribute("examScore",examScore);
        return "score";
    }
    @RequestMapping("/loSelectPaper")
    @ResponseBody
    public Map<String,Object> lvSelectPaper(Integer pageIndex,Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        PageHelper.startPage(pageIndex,pageSize);
        List<ExamPaper> examPapers = service.lvSelectPaper();
        PageInfo<ExamPaper> pageInfo=new PageInfo<>(examPapers);
        map.put("data",pageInfo);
        return map;
    }
    @RequestMapping("/chazuo")
    @ResponseBody
    public Map<String,Object> chazuo(int id,HttpSession session){
        Map<String,Object> map=new HashMap<>();
        int userid=(int)session.getAttribute("aid");
        List<ExamScore> examScores = loService.selectByUserIdAndPaperIdl(userid, id);
        if(examScores.size()>0){
            map.put("status",false);
        }else{
            map.put("status",true);
        }
        return map;
    }
    /*跳转页面*/
    @RequestMapping("/toshujutongji")
    public String toshujutongji(){
        return "ttongji";
    }
    @RequestMapping("/tofabuzuoye")
    public String tofabuzuoye(){
        return "LoClassUserInfo";
    }
    @RequestMapping("/toshitizhongxin")
    public String toshitizhongxin(){
        return "lvkaoshi";
    }
    @RequestMapping("/tofabuhomework")
    public String tofabuhomework(){
        return "LoAddHomeWork";
    }
    @RequestMapping("/tochazuoye")
    public String tochazuoye(){
        return "LoTeacherChaHomeWork";
    }
    @RequestMapping("/toaddshijuan")
    public String toaddshijuan(){
        return "lvaddkaoshi";
    }
}
