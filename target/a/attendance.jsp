<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/block.css" rel="stylesheet">
<script type="text/javascript" src="jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript">
var nowDate;
var time;
var charType='Ite';
var name ;
function load(t) {
	nowDate = new Date();
	time = nowDate.toLocaleString();
	name = $("#user"+t).val();
	if(name == null && $.trim(name) == ""){
		alert("请输入用户名或ID");
		return;
	};
	if(isNaN(name)){
		charType = 'str';
	};
	to(t)
};
function to(t) {
	$.ajax({
		url:'account/attendance',
		type:'post',
		data:{
			checkType : t,
			charType : charType,
			name : name
		},
		dataType:'json',
		success:function(data){
			success = data.success;
			if(success){
				alert('打卡成功');
			}
			if(data.Msg != null){
				alert(data.Msg);
			}
		}
	})
}
</script>
</head>
<body style="background-image:url(css/bg.gif)">
     <div class="wrap">
        <div class="container">
            <h1>Attendance</h1>
            <form id="register">
                <input type="text" id="userup" nameup="user" placeholder="请输入用户名或ID"/>
                <input type="button" value="签到" onclick="load('up')" onmouseover="style='width:400px'" onmouseleave="style='width:320px'"/>
                <br><br>
                <input type="text" id="userout" nameout="user" placeholder="请输入用户名或ID"/>
                <input type="button" value="签退" onclick="load('out')" onmouseover="style='width:400px'" onmouseleave="style='width:320px'"/>
                <input type="button" value="登录" onclick="location.href='html/login.html'" onmouseover="style='width:400px'" onmouseleave="style='width:320px'"/>
                <input type="reset" value="重置" onmouseover="style='width:400px'" onmouseleave="style='width:320px'"/>
            </form>
        </div>
        <ul>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>

</body>
</html>