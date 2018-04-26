<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="../module/module.js" language="JavaScript"></script>

<form:form method="post" commandName="data" id="form">
<input type="hidden" name="parentId" id="parentId" value="${data.parentId }"/>
	 <div class="formbody">
	    <ul class="forminfo">
	    <li>
	    	<label>菜单名称:</label>
	    	<form:input path="name" name="name" id="name"  cssClass="dfinput"/>
	    </li>
	    <li>
	    	<label>菜单路径:</label>
	    	<form:input path="url" name="url" id="url" cssClass="dfinput"/>
	    </li>
	    <li>
	    	<label>序号:</label>
	    	<form:input path="orderNo" name="orderNo" id="orderNo" cssClass="dfinput"/>
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
