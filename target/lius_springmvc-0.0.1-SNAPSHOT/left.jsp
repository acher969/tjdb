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
	<script language="JavaScript" src="./common/js/jquery.js"></script>
	<script type="text/javascript">
	$(function(){	
		//导航切换
		$(".menuson li").click(function(){
			$(".menuson li.active").removeClass("active");
			$(this).addClass("active");
			
		});
		
		$('.title').click(function(){
			var $ul = $(this).next('ul');
			$('dd').find('ul').slideUp();
			if($ul.is(':visible')){
				$(this).next('ul').slideUp();
			}else{
				$(this).next('ul').slideDown();
			}
		});
	});	
	function jumpRight(url){
		window.parent.frames["rightFrame"].location=url;
	}
	</script>
  </head>
  <body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>菜单</div>
    
    <dl class="leftmenu">
    	<c:forEach items="${data.baseList}" var="list" varStatus="st">
	    	<c:if test="${list.type==1}">
		    	<dd>
		    		<div class="title">
					    <span><img src="./common/images/${list.img }" /></span>${list.name} 
					</div>
					<ul class="menuson">
						<c:forEach items="${data.baseList}" var="chilList" varStatus="cst">
							<c:if test="${chilList.parentId==list.id}">
								<li><cite></cite><a href="javascript:void(0);" target="rightFrame" onclick="jumpRight('<%=basePath %>${chilList.url}');">${chilList.name }</a><i></i></li>
							</c:if>	
						</c:forEach>
					</ul> 
				</dd> 
	    	</c:if>
	    </c:forEach>
    </dl>
     
  </body>
</html>
