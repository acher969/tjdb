<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="sy.frame.ConstantClass"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<link href="./common/css/style.css" type="text/css" rel="stylesheet" media="all" />
<script type="text/javascript" src="./common/js/jquery-1.6.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><%=ConstantClass.SYS_NAME %></title>
</head>

<frameset rows="88px,*" cols="*" frameborder="no" border="0" framespacing="0" >
  <frame src="loginController/top.action" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset cols="187px,*" frameborder="no" border="0" framespacing="0" id="mainFrameset">
    <frame src="" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
    <frame src="" name="rightFrame" id="rightFrame" title="rightFrame" />
  </frameset>
</frameset>
<noframes><body>
</body></noframes>
<!-- 
<script>
		var mainFrameset = document.getElementById("mainFrameset");
		var height=document.body.clientHeight;
		var down=height-88-50;
		mainFrameset.rows = "*,10";
</script> -->
</html>