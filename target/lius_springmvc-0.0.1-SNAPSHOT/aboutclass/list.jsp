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
    
    <title>课程预约</title>
    
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
	<script src="./aboutclass/aboutclass.js" language="JavaScript"></script>
  </head>
  
  <body>
    <form:form method="post" commandName="data" id="form">
  		<form:hidden path="pageTotal" id="pageTotal" value="${data.pageTotal}"/>
  		<form:hidden path="pageRows" id="pageRows" value="${data.pageRows}"/>
  		<form:hidden path="pageNumber" id="pageNumber" value="${data.pageNumber}"/>
  		<form:hidden path="pageCountRows" id="pageCountRows" value="${data.pageCountRows}"/>
  		
	    <div class="place">
		    <span>位置：</span>
		    <ul class="placeul">
			    <li><a href="#">首页</a></li>
			    <li><a href="#">教务中心</a></li>
			    <li><a href="#">门户管理</a></li>
			    <li><a href="#">试听课预约</a></li>
		    </ul>
	    </div>
    
    <div class="rightinfo">
    	
	    <div class="tools">
	    	<ul class="seachform">
	    		
	    		<li><label>姓名</label><form:input path="name" id="name" cssClass="scinput"/></li>
	    		<li>
	    			<label>状态</label>
			    	<form:select id="type" path="type" cssClass="scinput">
			    		<form:option value="" label=""/> 
			    		<form:options items="${type_list }" itemValue="codeName" itemLabel="codeValue" />
			    	</form:select>
			    </li>
	        	<li><input name="fb" type="button" class="scbtn" value="查询" onclick="operate('list');"/></li>
	        	<!--  
	        	<li>
			    	<ul class="toolbar">
				        <li class="click" onclick="operate('open_create','<%=basePath%>');"><span><img src="./common/images/t01.png" /></span>添加</li>
				        <li onclick="operate('batch_del','cb')"><span><img src="./common/images/t03.png" /></span>批量删除</li>
			        </ul>
		   		</li>
		   		 -->
	        </ul>
	    </div>
    
	    <table class="tablelist">
	    	<thead>
		    	<tr>
		        <th>姓名</th>
		        <th>电话</th>
		        <th>年级</th>
		        <th>科目</th>
		        <th>申请时间</th>
		        <th>状态</th>
		        <th>操作</th>
		        </tr>
	        </thead>
	        <tbody>
		        <c:forEach items="${data.pageList}" var="list" varStatus="st">
		        	<tr>
				        <td>${list.name }</td>
				        <td>${list.phone }</td>
				        <td>${list.grade }</td>
				        <td>${list.subject }</td>
				        <td>${list.create_date }</td>
				        <td>
							<c:if test="${list.type==1 }">
								已读
							</c:if>
							<c:if test="${list.type==0 }">
								未读
							</c:if>
						</td>
				        <td>
							<c:if test="${list.type==0 }">
								<a href="javascript:void(0);" onclick="operate('update_type','${list.id}');" class="tablelink">完成</a> 
							</c:if>
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
