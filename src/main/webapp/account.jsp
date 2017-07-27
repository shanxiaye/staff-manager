<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.5.2/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.5.2/themes/icon.css">
	<script type="text/javascript" src="../jquery-easyui-1.5.2/jquery.min.js"></script>
	<script type="text/javascript" src="../jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
</head>
<body>
<div style="border-bottom: 1px black solid; height: 60px; margin-bottom: 20px;">
	<br>
    <a id="add2Button" href="#" width="100">新增</a>
    <a id="editButton" href="#" width="100">修改</a>
    <a id="removeButton" href="#" width="100">删除</a>
</div>
	<table id="accountTable"></table>
	    <div id="dlg2" class="easyui-dialog" style="width:400px"
            closed="true" buttons="#dlg-buttons">
        <form id="fm2" method="post" novalidate style="margin:0;padding:20px 50px">
            <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">账号信息</div>
            <div style="margin-bottom:10px">
                <input name="id" class="easyui-textbox" field="id" label="ID:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="accountNumber" class="easyui-textbox" filed="accountNumber" label="账号:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="password" class="easyui-textbox" filed="password" label="密码:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="position" class="easyui-textbox" filed="position" label="职位:" style="width:100%">
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" style="width:90px" id="toSubmit">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">返回</a>
    </div>
</body>
<script type="text/javascript" src="../js/account.js"></script>

</body>
</html>