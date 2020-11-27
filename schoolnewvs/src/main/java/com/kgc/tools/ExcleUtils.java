package com.kgc.tools;

import com.kgc.pojo.Account;
import com.kgc.pojo.GradeUser;
import com.kgc.pojo.UserInfo;
import com.kgc.service.HshService;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author shkstart
 * @create 2020-11-21 21:32
 */
public class ExcleUtils {
    @Resource
    static HshService hshService;
    /**
     * 读取指定列
     *
     * @param file
     * @throws Exception
     */
    public static void readSpecifyColumns(File file) throws Exception {
        ArrayList<String> columnList = new ArrayList<String>();
        ArrayList<String> valueList = new ArrayList<String>();
        Workbook readwb = null;
        InputStream io = new FileInputStream(file.getAbsoluteFile());
        readwb = Workbook.getWorkbook(io);
        Sheet readsheet = readwb.getSheet(0);
        int rsColumns = readsheet.getColumns();  //获取表格列数
        int rsRows = readsheet.getRows();  //获取表格行数
        for (int i = 1; i < rsRows; i++) {
            Cell cell_name = readsheet.getCell(0, i);  //第一列的值
            columnList.add(cell_name.getContents());
            Cell cell_value = readsheet.getCell(2, i);  //第三列的值，此处需要手动更改，获取不同列的值
            valueList.add(cell_value.getContents());
        }
        System.out.println(columnList);
        System.out.println(valueList);

        String[] name_String = new String[columnList.size()];
        String[] value_String = new String[columnList.size()];
        for (int i = 0; i < columnList.size(); i++) {
            name_String[i] = columnList.get(i);
            value_String[i] = valueList.get(i);
            System.out.println("<string name=" + "\"" + name_String[i] + "\">" + value_String[i] + "</string>");
        }
    }

    /**
     * 读取指定行
     *
     * @param file
     * @throws Exception
     */
    public static void readSpecifyRows(File file) throws Exception {
        ArrayList<String> columnList = new ArrayList<String>();
        Workbook readwb = null;
        InputStream io = new FileInputStream(file.getAbsoluteFile());
        readwb = Workbook.getWorkbook(io);
        Sheet readsheet = readwb.getSheet(0);
        int rsColumns = readsheet.getColumns();  //获取表格列数
        int rsRows = readsheet.getRows();  //获取表格行数
        for (int i = 0; i < rsColumns; i++) {
            Cell cell_name = readsheet.getCell(i, 1);  //在这里指定行，此处需要手动更改，获取不同行的值
            columnList.add(cell_name.getContents());
        }
        System.out.println(columnList);
    }


    public static boolean readRowsAndColums(File file,Integer gid) throws BiffException, IOException {
        //1:创建workbook
        Workbook workbook = Workbook.getWorkbook(file);
        //2:获取第一个工作表sheet
        Sheet sheet = workbook.getSheet(0);
        //3:获取数据
        for (int i = 1; i < sheet.getRows(); i++) {
            Cell cell = sheet.getCell(0, i);
            Cell cell1 = sheet.getCell(1, i);
            Cell cell2 = sheet.getCell(2, i);
            Cell cell3 = sheet.getCell(3, i);
            Cell cell4 = sheet.getCell(4, i);
            Cell cell5 = sheet.getCell(5, i);
            Account account = new Account();
            account.setPosid(1);
            account.setCreatedate(new Date());
            account.setAccountname(cell5.getContents());
            account.setPassword("123456");
            int hshaccount = hshService.hshaccount(account);
            if (hshaccount>0){
                Account accsel =hshService.accsel(account.getAccountname());
                UserInfo userInfo=new UserInfo();
                userInfo.setAccid(accsel.getAid());
                userInfo.setNickname(cell.getContents());
                userInfo.setAge(Integer.parseInt(cell1.getContents()));
                userInfo.setSex(cell2.getContents());
                userInfo.setAddress(cell3.getContents());
                userInfo.setEamil(cell4.getContents());
                userInfo.setPhone(cell5.getContents());
                int w = hshService.hshins2(userInfo);
                if (w>0){
                    GradeUser gradeUser=new GradeUser();
                    gradeUser.setUserid(userInfo.getAccid());
                    gradeUser.setGradeid(gid);
                    int a= hshService.hshgradeuser(gradeUser);
                }
            }
        }

        //最后一步：关闭资源
        workbook.close();
        return false;
    }

    /**
     * 将获取到的值写入到TXT或者xls中
     *
     * @param file
     * @throws Exception
     */
    public static void copy_excel(File file) throws Exception {
        FileWriter fWriter = null;
        PrintWriter out = null;
        String fliename = file.getName().replace(".xls", "");
        fWriter = new FileWriter(file.getParent() + "/agetwo.xls");//输出格式为.xls
        fWriter = new FileWriter(file.getParent() + "/" + fliename + ".txt");//输出格式为.txt
        out = new PrintWriter(fWriter);
        InputStream is = new FileInputStream(file.getAbsoluteFile());
        Workbook wb = null;
        wb = Workbook.getWorkbook(is);
        int sheet_size = wb.getNumberOfSheets();
        Sheet sheet = wb.getSheet(0);
        for (int j = 1; j < sheet.getRows(); j++) {
            String cellinfo = sheet.getCell(0, j).getContents();//读取的是第二列数据，没有标题，标题起始位置在for循环中定义
            out.println(cellinfo);
        }
        out.close();//关闭流
        fWriter.close();
        out.flush();//刷新缓存
        System.out.println("输出完成！");
    }
}
