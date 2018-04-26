<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<script src="../common/js/common.js" language="JavaScript"></script> 
<script src="../role/role.js" language="JavaScript"></script>  
<script type="text/javascript"> 
 
		  
     $(function(){
             $('#tt2').tree({
                 url: '../roleController/moduleList.action?id=root',
                 checkbox: true,
                 cascadeCheck:false,//级联检查，默认true
                 //onlyLeafCheck:true,   
                 onBeforeExpand:function(node,param){
                     $('#tt2').tree('options').url = "../roleController/childModuleList.action?roleId=<%=request.getParameter("roleId")%>&parentId=" + node.id;                    
                 },
              	 onLoadSuccess:function(node,data){//展开全部节点
                	 if(data){
					 	$(data).each(function(index,d){
							if(this.state == 'closed'){
						    	$('#tt2').tree('expandAll');
						   	}
		         		});
		         	  }
		         }
              });             
       }); 

		
		
		
    </script>   
    <form:form name="listform">
			<div style="margin:20px 0;"></div>
			
				 		<ul id="tt2">
				        </ul>
	<div style="margin-left: 133px;margin-top: 150px">
		<input name="button" type="button" class="btn" onclick="operate('update_module_role','<%=request.getParameter("roleId")%>');" value="保存"/>
	</div>				
	</form:form>
