function checkAll(name) { 
	var checklist = document.getElementsByName (name);
	if(document.getElementById(name).checked)
	{
		for(var i=0;i<checklist.length;i++)
		{
			checklist[i].checked = 1;
		} 
	}else{
		for(var j=0;j<checklist.length;j++)
		{
			checklist[j].checked = 0;
		}
	 }
} 

function getCheckBoxValue(name){
	var checklist=document.getElementsByName (name);
	var ch="";
	for(var i=0;i<checklist.length;i++){
		if(checklist[i].checked){
			ch+=checklist[i].value+",";
		}
	}
	return ch;
}

function getChecked(){//复选框选中
	var nodes = $('#tt2').tree('getChecked');
	var s = '';
	for(var i=0; i<nodes.length; i++){
		if (s != '') s += ',';
		s += nodes[i].id;
	}
	return s;
}

$(document).ready(function(){
	  $(".click").click(function(){
	  $(".tip").fadeIn(200);
	  });
	  
	  $(".tiptop a").click(function(){
	  $(".tip").fadeOut(200);
	});
	
	  $(".sure").click(function(){
	  $(".tip").fadeOut(100);
	});
	
	  $(".cancel").click(function(){
	  $(".tip").fadeOut(100);
	});
	
	});