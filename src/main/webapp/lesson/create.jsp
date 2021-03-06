<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="../common/js/jquery-easyui-1.5/themes/default/easyui.css">
	<script type="text/javascript" src="../common/js/jquery-easyui-1.5/jquery.easyui.min.js"></script>
<script src="../lesson/lesson.js" language="JavaScript"></script>

<form:form method="post" commandName="lessonData" id="form">
	 <div class="formbody">
	    <ul class="forminfo">
		<li>
	    	<label>课程名称:</label>
	    	<form:input path="name" name="name" id="name"  cssClass="dfinput"/>
	    </li>
	    <li>
	    	<label>教师:</label>
	       <form:select path="teacher_id" class="easyui-combobox dfinput">  
	       <option/>请选择
              <form:options items="${teacher}"/>  
           </form:select> 
	    </li>
	    <li>
	    	<label>房间:</label>
	    	<form:select path="room_id" cssClass="easyui-combobox dfinput">  
	    	<option/>请选择
              <form:options items="${room}"/>  
           </form:select> 
	    </li>
	    <li>
	    	<label>课时:</label>
	    	<form:input path="class_hour" name="class_hour" id="class_hour" cssClass="dfinput"/>
	    </li>
	    <li>
	    <input name="" type="button" class="btn" onclick="operate('save');" value="保存"/>
	    <label>&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <input name="" type="button" class="btn" onclick="closeWindow();" value="关闭"/>
	    </li>
	    </ul>
    </div>
</form:form>

