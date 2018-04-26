function operate(str,param){
	if(str=="login"){
		var user_name=$("#loginName").val();
		var password=$("#password").val();
		if(user_name==null||user_name==""){
			alert("用户名不能为空");
			return;
		}
		if(password==null||password==""){
			alert("密码不能为空");
			return;
		}
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"loginController/login.action",
			data:$("#form").formSerialize(),
			success:function(msg){
				if(msg.success===true){
					window.location.href=param+"loginController/index.action";
				}else if(msg.success==="role"){
					alert("用户无权登录系统或该用户已被注销");
				}else{
					alert("用户名或密码错误");
				}
			}
		});
	}
}