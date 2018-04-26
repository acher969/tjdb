function pagemenu(){
	var url=$("form").attr("action");
	var total=$("#pageTotal").val();
	var pageRows=$("#pageRows").val();
	var pageNumber=$("#pageNumber").val();
	var pageCountRows=$("#pageCountRows").val();
	
	document.write("<div class='message'>共<i class='blue'>"+total+"</i>条记录，每页显示"+pageRows+"条</div>");
	document.write("<ul class='paginList'>");
	if(pageNumber == 1){
		document.write("<li class='paginItem'><a href='javascript:;'><span class='pagepre'></span></a></li>");
	}else{
		document.write("<li class='paginItem'><a href=\"javascript:tranoperate('" + url + "',' "+ (parseInt(pageNumber)-1) + "');\"><span class='pagepre'></span></a></li>");
	}
	document.write("<li class='paginItem'><a href='javascript:;'>&nbsp;&nbsp;&nbsp;"+pageNumber+"/"+pageCountRows+"&nbsp;&nbsp;&nbsp;</a></li>");
	if(pageNumber==pageCountRows){		
		document.write("<li class='paginItem'><a href='javascript:;'><span class='pagenxt'></span></a></li>");
	}else{
		document.write("<li class='paginItem'><a href=\"javascript:tranoperate('"+ url + "','"+(parseInt(pageNumber) + 1)+"');\"><span class='pagenxt'></span></a></li>");
	}
	document.write("<li class='paginItem'><input type='text' name='go' id='go' class='pagezd'/></li>");
	document.write("<li class='paginItem'><a href=\"javascript:goPage('" + url + "');\">转到</a></li>");
	document.write("</ul>");
}

function tranoperate(url, pageNumber) {
	$("form").attr("action", url); 
	$("#pageNumber").val(pageNumber);
	$("form").submit();
	
}

function goPage(url) {
	//alert($("#go").val());
	if ($("#go").val() == "") {
		alert("\u60a8\u8f93\u5165\u7684\u9875\u6570\u662f\u7a7a\u7684");
		$("#go").focus();
		return;
	}
	if (vailnum($("#go").val())) {
		alert("\u60a8\u8f93\u5165\u7684\u9875\u6570\u4e0d\u662f\u6570\u5b57");
		$("#go").focus();
		$("#go").select();
		return;
	}
	if ($("#go").val() <= 0) {
		alert("\u60a8\u8f93\u5165\u7684\u9875\u6570\u592a\u5c0f");
		$("#go").focus();
		$("#go").select();
		return;
	}
	if (($("#go").val() - 1) * $("#paginationnum").val() >= $("#total").val()) {
		alert("\u60a8\u8f93\u5165\u7684\u9875\u6570\u592a\u5927");
		$("#go").focus();
		$("#go").select();
		return;
	}
	/*modify by mafei at 2012-09-13 解决某些页面找不到listform的怪问题；
	$("form[name=listform]").attr("action", url);
	$("#pageBegin").val(((parseInt($("#go").val()) - 1) * parseInt($("#pageLen").val())));
	$("form[name=listform]").submit(); 
	*/
	$("form").attr("action", url);
	var go=$("#go").val();
	$("#pageNumber").val(go);
	$("form").submit();
}

function vailnum(str) {
	var myReg = /^[0-9]+$/;
	return !myReg.test(str);
}