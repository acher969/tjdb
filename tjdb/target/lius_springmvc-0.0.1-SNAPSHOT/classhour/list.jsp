<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="./common/css/style.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="./common/js/jquery-1.6.js"></script>
	<script src="./common/js/jquery.form.js" type="text/javascript"></script>
	<link href="./common/js/jquery-easyui-1.5/themes/default/easyui.css" rel="stylesheet" type="text/css" />
	<link href="./common/js/jquery-easyui-1.5/themes/icon.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="./common/js/jquery-easyui-1.5/demo/demo.css">
	<script language="JavaScript" src="./common/js/jquery-easyui-1.5/jquery.easyui.min.js"></script>
	<script language="JavaScript" src="./common/js/jquery-easyui-1.5/datagrid-detailview.js" ></script>
	<script language="JavaScript" src="./common/js/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js" ></script>
	<script src="./common/js/pagehelper.js" type="text/javascript"></script>
	<script src="./common/js/common.js" type="text/javascript"></script>
	<script src="./classhour/classhour.js" language="JavaScript"></script>
  </head>
  <script type="text/javascript">
			//var jsondata='{"total":1,"rows":[{"username":"001","password":"001"},{"username":"002","password":"002"},{"username":"002","password":"002"}]}';
            //var data = $.parseJSON(jsondata); //json格式化
            $(document).ready(function(){
                $("#dg").datagrid({
                url: './classHourController/list.action',
                view:detailview,
                detailFormatter:function(index,row){    
			        return '<div id="ddv-' + index + '" style="padding:5px 0"></div>';    
			    },    
			    onExpandRow: function(index,row){    
			        $('#ddv-'+index).panel({    
			            border:false,    
			            cache:false,    
			            href:'./classHourController/classhour.action?id='+row.id,    
			            onLoad:function(){    
			                $('#dg').datagrid('fixDetailRowHeight',index);    
			            }    
			        });    
			        $('#dg').datagrid('fixDetailRowHeight',index);    
			    },    
                width: '99%',  
                height: '100%',  
                striped: true,
                rownumbers: true,
                singleSelect: true,
                nowrap: true,
                pagination: true,
                fitColumns:true,
                pageSize: 10, //分页大小  
                
                columns:[[    
                {field:"id",title:"id",hidden:'true'},
                {field:"name",title:"姓名",width:100},    
                {field:"tel",title:"电话",width:100},
                {field:"email",title:"邮箱",width:100},
                {field:"active",title:"状态",width:100}
                   ]]
            });
           //$("#dg").datagrid('loadData', data);//加载数据，不加表格数据不会显示
			//var p = $('#dg').datagrid('getPager'); 
		    //$(p).pagination({ 
			//        onSelectPage:function(pageNumber, pageSize){
			        
			//	}
				
		    //}); 
    });
    
    

  </script>
  <body style="overflow:hidden;margin:0;padding:0">
  	 <div class="easyui-panel" title="学生列表" icon="icon-save" style="width:100%;height:96%;" collapsible="true" minimizable="true" >  
    <div class="easyui-layout" fit="true">  
        <div region="north" border="false" style="border-bottom:1px solid #ddd;height:32px;padding:2px 5px;background:#fafafa;">  
            <!--  
            <div style="float:left;">  
                <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add">新增</a>  
            </div>  
            <div class="datagrid-btn-separator"></div>  
             <div style="float:left;">  
                <a href="#" class="easyui-linkbutton" plain="true" icon="icon-save">编辑</a>  
            </div>  
            <div class="datagrid-btn-separator"></div>  
             <div style="float:left;">  
                <a href="#" class="easyui-linkbutton" plain="true" icon="icon-remove">删除</a>  
            </div> --> 
            <div style="float:left;">
            	姓名：  
               <input name="name" id="name"  class="easyui-searchbox" data-options="prompt:'这里输入学生姓名'" style="width:170px;vertical-align:middle;"/>
               	&nbsp;&nbsp;
               	登录名：  
               <input name="login_name" id="login_name"  class="easyui-searchbox" data-options="prompt:'这里输入学生登录名'" style="width:170px;vertical-align:middle;"/>  
               <a href="javascript:operate('list');" class="easyui-linkbutton" plain="true">查询</a>  
            </div>  
        </div>  
        <div region="center" border="false">  
            <table id="dg"></table>  
        </div>  
    </div>  
</div>
	 	
  </body>
</html>
