<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="sy.frame.ConstantClass"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><%=ConstantClass.SYS_NAME %></title>
<style>
html,body{
 height:100%;
 margin: 0;
 overflow-y:hidden; 
}
</style>
<link href="../common/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../common/js/jquery-1.6.js"></script>
<script type="text/javascript" src="../common/js/jquery.form.js" ></script>
<link href="../common/js/jquery-easyui-1.5/themes/default/easyui.css" rel="stylesheet" type="text/css" />
<link href="../common/js/jquery-easyui-1.5/themes/icon.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../common/js/jquery-easyui-1.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../common/js/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js" ></script>

<script type="text/javascript">
	//全局模式化弹出窗口,url打开路径，width宽，height高，title窗口标题，close是否有关闭按钮，min是否有最小化，max是否有最大化
	function openWindow(url,width,height,title,close,min,max){
  		 $('#dd').dialog({
                title: title,
                cache:false,
                collapsible: false,
                minimizable: min,
                closable: close,
                maximizable: max,
                resizable: true,
                width: width,
                height: height,
                href:url,
                modal: true
            });
  	}
  	function closeWindow(){
  		$('#dd').dialog('close');
  	}
</script>
</head>
	<body>
		<div id="dd"></div>
		<iframe src="../frame.jsp" id="indexFrame" name="indexFrame" width="100%" height="100%" frameborder="0" scrolling="no"></iframe>
	</body>
</html>