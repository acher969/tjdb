<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<script src="../common/js/common.js" language="JavaScript"></script> 
<script src="../user/user.js" language="JavaScript"></script>  
<script type="text/javascript"> 
	$(function(){
	    $('#tt2').tree({   
	          checkbox: true,   
	          url: '../userController/openRoleEdit.action?id=<%=request.getParameter("id") %>'  
	   	});   
	}); 
</script>   
    <form:form name="listform">
			<div style="margin:20px 0;"></div>
			
				 		<ul id="tt2">
				        </ul>
	<div style="margin-left: 60px;margin-top: 100px">
		<input name="button" type="button" class="btn" onclick="operate('update_user_role','<%=request.getParameter("id")%>');" value="保存"/>
	</div>				
	</form:form>
