function operate(str,param,param2){
	if(str=="module_role"){
		window.parent.parent.openWindow(".././role/module_list.jsp?roleId="+param,420, 280,"权限编辑",true,false,false);
	}else if(str=="update_module_role"){
		var ids=getChecked();
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"../roleController/updateModuleRole.action",
			data:{'ids':ids,'roleId':param},
			success:function(msg){
				if(msg.success===true){
					window.parent.parent.$.messager.alert('角色管理','编辑成功');
					closeWindow();
				}else{
					$.messager.alert('角色管理','编辑失败');
				}
			}
		});
	}else if(str=="checkcb"){
		checkAll(param);
	}else if(str=="update_state"){
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"./roleController/updateState.action",
			data:{'id':param,'state':param2},
			success:function(msg){
				if(msg.success===true){
					window.parent.frames["rightFrame"].location.reload();
				}else{
					$.messager.alert('角色管理','操作失败');
				}
			}
		});
	}else if(str=="deleteRole"){
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"./roleController/deleteRole.action",
			data:{'id':param},
			success:function(msg){
				if(msg.success===true){
					$.messager.alert('角色管理','删除成功');
					window.parent.frames["rightFrame"].location.reload();
				}else{
					$.messager.alert('角色管理','删除失败');
				}
			}
		});
	}else if(str=="open_create"){
		window.parent.parent.openWindow("../roleController/openCreate.action",550, 280,"新增角色",true,false,false);
	}else if(str=="saveRole"){
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"../roleController/saveRole.action",
			data:$("#form").serialize(),
			success:function(msg){
				if(msg.success===true){
					$.messager.alert('角色管理','新增成功');
					closeWindow();
					window.indexFrame.frames["rightFrame"].location.reload();
				}else{
					$.messager.alert('角色管理','新增失败');
				}
			}
		});
	}else if(str=="list"){
		$("#pageNumber").val(1);
		$("form").submit();
	}
}