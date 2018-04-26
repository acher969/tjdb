function operate(str,param,param1){
	if(str=="list"){
		$("#pageNumber").val(1);
		$("form").submit();
	}else if(str=="delLesson"){
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"lessonController/delLesson.action",
			data:{'id':param},
			success:function(msg){
				if(msg.success===true){
					window.parent.parent.$.messager.alert('课程管理','删除成功');
					window.parent.frames["rightFrame"].location.reload();
				}else if(msg.success=="more"){
					$.messager.alert('用户管理','该课程下存在人员');
				}else{
					window.parent.parent.$.messager.alert('课程管理','删除失败');
				}
			}
		});
	}else if(str=="open_create"){
		window.parent.parent.openWindow("../lessonController/openCreate.action",550, 400,"新增课程",true,false,false);
	}else if(str=="save"){
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"../lessonController/save.action",
			data:$("#form").serialize(),
			success:function(msg){
				if(msg.success===true){
					$.messager.alert('课程管理','添加成功');
					closeWindow();
					window.indexFrame.frames["rightFrame"].location.reload();
				}else if(msg.success=="name"){
					$.messager.alert('课程管理','请输入课程名称！');
				}else if(msg.success=="teacher"){
					$.messager.alert('课程管理','请选择教师！');
				}else if(msg.success=="room"){
					$.messager.alert('课程管理','请选择房间！');
				}else if(msg.success=="class_hour"){
					$.messager.alert('课程管理','请输入课时！');
				}else if(msg.success=="noTeacher"){
					$.messager.alert('课程管理','未找到此教师！');
				}else if(msg.success=="noRoom"){
					$.messager.alert('课程管理','未找到此房间！');
				}else{
					$.messager.alert('课程管理','添加失败');
				}
			}
		});
	}else if(str=="open_update"){
		window.parent.parent.openWindow("../lessonController/openUpdate.action?id="+param,550, 200,"编辑课程",true,false,false);
	}else if(str=="update"){
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"../lessonController/update.action",
			data:$("#form").serialize(),
			success:function(msg){
				if(msg.success===true){
					$.messager.alert('房间编辑','编辑成功');
					closeWindow();
					window.indexFrame.frames["rightFrame"].location.reload();
				}else if(msg.success=="name"){
					$.messager.alert('课程管理','请输入课程名称！');
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
			url:"lessonController/batchDel.action",
			data:{'ids':value},
			success:function(msg){
				if(msg.success===true){
					window.parent.parent.$.messager.alert('课程管理','删除成功');
					window.parent.frames["rightFrame"].location.reload();
				}else if(msg.success=="more"){
					$.messager.alert('用户管理','该课程下存在人员');
				}else{
					window.parent.parent.$.messager.alert('课程管理','删除失败');
				}
			}
		});
	}
}