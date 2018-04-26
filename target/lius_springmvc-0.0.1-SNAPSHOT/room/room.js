function operate(str,param,param1){
	if(str=="list"){
		$("#pageNumber").val(1);
		$("form").submit();
	}else if(str=="delRoom"){
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"roomController/delRoom.action",
			data:{'id':param},
			success:function(msg){
				if(msg.success===true){
					window.parent.parent.$.messager.alert('房间管理','删除成功');
					window.parent.frames["rightFrame"].location.reload();
				}else if(msg.success=="have"){
					window.parent.parent.$.messager.alert('教师管理','该房间已绑定课程');
				}else{
					window.parent.parent.$.messager.alert('房间管理','删除失败');
				}
			}
		});
	}else if(str=="open_create"){
		window.parent.parent.openWindow("../roomController/openCreate.action",550, 580,"新增房间",true,false,false);
	}else if(str=="save"){
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"../roomController/save.action",
			data:$("#form").serialize(),
			success:function(msg){
				if(msg.success===true){
					$.messager.alert('房间管理','添加成功');
					closeWindow();
					window.indexFrame.frames["rightFrame"].location.reload();
				}else if(msg.success=="name"){
					$.messager.alert('课程管理','请输入房间名称！');
				}else if(msg.success=="effective_date"){
					$.messager.alert('课程管理','请输入开始时间！');
				}else if(msg.success=="failure_date"){
					$.messager.alert('课程管理','请输入失效时间！');
				}else if(msg.success=="teacher_url"){
					$.messager.alert('课程管理','老师端加入URL！');
				}else if(msg.success=="student_url"){
					$.messager.alert('课程管理','学生端加入URL！');
				}else if(msg.success=="teacher_password"){
					$.messager.alert('课程管理','老师口令！');
				}else if(msg.success=="student_password"){
					$.messager.alert('课程管理','学生口令！');
				}else if(msg.success=="assistant_password"){
					$.messager.alert('课程管理','助教口令！');
				}else{
					$.messager.alert('房间管理','添加失败');
				}
			}
		});
	}else if(str=="open_update"){
		window.parent.parent.openWindow("../roomController/openUpdate.action?id="+param,550, 580,"编辑房间",true,false,false);
	}else if(str=="update"){
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"../roomController/update.action",
			data:$("#form").serialize(),
			success:function(msg){
				if(msg.success===true){
					$.messager.alert('房间编辑','编辑成功');
					closeWindow();
					window.indexFrame.frames["rightFrame"].location.reload();
				}else if(msg.success=="name"){
					$.messager.alert('课程管理','请输入房间名称！');
				}else if(msg.success=="effective_date"){
					$.messager.alert('课程管理','请输入开始时间！');
				}else if(msg.success=="failure_date"){
					$.messager.alert('课程管理','请输入失效时间！');
				}else if(msg.success=="teacher_url"){
					$.messager.alert('课程管理','老师端加入URL！');
				}else if(msg.success=="student_url"){
					$.messager.alert('课程管理','学生端加入URL！');
				}else if(msg.success=="teacher_password"){
					$.messager.alert('课程管理','老师口令！');
				}else if(msg.success=="student_password"){
					$.messager.alert('课程管理','学生口令！');
				}else if(msg.success=="assistant_password"){
					$.messager.alert('课程管理','助教口令！');
				}else{
					$.messager.alert('房间编辑','添加失败');
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
			url:"roomController/batchDel.action",
			data:{'ids':value},
			success:function(msg){
				if(msg.success===true){
					window.parent.parent.$.messager.alert('房间管理','删除成功');
					window.parent.frames["rightFrame"].location.reload();
				}else if(msg.success=="have"){
					window.parent.parent.$.messager.alert('教师管理','存在房间已绑定课程');
				}else{
					window.parent.parent.$.messager.alert('房间管理','删除失败');
				}
			}
		});
	}
}