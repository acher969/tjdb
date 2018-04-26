function operate(str,param){
	if(str=="save"){
		var bool=checkForm();
		if(bool){
			$.ajax({
				async:false,
				type:"post",
				dataType:"json",
				url:"./mobileWebController/save.action",
				data:$("#form").formSerialize(),
				success:function(msg){
					alert(msg.message);
				}
			});
		}
	}
}

//表单验证
function checkForm(){
	var num=$("#phone").val();
	var grade=$("#grade option:selected").val();
	var subject=$("#subject option:selected").val();
	var name=$("#name").val();
	var flag=checkMobile(num);
	if(!flag){
		alert("手机号码填写有误");
		return false;
	}else if(name==null|| name==''){
		alert("请填写姓名");
		return false;
	}else if(grade==''||grade==null||grade=='请选择'){
		alert("请选择年级");
		return false;
	}else if(subject==''||subject==null||subject=='请选择'){
		alert("请选择科目");
		return false;
	}
	return true;
}

//手机号验证
function checkMobile(num){
	var reg = /^1[0-9]{10}$/;
	var flag = reg.test(num);
	return flag;
}