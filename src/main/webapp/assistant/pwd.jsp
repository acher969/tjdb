<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<script src="../teacher/teacher.js" language="JavaScript"></script>

<form:form method="post" commandName="assistantData" id="form">
<form:hidden path="id" id="id" name="id" />
	 <div class="formbody">
	    <ul class="forminfo">
	    <li>
	    	<label>新密码:</label>
	    	<form:password path="password" name="password" id="pwd" cssClass="dfinput"/>
	    </li>
	    <li>
	    	<label>确认密码:</label>
	    	<input type="password" name="pwd2" id="pwd2" class="dfinput">
	    </li>
	    
	    </br>
	    <li>
	    <input name="" type="button" class="btn" onclick="operate('update_pwd');" value="保存"/>
	    <label>&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <input name="" type="button" class="btn" onclick="closeWindow();" value="关闭"/>
	    </li>
	    </ul>
    </div>
</form:form>

