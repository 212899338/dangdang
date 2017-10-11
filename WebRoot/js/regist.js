$(function(){
	var isEmail = false;
	var isNickName = false;
	var ispaw = false;
	var isRepeatpwd = false;
	var isCode = false;
	
	//邮箱验证
	$("#email").blur(function(){
		var email = $("#email").val();
		if(email.length==0){//邮箱输入
			$("#emailInfo").html("&nbsp请输入邮箱").css("color","red");
			isEmail = false;
		}else{
			var reg=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
			if(reg.test(email)){
				//在邮箱正确的情况下，检测邮箱是否被注册过
				//ajax局部范围访问服务器端
				$.ajax({
					type:"post",	//访问服务器方式get/post
					url:"email",
					data:{checkemail:$(this).val()},
					success:function(flag){
						if(flag==1){		//flag值为true
							$("#emailInfo").html("&nbsp邮箱已经被注册过").css("color","red");
							isEmail = false;
						}
						if(flag==0){		//flag值为false
							$("#emailInfo").html("&nbsp邮箱可以使用").css("color","green");
							isEmail = true;
						}
					}
				});
		}else{//邮箱格式不正确
			$("#emailInfo").html("&nbsp邮箱格式不正确").css("color","red");
			isEmail = false;
			}
		}
	});
	//呢称验证
	$("#txtNickName").blur(function(){
		var name = $("#txtNickName").val();
		if(name.length==0){
			$("#nameInfo").html("&nbsp请输入昵称").css("color","red");
			isNickName = false;
		}else{
			var n=/^[a-z\d\u4e00-\u9fa5]{4,20}$/
			if(n.test(name)){
				$("#nameInfo").html("&nbsp昵称可用").css("color","green");
				isNickName = true;
			}else{
				$("#nameInfo").html("&nbsp昵称格式不正确").css("color","red");
				isNickName = false;
			}
		}
	});
	//密码验证
	$("#txtPassword").blur(function(){
		var password = $("#txtPassword").val();
		if(password.length==0){
			$("#passwordInfo").html("&nbsp请输入密码").css("color","red");
			ispaw = false;
		}else{
			var paw=/^[a-zA-Z\d]{6,20}$/
			if(paw.test(password)){
				$("#passwordInfo").html("&nbsp密码正确").css("color","green");
				ispaw = true;
			}else{
				$("#passwordInfo").html("&nbsp密码格式不正确").css("color","red");
				ispaw = false;
			}
		}
	});
	//重复密码验证
	$("#txtRepeatPass").blur(function(){
		var password = $("#txtPassword").val();
		var password1 = $("#txtRepeatPass").val();
		if(password1.length==0){
			$("#password1Info").text("请再次输入密码").css("color","red");
			isRepeatpwd = false;
		}else{
			if(password1 == password){
				$("#password1Info").text("密码正确").css("color","green");
				isRepeatpwd = true;
			}else{
				$("#password1Info").text("请重新输入").css("color","red")
				isRepeatpwd = false;
			}
		}
	});
	//验证码验证
	$("#validateCode").blur(function(){
		var image = $("#validateCode").val();
		if(image.length==0){
			$("#vcodeValidMsg").html("请输入验证码&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp").css("color","red");
			isCode = false;
		}else{		//使用ajax将用户发给服务器端，检验是否正确
			$.ajax({
				type:"post",
				url:"checkcode",
				data:{coed:$(this).val()},
				success:function(msg){
					if(msg==1){
						$("#vcodeValidMsg").html("验证码正确&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp").css("color","green");
						isCode = true;
					}
					if(msg==0){
						$("#vcodeValidMsg").html("请重新输入&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp").css("color","red");
						isCode = false;
					}
				}
			});
		}
	});
	
	//很据ID找到表单from，限制表单提交功能
	$("#f").submit(function(){//如果提交按钮是true，提交失效，反之。
		return isEmail&&isNickName&&ispaw&&isRepeatpwd&&isCode;
	});
});