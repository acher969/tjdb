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
	<script language="JavaScript" src="./common/js/jquery-easyui-1.5/jquery.easyui.min.js"></script>
	<script language="JavaScript" src="./common/js/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js" ></script>
	<script src="./common/js/pagehelper.js" type="text/javascript"></script>
	<script src="./common/js/common.js" type="text/javascript"></script>
	<script src="./lesson/lesson.js" language="JavaScript"></script>
	
	
  </head>
  
  <body>
  	<form:form method="post" commandName="lessonData" id="form">
  		<form:hidden path="pageTotal" id="pageTotal" value="${data.pageTotal}"/>
  		<form:hidden path="pageRows" id="pageRows" value="${data.pageRows}"/>
  		<form:hidden path="pageNumber" id="pageNumber" value="${data.pageNumber}"/>
  		<form:hidden path="pageCountRows" id="pageCountRows" value="${data.pageCountRows}"/>
  		
	    <div class="place">
		    <span>位置：</span>
		    <ul class="placeul">
			    <li><a href="#">首页</a></li>
			    <li><a href="#">教务管理</a></li>
			    <li><a href="#">课程管理</a></li>
		    </ul>
	    </div>
    
    <div class="rightinfo">
    
	    <div class="tools">
	    	<ul class="seachform">
	    		<li><label>课程名称</label><form:input path="name" id="name" cssClass="scinput"/></li>
	        	<li><input name="fb" type="button" class="scbtn" value="查询" onclick="operate('list');"/></li>
	        	<li>
		    	<ul class="toolbar">
			        <li class="click" onclick="operate('open_create','<%=basePath%>');"><span><img src="./common/images/t01.png" /></span>添加</li>
			        <li onclick="operate('batch_del','cb')"><span><img src="./common/images/t03.png" /></span>批量删除</li>
		        </ul>
		    </li>
	        </ul>
	    </div>
    
	    <table class="tablelist">
	    	<thead>
		    	<tr>
		        <th><input name="" type="checkbox" id="cb" value="" onclick="operate('checkcb','cb')"/></th>
		        <th>课程名称</th>
		        <th>教师</th>
		        <th>房间</th>
		        <th>课时</th>
		        <th>操作</th>
		        </tr>
	        </thead>
	        <tbody>
		        <c:forEach items="${data.pageList}" var="list" varStatus="st">
		        	<tr>
				        <td><input name="cb" type="checkbox" value="${list.id }" /></td>
				        <td>${list.name }</td>
				        <td>${list.teacher_id }</td>
				        <td>${list.room_id }</td>
				        <td>${list.class_hour }</td>
				        <td>  
				        	<a href="javascript:void(0);" onclick="operate('open_update','${list.id}')" class="tablelink">编辑</a>    
				        	<a href="javascript:void(0);" class="tablelink" onclick="operate('delLesson','${list.id}')"> 删除</a>
				        </td>
			        </tr>
		        </c:forEach>
	        </tbody>
	    </table>
    
   
	    <div class="pagin">
	    	<script>
				pagemenu();
		  	 </script>
	    </div>
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
	</form:form>
  </body>
</html>
