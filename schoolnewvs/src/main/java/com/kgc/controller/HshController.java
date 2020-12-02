package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.pojo.*;
import com.kgc.service.HshService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author shkstart
 * @create 2020-10-17 11:35
 */
@Controller
public class HshController {
    @Resource
    HshService hshService;

    @RequestMapping("/hshsel2")
    @ResponseBody
    public Map<String, Object> hshsel2() {
        Map<String, Object> map = new HashMap<>();
        List<UserInfo> hshsunm = hshService.hshsunm();
        System.out.println(hshsunm);
        map.put("selsum", hshsunm);
        return map;
    }
    @RequestMapping("/hshsel3")
    @ResponseBody
    public Map<String, Object> hshsel3(Integer gid) {
        Map<String, Object> map = new HashMap<>();
        return map;
    }
    @RequestMapping("/chuangid")
    public String chuanid( Integer id, HttpSession session){
        session.setAttribute("gid",id);
        System.out.println("id"+id);
        return "renyuan";
    }
    @RequestMapping("/selgbyu")
    @ResponseBody
    public Map<String, Object> selgbyu(Integer gid) {
        Map<String, Object> map = new HashMap<>();
        List<GradeUser> hshselg = hshService.hshselg(gid);
        List<GradeUser> hshselg1=new ArrayList<>();
        for (GradeUser gradeUser : hshselg) {
            Account aid=hshService.selhh(gradeUser.getUserid());
            if (aid.getPosid()==1){
                GradeUser gradeUser1=new GradeUser();
                gradeUser1.setGradeid(gid);
                gradeUser1.setUserid(aid.getAid());
                hshselg1.add(gradeUser1);
            }
        }
        map.put("hshselg",hshselg1);
        return map;
    }
    @RequestMapping("/selinfo")
    @ResponseBody
    public Map<String, Object> selinfo(Integer pageindex,Integer  pagesize,Integer gid,String name,Integer utype) {
        Map<String, Object> map = new HashMap<>();
        PageInfo<UserInfo> selfenye = hshService.selfenye(pageindex, pagesize, gid, name,utype,1);
        map.put("selfenye",selfenye);
        System.out.println(selfenye.toString());
        return map;
    }

    @RequestMapping("/xiugai2")
    public String doinfo2(Model model, HttpSession session){
        Integer aid =(Integer) session.getAttribute("aid");
        UserInfo hshselect = hshService.hshselect(aid,1);
        System.out.println("个人信息"+hshselect);
        model.addAttribute("hshselect",hshselect);
        return "xiugai";
    }
    @RequestMapping("/hshdoupdate")
    public void doupdate(@Param("uid") Integer uid, @Param("accid") Integer accid, String nickname, Integer age, String phone, String sex, String address, String email, String qianming, MultipartFile touxiang, HttpServletRequest request, HttpSession session, HttpServletResponse response){
        String path="";
        try {
            path = ResourceUtils.getURL("classpath:").getPath()+"/static/touxiang";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //获取文件名称
        String originalFilename = touxiang.getOriginalFilename();
        //获取文件名称的后缀
        String extension = FilenameUtils.getExtension(originalFilename);
        String fileName="";
        if (!originalFilename.equals("")){
            fileName = System.currentTimeMillis()+ RandomUtils.nextInt(1000000)+"."+extension;
            System.out.println(originalFilename);
            File file1=new File(path,fileName);
            try {
                touxiang.transferTo(file1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //新的文件名称
        UserInfo hshselect = hshService.hshselect1(uid, 1);
        int hshupdz = hshService.hshupdz(uid, 0);
        System.out.println(hshupdz);
        UserInfo userInfo1=new UserInfo();
        userInfo1.setAccid(accid);
        userInfo1.setNickname(nickname);
        userInfo1.setAge(age);
        userInfo1.setPhone(phone);
        userInfo1.setSex(sex);
        userInfo1.setAddress(address);
        userInfo1.setEamil(email);
        userInfo1.setQianming(qianming);
        Date date1=new Date();
        userInfo1.setModification(date1);
        userInfo1.setUtype(1);
        if (originalFilename.equals("")){
            userInfo1.setTouxiang(hshselect.getTouxiang());
        }
        userInfo1.setScore(hshselect.getScore());
        int hshins = hshService.hshins(userInfo1);
        if(hshins>0){
            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.print("<script>alert('修改成功')</script>");
            out.print("<script>location.href='/xiugai2'</script>");
            out.close();
        }
        //return "student";
    }
    @RequestMapping("/insinfo")
    public void insinfo(Account account, UserInfo userInfo, GradeUser gradeUser, HttpServletResponse response){
        account.setPosid(1);
        int hshaccount = hshService.hshaccount(account);
        Account accsel = hshService.accsel(account.getAccountname());
        userInfo.setAccid(accsel.getAid());
        int i = hshService.hshins2(userInfo);
        gradeUser.setUserid(userInfo.getAccid());
        int a= hshService.hshgradeuser(gradeUser);
        if (a>0){  PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.print("<script>alert('添加成功')</script>");
            out.print("<script>location.href='/renyuan'</script>");
            out.close();
        }
        //return "reyuan";
    }
    //跳查询班级页面
    @RequestMapping("/head-teacher")
    public String head(){
        return "head-teacher-list";
    }
    //跳转添加页面
    @RequestMapping("/renyuan")
    public  String renyuan(){
        return "adduser";
    }
    @RequestMapping("/hstudent")
    public String hstudent(){
        return "student";
    }
    @RequestMapping("/genren")
    public String genren(){
        return "rengen2";
    }
    @RequestMapping("/teacher-status")
    public String status(){
        return "teacher-status";
    }
    @RequestMapping("/teacher-k")
    public String teacher(Integer pageIndex,Integer pageSize,Model model){
        PageInfo<Apply> selapply = hshService.selapply(1, 5);
        if(selapply!=null){
            model.addAttribute("apply",selapply);
            System.out.println("考勤"+selapply);
        }
        return "teacher-status";
    }
    @RequestMapping("/teacher-kx")
    @ResponseBody
    public Map<String,Object> teacherkx(Apply apply){
        Map<String,Object> map=new HashMap<>();
        int updateapply = hshService.updateapply(apply);
        map.put("update",updateapply);
        return map;
    }
    @RequestMapping("/teacher-kxi")
    @ResponseBody
    public Map<String,Object> teacherkxi(Checks checks){
        Map<String,Object> map=new HashMap<>();
        int insapply = hshService.insapply(checks);
        map.put("ins",insapply);
        return map;
    }

    @RequestMapping("/student-c")
    public String student_c(Model model,HttpSession session){
        Integer aid =(Integer) session.getAttribute("aid");
        List<Apply> hshapplysel = hshService.hshapplysel(aid);
        model.addAttribute("hshapp",hshapplysel);
        return "askstudent";
    }

}
