<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="../classhour/classhour.js" language="JavaScript"></script>


 <table class="tablelist">
	    	
	        <tbody>
		        <c:forEach items="${data}" var="list" varStatus="st">
		        	<tr>
				        <td>课程:${list.lesson_name }</td>
				        <td>教师:${list.teacher_name }</td>
				        <td>总课时:${list.class_hour }</td>
				       	<td>剩余课时:${list.remainder_class_hour }</td>
			        </tr>
		        </c:forEach>
	        </tbody>
	    </table>

