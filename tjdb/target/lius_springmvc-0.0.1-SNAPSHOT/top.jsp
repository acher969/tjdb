<%@page import="sy.frame.ConstantClass"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><%=ConstantClass.SYS_NAME %></title>
    
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
	<script type="text/javascript">
	$(function(){	
		//顶部导航切换
		$(".nav li a").click(function(){
			$(".nav li a.selected").removeClass("selected");
			$(this).addClass("selected");
		});	
	});	
	
	function expand(id){
    	window.parent.frames["leftFrame"].location="<%=basePath%>loginController/left.action?moduleParentId="+id;
    }
    
    function init(){
    	document.getElementById("top0").click();
    }
    
    function quit(){
    	if (confirm("确定退出本系统吗？")){
    		window.parent.parent.location.href="<%=basePath%>loginController/quit.action";
    	}
    }
	</script>
  </head>
  
  <body style="background:url(./common/images/topbg.gif) repeat-x;" onload="init();">

    <div class="topleft">
    <a href="" target="_parent"><img src="./common/images/logo.png" title="系统首页" /></a>
    </div>
        
    <ul class="nav">
    	<c:forEach items="${data.baseList}" var="list" varStatus="st">
    		<li>
    		<a name="module" href="javascript:void(0);" id="top${st.index}" title="${list.name}" onclick="expand('${list.id}')">
	    		<img src="./common//images/${list.img}" title="${list.name}" />
	    		<h2>${list.name}</h2>
    		</a>
    		</li>
    	</c:forEach>
    </ul>
            
    <div class="topright">    
    <ul>
    <li><span><img src="./common/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="javascript:void(0);" target="_parent" onclick="quit();">退出</a></li>
    </ul>
     
    <div class="user">
    <span>用户： ${sessionScope.user.name}</span>
    <!-- 
    <i>消息</i>
    <b>5</b>
     -->
    </div>    
    
    </div>
  </body>
</html>
