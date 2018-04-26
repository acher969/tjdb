<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<script src="../student/student.js" language="JavaScript"></script>

<form:form method="post" commandName="data" id="form">
<form:hidden path="id" id="id" name="id" />
<form:hidden path="role" id="role" name="role" />
	 <div class="formbody">
	    <ul class="forminfo">
	    <li>
	    	<label>姓名:</label>
	    	<form:input path="name" name="name" id="name" cssClass="dfinput"/>
	    </li>
	    <li>
	    	<label>登录名:</label>
	    	<form:input path="login_name" name="login_name" id="login_name"  cssClass="dfinput"/>
	    </li>
	    <li>
	    	<label>性别:</label>
	    	<form:select id="sex" path="sex" cssClass="dfinput">
	    		<form:options items="${list }" itemValue="codeName" itemLabel="codeValue"/>
	    	</form:select>
	    </li>
	    <li>
	    	<label>昵称:</label>
	    	<form:input path="nickname" name="nickname" id="nickname"  cssClass="dfinput"/>
	    </li>
	    <li>
	    	<label>电话:</label>
	    	<form:input path="tel" name="tel" id="tel"  cssClass="dfinput"/>
	    </li>
	    <li>
	    	<label>邮箱:</label>
	    	<form:input path="email" name="email" id="email"  cssClass="dfinput"/>
	    </li>
	    <li>
	    	<label>地址:</label>
	    	<form:input path="address" name="address" id="address"  cssClass="dfinput"/>
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

