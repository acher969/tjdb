<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="../student/student.js" language="JavaScript"></script>

<form:form method="post" commandName="studentData" id="form">
	 <div class="formbody">
	    <ul class="forminfo">
	    <li>
	    	<label>姓名:</label>
	    	<form:input path="name" name="name" id="name"  cssClass="dfinput"/>
	    </li>
	    <li>
	    	<label>登录名:</label>
	    	<form:input path="login_name" name="login_name" id="login_name" cssClass="dfinput"/>
	    </li>
	    <li>
	    	<label>密码:</label>
	    	<input type="password" path="password" name="password" id="pwd" class="dfinput"/>
	    </li>
	    <li>
	    	<label>确认密码:</label>
	    	<input type="password" name="pwd2" id="pwd2" class="dfinput">
	    </li>
	   	<li>
	    	<label>性别:</label>
	    	<form:select id="sex" path="sex" cssClass="dfinput">
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

