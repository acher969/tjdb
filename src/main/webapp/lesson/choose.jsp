<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="../lesson/lesson.js" language="JavaScript"></script>


<script type="text/javascript">
	$('#tt').combobox({
		prompt:'输入关键字后自动搜索',
		required:true,
		mode:'remote',
		url:'../lessonController/getTest.action',
		editable:true,
		hasDownArrow:false,
		valueField:'id',  
   		textField:'text', 
		onBeforeLoad: function(param){
			if(param == null || param.q == null || param.q.replace(/ /g, '') == ''){
				var value = $(this).combobox('getValue');
				if(value){// 修改的时候才会出现q为空而value不为空
					param.id = value;
					return true;
				}
				return false;
			}
		}
	});	
 		$('#rr').combobox({
		prompt:'输入关键字后自动搜索',
		required:true,
		mode:'remote',
		url:'../lessonController/getTest2.action',
		editable:true,
		hasDownArrow:false,
		valueField:'id',  
   		textField:'text', 
		onBeforeLoad: function(param){
			if(param == null || param.q == null || param.q.replace(/ /g, '') == ''){
				var value = $(this).combobox('getValue');
				if(value){// 修改的时候才会出现q为空而value不为空
					param.id = value;
					return true;
				}
				return false;
			}
		}
	});	
</script>

<form:form method="post" commandName="lessonData" id="form">
	 <div class="formbody">
	    <ul class="forminfo">
		<li>
	    	<label>课程名称:</label>
	    	<form:input path="name" name="name" id="name"  cssClass="dfinput"/>
	    </li>
	    <li>
	    	<label>教师:</label>
	       <form:input path="teacher_id" name="tt" id="tt" data-options="panelHeight:'auto',width:'345px',height:'32px',color:'#a7b5bc'"/>  
	    </li>
	    <li>
	    	<label>房间:</label>
	    	<form:input path="room_id" name="rr" id="rr" data-options="panelHeight:'auto',width:'345px',height:'32px',color:'#a7b5bc'"/>
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

