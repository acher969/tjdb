<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<script src="../user/user.js" language="JavaScript"></script>

<form:form method="post" commandName="data" id="form">
<form:hidden path="id" id="id" name="id" />
	 <div class="formbody">
	    <ul class="forminfo">
	    <li>
	    	<label>姓名:</label>
	    	<form:input path="name" name="name" id="name" cssClass="dfinput"/>
	    </li>
	    <li>
	    	<label>登录名:</label>
	    	<form:input path="loginName" name="loginName" id="loginName"  cssClass="dfinput"/>
	    </li>
	    
	    </br>
	    <li>
	    <input name="" type="button" class="btn" onclick="operate('update');" value="保存"/>
	    <label>&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <input name="" type="button" class="btn" onclick="closeWindow();" value="关闭"/>
	    </li>
	    </ul>
    </div>
</form:form>

