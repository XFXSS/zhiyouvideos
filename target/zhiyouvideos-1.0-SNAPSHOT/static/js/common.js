<<<<<<< HEAD
/*
	这里放置前台功能通用的一些js方法
	主要有：登录窗口的切换、注册窗口的切换、登录功能(ajax)、注册功能(ajax)
*/

$(function(){
	
	//显示登录窗口
	$('#login_open').click(function(){
		$('#loginDiv').removeClass('hidden');
	});
	//显示注册窗口
	$('#reg_open').click(function(){
		$('#regDiv').removeClass('hidden');
	});
	//隐藏登录窗口
	$('#login_close').click(function(){
		$('#loginDiv').addClass('hidden');
	});
	//隐藏注册窗口
	$('#reg_close').click(function(){
		$('#regDiv').addClass('hidden');
	});
	
	//登录请求的处理
	$('#loginForm').validate({
		submitHandler:function(form){
			//ajax提交登录信息，并且返回登录结果
//			var email = $('#loginEmail').val();
//			var pwd = $('#loginPassword').val();
			console.log($('#loginForm').serialize());
			//使用ajax的post方法提交登录信息
			$.post('front/user/login.do',$('#loginForm').serialize(),function(result){
				console.log(result);
				if(result.success){
					//登录成功,刷新页面
					location.reload();
				}else{
					alert(result.message);
				}
			},'json');
			
		},
		rules:{//写校验规则的
			email:{
				required:true,
				email:true,
				minlength:3
			},
			password:{
				required:true,
				minlength:3
			}
		},
		messages:{//写提示信息的
			email:"登录名称必须是已注册邮箱",
			password:'密码是必须填写的，3-30个字符'
		}
	});	
	
	
	//注册请求的处理
	$('#regForm').validate({
		submitHandler:function(form){
			//ajax提交注册信息，并且返回注册结果
			console.log($('#regForm').serialize());
			//使用ajax的post方法提交注册信息
			$.post('front/user/regist.do',$('#regForm').serialize(),function(result){
				console.log(result);
				if(result.success){
					//注册成功,刷新页面
					location.reload();
				}else{
					alert(result.message);
				}
			},'json');
			
		},
		rules:{//写校验规则的
			email:{
				required:true,
				email:true,
				minlength:3
			},
			password:{
				required:true,
				minlength:3
			},
			pswAgain:{
				required:true,
				equalTo:'#regPsw'
			}
		},
		messages:{//写提示信息的
			email:"注册账户必须是邮箱",
			password:'密码是必须填写的，3-30个字符',
			pswAgain:'两次密码必须输入一致'
		}
	});	
	
	
});
=======
// 登录注册显示和消失弹出框
$('#reg_open').click(function () {
	$('#regDiv').removeClass('hidden');
});
$('#login_open').click(function () {
	$('#loginDiv').removeClass('hidden');
});
$('#reg_close').click(function(){
	$('#regDiv').addClass('hidden');
});
$('#login_close').click(function(){
	$('#loginDiv').addClass('hidden');
});

// 校验注册的邮箱
$("#regEmail").blur(function(){
	//不为空再校验
	var emailVal=$("#regEmail").val();
	// alert(emailVal);
	// js 判断不相等  不能使用   !""==xxxx
	if(null != emailVal && ""!=emailVal){
		var params={"email":emailVal};
		// alert(params);
		$.post("user/validateEmail.do",params,function(data){
			if(data=="success"){
				regIsCommitEmail=true;
				//$("#emailMsg").text("该邮箱可用").css("color","green");
			}else{
				regIsCommitEmail=false;
				$("#emailMsg").text("该邮箱已注册，请直接登录").css("color","red");
			}
		});
	}

});
// 校验注册的密码
$("#regPswAgain").blur(function(){
	var pass01= $("#regPsw").val();
	var pass02= $("#regPswAgain").val();
	if(null==pass01 || ""==pass01 || null==pass02 || ""==pass02){
		$("#passMsg").text("密码不能为空").css("color","red");
		regIsCommitPsw =false;
	}else{
		if(pass01!=pass02){
			regIsCommitPsw=false;
			$("#passMsg").text("两次密码输入不一致，请重新输入").css("color","red");
		}else{
			regIsCommitPsw=true;
			$("#passMsg").text("");
		}
	}

});

$("#loginout").click(function(){

	$.get("user/loginOut.action",null,function(){
		$("#regBlock").css("display","block");
		$("#userBlock").css("display","none");
	});

});

// 登录js代码
function commitLogin(){
	// 获取输入框的值
	var email =$("#loginEmail").val();
	var password =$("#loginPassword").val();
	alert(email);
	if(null!=email && email!="" && null!=password && password!=""){
		// 将form表单中的数据序列化并封装进参数
		var params=$("#loginForm").serialize();
		alert(params);
		// post要小写
		$.post("user/loginUser.do",params,function(data){
			if(data=='success'){
				//登录框消失
				$("#login").addClass("hidden");

				$("#account").text($("#loginEmail").val());
				//将登录的user信息展示
				$("#regBlock").css("display","none");
				$("#userBlock").css("display","block");
			}else{
				$("#loginMsg").text("用户或密码错误").css("color","red");
			}
		});
		return false;
	}
	return false;
}
>>>>>>> b2d078bd85813ed6429705882eca18a45c0751ab
