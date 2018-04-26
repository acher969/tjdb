function operate(str,param){
	if(str=="add_equal"){
		window.parent.parent.openWindow("../moduleController/create.action?createType=1&id="+param,550, 280,"新增用户",true,false,false);
	}else if(str=="add_child"){
		window.parent.parent.openWindow("../moduleController/create.action?createType=2&id="+param,550, 280,"新增用户",true,false,false);
	}else if(str=="del"){
		$.messager.confirm('继续操作', '确定删除此节点下所有子节点吗?',         
			function(r){
				if (r){
					$.ajax({
						async:false,
						type:"post",
						dataType:"json",
						url:"./moduleController/delete.action",
						data:{'id':param},
						success:function(msg){
							if(msg.success===true){
								window.parent.parent.$.messager.alert('菜单管理','删除成功');
								window.parent.frames["rightFrame"].location.reload();
							}else{
								$.messager.alert('菜单管理','删除失败');
							}
						}
					});
				}
		});
	}else if(str=="edit"){
		window.parent.parent.openWindow("../moduleController/openEdit.action?id="+param,550, 280,"新增用户",true,false,false);
	}else if(str=="save"){
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"../moduleController/save.action",
			data:$("#form").serialize(),
			success:function(msg){
				if(msg.success===true){
					$.messager.alert('菜单管理','添加成功');
					closeWindow();
					window.indexFrame.frames["rightFrame"].location.reload();
				}else{
					$.messager.alert('菜单管理','添加失败');
				}
			}
		});
	}else if(str=="update"){
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"../moduleController/updateMoule.action",
			data:$("#form").serialize(),
			success:function(msg){
				if(msg.success===true){
					$.messager.alert('菜单管理','编辑成功');
					closeWindow();
					window.indexFrame.frames["rightFrame"].location.reload();
				}else{
					$.messager.alert('菜单管理','编辑失败');
				}
			}
		});
	}
}
