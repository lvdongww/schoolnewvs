$(document).ready(function () {
    $(".xiuphone").click(function () {
        $(".email").removeClass("emailcss");
        $(".xiuemail").removeClass("xiucss");
        $(".xiuemail").addClass("xiucss2")
        $("#yan").fadeIn(300);
        var sum = 30;
        var e = $(".phone").val();
        var yanzhengp = "";
        $.post("/toPhone", {emails: e}, function (data) {
            console.log(data)
            yanzhengp = data.yan;
        }, "json")
    })
    $(".queding").click(function () {
        var e = $(".phone").val();
        var yan = $(".yanp").val();
        if (yanzhengp != yan) {
            alert("请填写正确的验证码");
            return;
        }
        $("#yan").fadeOut(300);
        alert("验证通过");
        $(".phone").removeAttr('disabled');
    })
    var yanzheng = "";
    $(".xiuemail").click(function () {
        $("#yan2").fadeIn(300);
        var sum = 60;
        var e = $(".email").val();
        $.post("/toEamil", {emails: e}, function (data) {
            console.log(data)
            yanzheng = data.yan;
        }, "json")
    })
    $(".queding2").click(function () {
        var e = $(".email").val();
        var yan = $(".yan2").val();
        if (yanzheng != yan) {
            alert("请填写正确的验证码");
            return;
        }
        alert("验证通过");
        $("#yan2").fadeOut(300);
        $(".email").removeAttr('readonly');
    })

})