<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<script src="../student/student.js" language="JavaScript"></script>

<style type="text/css">
.select_side{float:left; width:200px}
select{width:180px; height:220px}
.select_opt{float:left; width:70px; height:100%; margin-top:36px}
.select_opt p{width:26px; height:26px; margin-top:6px; background:url(arr.gif) no-repeat; cursor:pointer; text-indent:-999em}
.select_opt p#toright{background-position:2px 0}
.select_opt p#toleft{background-position:2px -22px}
.sub_btn{clear:both; height:42px; line-height:42px; padding-top:10px; text-align:center}
.textinput{border-top:solid 1px #a7b5bc; border-left:solid 1px #a7b5bc; border-right:solid 1px #ced9df; border-bottom:solid 1px #ced9df; background:url(../images/inputbg.gif) repeat-x; padding:10px; width:180px; height:220px; line-height:20px; overflow:hidden;}
.input{border-top:solid 1px #a7b5bc; border-left:solid 1px #a7b5bc; border-right:solid 1px #ced9df; border-bottom:solid 1px #ced9df; background:url(../images/inputbg.gif) repeat-x; padding:10px; width:80px; height:5px; line-height:5px; overflow:hidden;}
.bb{width:46px; height:26px;background:url(../common/images/btnbg.png) no-repeat;font-size:14px;font-weight:bold;color:#fff; cursor:pointer;}
</style>
<script type="text/javascript">
$(function(){
    var leftSel = $("#selectL");
	var rightSel = $("#selectR");
	$("#toright").bind("click",function(){		
		leftSel.find("option:selected").each(function(){
			$(this).remove().appendTo(rightSel);
		});
	});
	$("#toleft").bind("click",function(){		
		rightSel.find("option:selected").each(function(){
			$(this).remove().appendTo(leftSel);
		});
	});
	leftSel.dblclick(function(){
		$(this).find("option:selected").each(function(){
			$(this).remove().appendTo(rightSel);
		});
	});
	rightSel.dblclick(function(){
		$(this).find("option:selected").each(function(){
			$(this).remove().appendTo(leftSel);
		});
	});
	$("#sub").click(function(){
	var id = document.getElementById("id").value;
		var selVal = [];
		rightSel.find("option").each(function(){
			selVal.push(this.value);
		});
		selVals = selVal.join(",");
		//selVals = rightSel.val();
			operate('save_lesson',selVals,id);
	});
});
 function getlesson(){
 	var name=document.getElementById("name").value;
 	var id=document.getElementById("id").value;
 	$.ajax({
                type:"post",
			dataType:"json",
			url:"../studentController/getTest.action",
			data:{"name":name,"id":id},
                success: function(data) {
                selectL.options.length=0;
                for(var i=0;i<data.length;i++){
                	document.all.selectL.options[i]= new Option(data[i].name,data[i].id);
                      }
                }
           })
         }
</script>
<form:form method="post" commandName="studentData" id="form">
<form:hidden path="id" id="id" name="id" />
<div id="main" class="formbody">
     <li><label>课程名称:</label><form:input path="name" id="name" class="input"/>
     <input name="fb" type="button" value="查询" onclick="getlesson()"  class="bb"/></li>
     <div class="select_side">
     <p>待选区</p>
	       <form:select id="selectL" path="courses" multiple="multiple" class="textinput">  
           </form:select> 
     </div>
     <div class="select_opt">
     	<input type="button" id="toright" value="添加" class="bb"></button>
     	<input type="button" id="toleft" value="移除" class="bb"></button>
     </div>
     <div class="select_side">
     <p>已选区</p>
     	   <form:select id="selectR" name="selectR"  path="courses" multiple="multiple" class="textinput">  
              <form:options items="${courses}"/>  
           </form:select> 
     </div>
     <div class="sub_btn">
     <input name="" type="button" class="btn" id="sub" value="保存"/>
     <input name="" type="button" class="btn" onclick="closeWindow();" value="关闭"/>
     </div>
</div>
</form:form>