$(document).ready(function() {
	$("#register").on("submit",function(event){
		event.preventDefault();
		var id = $("#id").val();
		pa = $("#pa").val();
		pw = $("#pw").val();
		var username = $('#username').val();
		if(id == null || $.trim(id) == "" || pa == null || $.trim(pa) == "" || pw == null || $.trim(pw) == "" || username == null || $.trim(username) == ""){
			alert("以上信息均不能为空，请先输入");
			return;
		}else{
			if(isNaN(id)){
				alert("输入的ID不是数字");
				return;
			}
			if(pa != pw){
				alert("确认密码和密码不一致");
				return;
			}
		};
		var arr = $(this).serializeArray();
		var jsonObj = {};
		for(var i in arr){
			jsonObj[arr[i].name] = arr[i].value;
		};
		json = JSON.stringify(jsonObj);
		$.ajax({
			url:'../account/register',
			type:'post',
			data:{
				json:json
			},
			dataType:'json',
			success:function(data){
				var success = data.success;
				if(success){
					alert("注册成功");
				};
				if(data.Msg != null){
					alert(data.Msg);
				}
			}
		})
	})
})