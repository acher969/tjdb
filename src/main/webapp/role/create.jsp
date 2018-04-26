<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="../role/role.js" language="JavaScript"></script>

<form:form method="post" commandName="data" id="form">
	 <div class="formbody">
	    <ul class="forminfo">
	    <li>
	    	<label>角色名:</label>
	    	<form:input path="name" name="name" id="name"  cssClass="dfinput"/>
	    </li>
	    <li>
	    	<label>状态:</label>
	    	<form:select id="state" path="state" cssClass="dfinput">
	    		<form:options items="${list }" itemValue="codeName" itemLabel="codeValue"/>
	    	</form:select>
	    </li>
	    
	    </br>
	    <li>
	    <input name="sub" type="button" class="btn" onclick="operate('saveRole');" value="保存"/>
	    <label>&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <input name="" type="button" class="btn" onclick="closeWindow();" value="关闭"/>
	    </li>
	    </ul>
    </div>
</form:form>

