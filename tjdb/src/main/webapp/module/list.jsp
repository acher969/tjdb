<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="./common/css/style.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="./common/js/jquery-1.6.js"></script>
	<script src="./common/js/jquery.form.js" type="text/javascript"></script>
	<link href="./common/js/jquery-easyui-1.5/themes/default/easyui.css" rel="stylesheet" type="text/css" />
	<link href="./common/js/jquery-easyui-1.5/themes/icon.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="./common/js/jquery-easyui-1.5/demo/demo.css">
	<script language="JavaScript" src="./common/js/jquery-easyui-1.5/jquery.easyui.min.js"></script>
	<script language="JavaScript" src="./common/js/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js" ></script>
	<script src="./common/js/pagehelper.js" type="text/javascript"></script>
	<script src="./common/js/common.js" type="text/javascript"></script>
	<script src="./module/module.js" language="JavaScript"></script>
	<script type="text/javascript">
		$(function(){
		    $('#tt').treegrid({
		        url:'./moduleController/tree.action',
		        method:'post',          //请求方式
		        idField:'id',           //定义标识树节点的键名字段
        		treeField:'name',       //定义树节点的字段
		        fitColumns:true,        //设置为 true，则会自动扩大或缩小列的尺寸以适应网格的宽度并且防止水平滚动。
		        columns:[[
		            {field:'name',title:'名称',width:100},
		            {field:'url',title:'跳转地址',width:100},
		            {field:'id',title:'所属父级',width:100}
		        ]],
		        onBeforeExpand:function(node){
                     $('#tt').treegrid('options').url = "./moduleController/tree.action?parentId="+node.id;
                     return true;                      
                },
                onContextMenu:function(e,row){
                	e.preventDefault(); 
                	if(row.id!="root"){
                		$('#mm').menu('show', {
							left: e.pageX,
							top: e.pageY,
							onClick:function(item){
								operate(item.id,row.id);
							}
						});
                	}
                }
		    });
		});
	</script>
  </head>
  <body>
    <table id="tt" class="easyui-treegrid" style="width:99%;height:100%"></table>
    <div id="mm" class="easyui-menu" style="width:80px;" onbeforeopen="onBeforeOpen">
		<div id="add_equal" iconCls="icon-add">新增同级节点</div>
		<div id="add_child" iconCls="icon-add">新增子级节点</div>
		<div id="del" iconCls="icon-remove">删除节点</div>
		<div id="edit" iconCls="icon-edit">修改节点</div>
	 </div>
  </body>
</html>
