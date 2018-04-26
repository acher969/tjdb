function operate(str,param,param1){
	if(str=="list"){
		$("#pageNumber").val(1);
		$("form").submit();
	}else if(str=="delAssistant"){
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"assistantController/delAssistant.action",
			data:{'id':param},
			success:function(msg){
				if(msg.success===true){
					window.parent.parent.$.messager.alert('助教管理','删除成功');
					window.parent.frames["rightFrame"].location.reload();
				}else{
					window.parent.parent.$.messager.alert('助教管理','删除失败');
				}
			}
		});
	}else if(str=="open_create"){
		window.parent.parent.openWindow("../assistantController/openCreate.action",550, 380,"新增助教",true,false,false);
	}else if(str=="save"){
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
			url:"../assistantController/save.action",
			data:$("#form").serialize(),
			success:function(msg){
				if(msg.success===true){
					$.messager.alert('助教管理','添加成功');
					closeWindow();
					window.indexFrame.frames["rightFrame"].location.reload();
				}else if(msg.success=="more"){
					$.messager.alert('助教管理','登录名重名');
				}else if(msg.success=="name"){
					$.messager.alert('课程管理','请输入姓名！');
				}else if(msg.success=="login_name"){
					$.messager.alert('课程管理','请输入登录名！');
				}else if(msg.success=="password"){
					$.messager.alert('课程管理','请输入密码！');
				}else{
					$.messager.alert('助教管理','添加失败');
				}
			}
		});
	}else if(str=="open_update"){
		window.parent.parent.openWindow("../assistantController/openUpdate.action?id="+param,550, 580,"编辑助教",true,false,false);
	}else if(str=="update_active"){
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"assistantController/updateActive.action",
			data:{'id':param,'active':param1},
			success:function(msg){
				if(msg.success===true){
					window.parent.frames["rightFrame"].location.reload();
				}else{
					$.messager.alert('助教管理','操作失败');
				}
			}
		});
	}else if(str=="update"){
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"../assistantController/update.action",
			data:$("#form").serialize(),
			success:function(msg){
				if(msg.success===true){
					$.messager.alert('助教编辑','编辑成功');
					closeWindow();
					window.indexFrame.frames["rightFrame"].location.reload();
				}else if(msg.success=="more"){
					$.messager.alert('助教编辑','登录名重名');
				}else if(msg.success=="name"){
					$.messager.alert('课程管理','请输入姓名！');
				}else if(msg.success=="login_name"){
					$.messager.alert('课程管理','请输入登录名！');
				}else{
					$.messager.alert('助教编辑','添加失败');
				}
			}
		});
	}else if(str=="open_pwd"){
		window.parent.parent.openWindow("../assistantController/openPwd.action?id="+param,550, 240,"编辑助教",true,false,false);
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
			url:"../assistantController/updatePwd.action",
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
			url:"assistantController/batchDel.action",
			data:{'ids':value},
			success:function(msg){
				if(msg.success===true){
					window.parent.parent.$.messager.alert('助教管理','删除成功');
					window.parent.frames["rightFrame"].location.reload();
				}else{
					window.parent.parent.$.messager.alert('助教管理','删除失败');
				}
			}
		});
	}
}