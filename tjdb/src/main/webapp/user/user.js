function operate(str,param,param1){
	if(str=="list"){
		$("#pageNumber").val(1);
		$("form").submit();
	}else if(str=="delUser"){
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"userController/delUser.action",
			data:{'id':param},
			success:function(msg){
				if(msg.success===true){
					window.parent.parent.$.messager.alert('用户管理','删除成功');
					window.parent.frames["rightFrame"].location.reload();
				}else{
					window.parent.parent.$.messager.alert('用户管理','删除失败');
				}
			}
		});
	}else if(str=="open_create"){
		window.parent.parent.openWindow("../userController/openCreate.action",550, 280,"新增用户",true,false,false);
	}else if(str=="save"){
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"../userController/save.action",
			data:$("#form").serialize(),
			success:function(msg){
				if(msg.success===true){
					$.messager.alert('用户管理','添加成功');
					closeWindow();
					window.indexFrame.frames["rightFrame"].location.reload();
				}else if(msg.success=="more"){
					$.messager.alert('用户管理','登录名重名');
				}else{
					$.messager.alert('用户管理','添加失败');
				}
			}
		});
	}else if(str=="open_update"){
		window.parent.parent.openWindow("../userController/openUpdate.action?id="+param,550, 240,"编辑用户",true,false,false);
	}else if(str=="update_active"){
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"userController/updateActive.action",
			data:{'id':param,'active':param1},
			success:function(msg){
				if(msg.success===true){
					window.parent.frames["rightFrame"].location.reload();
				}else{
					$.messager.alert('用户管理','操作失败');
				}
			}
		});
	}else if(str=="update"){
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"../userController/update.action",
			data:$("#form").serialize(),
			success:function(msg){
				if(msg.success===true){
					$.messager.alert('用户编辑','编辑成功');
					closeWindow();
					window.indexFrame.frames["rightFrame"].location.reload();
				}else if(msg.success=="more"){
					$.messager.alert('用户编辑','登录名重名');
				}else{
					$.messager.alert('用户编辑','添加失败');
				}
			}
		});
	}else if(str=="open_pwd"){
		window.parent.parent.openWindow("../userController/openPwd.action?id="+param,550, 240,"编辑用户",true,false,false);
	}else if(str=="update_pwd"){
		var pwd=$("#pwd").val();
		var pwd2=$("#pwd2").val();
		if(pwd!=pwd2){
			$.messager.alert('修改密码','两次输入的密码不一致');
			return ;
		}
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"../userController/updatePwd.action",
			data:$("#form").serialize(),
			success:function(msg){
				if(msg.success===true){
					$.messager.alert('修改密码','修改成功');
					closeWindow();
				}else{
					$.messager.alert('修改密码','修改失败');
				}
			}
		});
	}else if(str=="checkcb"){
		checkAll(param);
	}else if(str=="batch_del"){
		var value=getCheckBoxValue(param);
		if(value==null||value=="")
			return;
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"userController/batchDel.action",
			data:{'ids':value},
			success:function(msg){
				if(msg.success===true){
					window.parent.parent.$.messager.alert('用户管理','删除成功');
					window.parent.frames["rightFrame"].location.reload();
				}else{
					window.parent.parent.$.messager.alert('用户管理','删除失败');
				}
			}
		});
	}else if(str=="open_role_edit"){
		window.parent.parent.openWindow("../user/user_role.jsp?id="+param,270, 240,"编辑角色",true,false,false);
	}else if(str=="update_user_role"){
		var ids=getChecked();
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"../userController/updateUserRole.action",
			data:{'roleIds':ids,'userId':param},
			success:function(msg){
				if(msg.success===true){
					$.messager.alert('编辑角色','编辑成功');
					closeWindow();
				}else{
					$.messager.alert('编辑角色','编辑失败');
				}
			}
		});
	}
}