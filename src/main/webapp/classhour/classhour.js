function operate(str,param){
	if(str=="list"){
		var queryParams = $('#dg').datagrid('options').queryParams;
		queryParams.name = $("#name").val();
		queryParams.login_name = $("#login_name").val();
		$('#dg').datagrid('reload'); // 点击搜索
	}
}