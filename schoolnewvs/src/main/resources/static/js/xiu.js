$(document).ready(function () {
})
//日期天数计算
function getNewData(dateTemp, days) {
    var dateTemp = dateTemp.split("-");
    var nDate = new Date(dateTemp[1] + '-' + dateTemp[2] + '-' + dateTemp[0]); //转换为MM-DD-YYYY格式
    var millSeconds = Math.abs(nDate) + (days * 24 * 60 * 60 * 1000);
    var rDate = new Date(millSeconds);
    var year = rDate.getFullYear();
    var month = rDate.getMonth() + 1;
    if (month < 10) month = "0" + month;
    var date = rDate.getDate();
    if (date < 10) date = "0" + date;
    return (year + "-" + month + "-" + date);
}
//日期计算，参数data为日期格式,days为要加上的天数，如果减days就是负数
function computationDate(date, days) {
    var d = new Date(date);
    d.setDate(d.getDate() + days);    //如果加月就是d.getMonth(); 以此类推
    var m = d.getMonth() + 1;
    return d.getFullYear() + '-' + m + '-' + d.getDate() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();  //返回格式 2016-4-27 13:18:00 （可根据自己需要自行设定返回内容）
}
function addDay(datetime, days) {
    var old_time = new Date(datetime.replace(/-/g, "/")); //替换字符，js不认2013-01-31,只认2013/01/31
    var fd = new Date(old_time.valueOf() + days * 24 * 60 * 60 * 1000); //日期加上指定的天数
    var new_time = fd.getFullYear() + "-";
    var month = fd.getMonth() + 1;
    if (month >= 10) {
        new_time += month + "-";
    } else {
        //在小于10的月份上补0
        new_time += "0" + month + "-";
    }
    if (fd.getDate() >= 10) {
        new_time += fd.getDate();
    } else {
        //在小于10的日期上补0
        new_time += "0" + fd.getDate();
    }
    return new_time; //输出格式：2013-01-02
}
//获取date当前系统时间
function getNowFormatDate() {
    var now = new Date();
    var year = now.getFullYear();       //年
    var month = now.getMonth() + 1;     //月
    var day = now.getDate();            //日
    var hh = now.getHours();            //时
    var mm = now.getMinutes();          //分
    var ss = now.getSeconds();          //分
    var clock = year + "-";
    if (month < 10)
        clock += "0";
    clock += month + "-";
    if (day < 10)
        clock += "0";
    clock += day + " ";
    if (hh < 10)
        clock += "0";
    clock += hh + ":";
    if (mm < 10)
        clock += '0';
    clock += mm + ":";
    if (ss < 10)
        clock += '0';
    clock += ss;
    return clock;
}
function dateAddDays(dateStr,dayCount) {
        var tempDate=new Date(dateStr.replace(/-/g,"/"));//把日期字符串转换成日期格式
         var resultDate=new Date((tempDate/1000+(86400*dayCount))*1000);//增加n天后的日期
         var resultDateStr=resultDate.getFullYear()+"-"+(resultDate.getMonth()+1)+"-"+(resultDate.getDate());//将日期转化为字符串格式
        return resultDateStr;
     }
function rTime(date) {
    var json_date = new Date(date).toJSON();
    return new Date(new Date(json_date) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '')
}
function xiu(a,b,c) {
    var json3={
        appid:a,
        apptype: 0
    }
    $.post("/teacher-kx",json3,function (date) {
        alert("已拒绝")
    })
}
var bo=false;
function upd(a,b,c) {
    time=c;
    if(c<getNowFormatDate()){
        var json4={
            appid:a,
            apptype:3
        }
        $.post("/teacher-kx",json4,function (date1) {
            
        })
        alert("过期")
        return;
    }
    rTime(c)
    var tempDate=new Date(c.replace(/-/g,"/"));
    alert(rTime(c))
    var json = {
        apptype: 2,
        appid: a
    }
    $.post("/teacher-kx",json,function (result) {
        alert("修改成功")
        location.href="redirect:/teacher-k"
    })

    var tian;
    for (tian=1; tian<=b;tian++) {
        var json2 = {
            aid: a,
            signindate:  dateAddDays(rTime(c),tian),
            signoutdate: dateAddDays(rTime(c),tian),
            remark: "请假",
            chtype: 4
        }
        console.log(json2)
        if(bo){
            $.post("/teacher-kxi",json2,function (data) {
                location.href="redirect:/teacher-k"
            })
        }else {
            alert("已过期")
        }

    }
}
//获取当前系统时间
function getNowDate() {
    var myDate = new Date;
    var year = myDate.getFullYear(); //获取当前年
    var mon = myDate.getMonth() + 1; //获取当前月
    var date = myDate.getDate(); //获取当前日
    var hours = myDate.getHours(); //获取当前小时
    var minutes = myDate.getMinutes(); //获取当前分钟
    var seconds = myDate.getSeconds(); //获取当前秒
    var now = year + "-" + mon + "-" + date + " " + hours + ":" + minutes + ":" + seconds;
    return now;
}

function getTimestamp() {
    return new Date(getNowDate()).getTime();
}


