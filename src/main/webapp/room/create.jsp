<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="../room/room.js" language="JavaScript"></script>

<form:form method="post" commandName="roomData" id="form">
	 <div class="formbody">
	    <ul class="forminfo">
	    <li>
	    	<label>房间名称:</label>
	    	<form:input path="name" name="name" id="name"  cssClass="dfinput"/>
	    </li>
	    <li>
	    	<label>开始时间:</label>
	    	<form:input path="effective_date" name="effective_date" id="effective_date"  cssClass="easyui-datetimebox" data-options="editable:false,width:'345px',height:'32px',color:'#a7b5bc'"/>
	    </li>
	    <li>
	    	<label>失效时间:</label>
	    	<form:input path="failure_date" name="failure_date" id="failure_date"  cssClass="easyui-datetimebox" data-options="editable:false,width:'345px',height:'32px',color:'#a7b5bc'"/>
	    </li>
	    <li>
	    	<label>老师端加入URL:</label>
	    	<form:input path="teacher_url" name="teacher_url" id="teacher_url" cssClass="dfinput"/>
	    </li>
	    <li>
	    	<label>学生端加入URL:</label>
	    	<form:input path="student_url" name="student_url" id="student_url" cssClass="dfinput"/>
	    </li>
	    <li>
	    	<label>老师口令:</label>
	    	<form:input path="teacher_password" name="teacher_password" id="teacher_password" cssClass="dfinput"/>
	    </li>
	    <li>
	    	<label>助教口令:</label>
	    	<form:input path="assistant_password" name="assistant_password" id="assistant_password" cssClass="dfinput"/>
	    </li>
	    <li>
	    	<label>学生口令:</label>
	    	<form:input path="student_password" name="student_password" id="student_password" cssClass="dfinput"/>
	    </li>
	    <li>
	    	<label>类型:</label>
	    	<form:select id="cjmb" path="cjmb" cssClass="dfinput">
	    		<form:options items="${list }" itemValue="codeName" itemLabel="codeValue"/>
	    	</form:select>
	    </li>
	    
	    </br>
	    <li>
	    <input name="" type="button" class="btn" onclick="operate('save');" value="保存"/>
	    <label>&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <input name="" type="button" class="btn" onclick="closeWindow();" value="关闭"/>
	    </li>
	    </ul>
    </div>
</form:form>

