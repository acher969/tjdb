function operate(str,param){
	if(str=="update_type"){
		$.ajax({
			async:false,
			type:"post",
			dataType:"json",
			url:"aboutClassController/update_type.action",
			data:{'id':param},
			success:function(msg){
				if(msg.success===true){
					window.parent.parent.$.messager.alert('课程预约',msg.message);
					window.parent.frames["rightFrame"].location.reload();
				}else{
					window.parent.parent.$.messager.alert('用户管理',msg.message);
				}
			}
		});
	}else if(str=="list"){
		$("#pageNumber").val(1);
		$("form").submit();
	}
}