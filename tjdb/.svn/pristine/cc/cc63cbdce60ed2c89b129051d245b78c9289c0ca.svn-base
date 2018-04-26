<%@page import="sy.frame.ConstantClass"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title><%=ConstantClass.SYS_NAME %></title>
    
	<link href="./common/css/style.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="./common/js/jquery-1.6.js"></script>
	<script src="./common/js/cloud.js" type="text/javascript"></script>
	<script src="./login/login.js" type="text/javascript"></script>
	<script src="./common/js/jquery.form.js" type="text/javascript"></script>
	<script language="javascript">
		$(function(){
	    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		$(window).resize(function(){  
	    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	    });  
	});  
	</script> 
  </head>
  <body style="background-color:#1c77ac; background-image:url(./common/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
    	<form:form method="post" commandName="sysUser" id="form">
    	<div id="mainBody">
	    	<div id="cloud1" class="cloud"></div>
	      	<div id="cloud2" class="cloud"></div>
	    </div>  
    
		<div class="logintop">    
		    <span></span>    
		    <ul>
		    <li><a href="#">回首页</a></li>
		    <li><a href="#">帮助</a></li>
		    <li><a href="#">关于</a></li>
		    </ul>    
    	</div>
    
	    <div class="loginbody">
	    	<span class="systemlogo"></span> 
	    	<div class="loginbox">
			    <ul>
				    <li>
				    	<form:input path="loginName" id="loginName" cssClass="loginuser" onclick="JavaScript:this.value=''"/>
				    </li>
				    <li>
				    	<form:password path="password" id="password" cssClass="loginpwd" onclick="JavaScript:this.value=''"/>
				    </li>
				    <li>
				    	<input name="submit" type="button" class="loginbtn" value="登录"  onclick="operate('login','<%=basePath%>')"  />
				    	<label><input name="" type="checkbox" value="" checked="checked" />记住密码</label>
				    	<label><a href="#">忘记密码？</a></label>
				    </li>
			    </ul>
	    	</div>
	    </div>
    
    	<div class="loginbm">版权所有  上海辉斌教育 2017  </div>
    </form:form>
	</body>
</html>
