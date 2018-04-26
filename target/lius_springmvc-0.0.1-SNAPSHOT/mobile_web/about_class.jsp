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
    
    <title>辉斌1对1</title>
		<meta charset="utf-8">
		<title>辉斌1对1约课中心</title>
		<meta name="keywords"><meta name="description">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<meta name="format-detection" content="telephone=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<link href="./mobile_web/common/swiper.min.css" rel="stylesheet">
		<link rel="stylesheet" href="./mobile_web/common/w_global.css">
		<link rel="stylesheet" href="./mobile_web/common/w_index.css">
		<script src="./mobile_web/common/jquery.min.js"></script>
		<script type="text/javascript" src="./common/js/jquery.form.js" ></script>
		<script src="./mobile_web/common/sha512.min.js"></script>
		<script src="./mobile_web/common/swiper.jquery.min.js"></script>
		<script src="./mobile_web/common/gotoTop.js"></script>
		<script src="./mobile_web/mobile_web.js" language="JavaScript"></script>
  </head>
  
  <body id="bodyTop">
			<nav>
				<a class="nav-left" href="javascript:void(0)" onclick="document.getElementById('bodyTop').scrollIntoView();">
				<img class="translateXY" src="./mobile_web/image/nav-left.png" alt="辉斌1对1" title="辉斌1对1"></a> 
				<a class="nav-right" href="tel:021-67677580">
				<img class="translateXY" src="./mobile_web/image/top-icon.png" alt="辉斌1对1" title="辉斌1对1"></a>
			</nav>
			
			<div class="select1">
				<div class="swiper-container swiper-container-horizontal">
					<div class="swiper-wrapper">
						<div class="swiper-slide swiper-slide-active" >
							<div style="background: url('./mobile_web/image/bg1.jpg') no-repeat center;background-size: cover;">
							</div>
						</div>
					</div>
					<div class="swiper-pagination"></div>
				</div>
			</div>
			<div class="select select2" id="myForm">
				<form:form method="post" commandName="data" id="form" cssClass="myForm">
					<input type="text" name="adid" class="adid" style="display:none">
					<input type="text" name="jh" class="jh" style="display:none"> 
					<input type="text" name="dy" class="dy" style="display:none"> 
					<input type="text" name="keyNum" class="keyNum" style="display:none">
					<p>
						<input type="text" id="name" name="name" class="name" placeholder="请输入姓名">
					</p>
					<p>
						<input name="phone" id="phone" placeholder="请输入手机号" class="mobile">
					</p>
					<p id="code" style="display: none;">
						<input type="text" placeholder="请输入验证码" name="code" class="code">
						<input class="send" value="获取验证码" type="button" id="btn">
					</p>
					<p class="clearfix">
						<select name="grade" id="grade" style="float: left; color: rgb(204, 204, 204);" class="grade">
							<option value="请选择" selected="" style="display: none; color: rgb(0, 0, 0);">--请选择年级--</option>
							<option value="小四" style="color: rgb(0, 0, 0);">小四</option>
							<option value="小五" style="color: rgb(0, 0, 0);">小五</option>
							<option value="小六" style="color: rgb(0, 0, 0);">小六</option>
							<option value="预初" style="color: rgb(0, 0, 0);">预初</option>
							<option value="初一" style="color: rgb(0, 0, 0);">初一</option>
							<option value="初二" style="color: rgb(0, 0, 0);">初二</option>
							<option value="初三" style="color: rgb(0, 0, 0);">初三</option>
							<option value="初四" style="color: rgb(0, 0, 0);">初四</option>
							<option value="高一" style="color: rgb(0, 0, 0);">高一</option>
							<option value="高二" style="color: rgb(0, 0, 0);">高二</option>
							<option value="高三" style="color: rgb(0, 0, 0);">高三</option>
						</select>
						<select name="subject" id="subject" style="float: right; color: rgb(204, 204, 204);" class="kemu">
							<option value="请选择" selected="" style="display: none; color: rgb(0, 0, 0);">--请选择科目--</option>
							<option value="数学" style="color: rgb(0, 0, 0);">数学</option>
							<option value="语文" style="color: rgb(0, 0, 0);">语文</option>
							<option value="英语" style="color: rgb(0, 0, 0);">英语</option>
							<option value="地理" style="color: rgb(0, 0, 0);">地理</option>
							<option value="政治" style="color: rgb(0, 0, 0);">政治</option>
							<option value="科学" style="color: rgb(0, 0, 0);">科学</option>
							<option value="历史" style="color: rgb(0, 0, 0);">历史</option>
							<option value="生物" style="color: rgb(0, 0, 0);">生物</option>
							<option value="物理" style="color: rgb(0, 0, 0);">物理</option>
							<option value="化学" style="color: rgb(0, 0, 0);">化学</option>
						</select>
					</p>
					<p class="F-button">
						
						<button class="submit" type="button" onclick="operate('save');"></button>
					</p>
				</form:form>
			</div>
			<div class="select select3">
				<h1 style="background: url('./mobile_web/image/P1-top.jpg') no-repeat left; background-size: cover"></h1>
				<p class="color_red_bold">上海辉斌教育科技有限公司</p>
				<p>国内知名教育品牌</p>
				<div class="select3-img">
					<img src="./mobile_web/image/University.gif" alt="国内知名教育品牌" title="国内知名教育品牌"></div>
				</div>
				<div class="select select4">
					<h1 style="background: url('./mobile_web/image/P2-top.jpg') no-repeat right; background-size: cover"></h1>
				<div class="center">
				<div class="center-img">
					<img src="./mobile_web/image/P2.jpg" width="98%" height="auto">
				</div>
				<button>
					<a href="javascript:void(0)" onclick="document.getElementById('myForm').scrollIntoView();"></a>
				</button>
			</div>
		</div>
		<div class="select select5">
			<h1 style="background: url('./mobile_web/image/P3-top.jpg') no-repeat left; background-size: cover"></h1>
			<ul>
				<li>
					<img src="./mobile_web/image/p1.png" alt="纪一晨" title="纪一晨">
					<div class="center">
						<h2>纪一晨</h2>
						<p>毕业于北京大学</p>
						<p>擅长全年级化学辅导</p>
						<p>锻炼举一反三能力，达到快速提升</p>
						<button>预约名师<a href="javascript:void(0)" onclick="document.getElementById('myForm').scrollIntoView();"></a></button>
					</div>
				</li>
				<li>
					<img src="./mobile_web/image/p2.png" alt="王小雅" title="王小雅">
					<div class="center">
						<h2>王小雅</h2>
						<p>毕业于北京大学</p>
						<p>擅于因材施教，擅长全年级英语辅导</p>
						<p>所带学生平均成绩提升41%</p>
						<button>预约名师<a href="javascript:void(0)" onclick="document.getElementById('myForm').scrollIntoView();"></a></button>
					</div>
				</li>
				<li>
					<img src="./mobile_web/image/p3.png" alt="胡建飞" title="胡建飞">
					<div class="center">
						<h2>胡建飞</h2>
						<p>毕业于北京大学</p>
						<p>物理特级 教师</p>
						<p>所带学生平均成绩提升39%</p>
						<button>预约名师<a href="javascript:void(0)" onclick="document.getElementById('myForm').scrollIntoView();"></a></button>
					</div>
				</li>
			</ul>
		</div>
		<div class="select select6">
			<h1 style="background: url('./mobile_web/image/P4-top.jpg') no-repeat right; background-size: cover"></h1>
			<div class="center">
				<span class="span1"></span> 
				<span class="span2"></span> 
				<span class="span3"></span> 
				<img class="translateX" src="./mobile_web/image/triangle.png" alt="电脑 平板 pad 手机 均可上课" title="电脑 平板 pad 手机 均可上课">
				<p style="font-weight: bold">电脑 平板 pad 手机 均可上课</p>
				<p class="color_red">让课堂更有趣，让学习更便捷</p>
				<p class="color_red">上课实时录制，课后随时温习</p>
				<p style="font-weight: bold">家长可旁听，教学效果一目了然</p>
			</div>
			<img class="weixin" src="./mobile_web/image/yd.jpg">
			<div class="bottom">
				<div class="p1"></div>
				<div class="p2"></div>
				<div class="p3"></div>
				<div class="center1">
					<img class="p6-0 translateX" src="./mobile_web/image/p6-0.png" alt="老师"> 
					<img class="p6-1 translateX p6" src="./mobile_web/image/p6-1.png" alt="班主任"> 
					<img class="p6-2 p6" src="./mobile_web/image/p6-2.png" alt="学科老师"> 
					<img class="p6-3 p6" src="./mobile_web/image/p6-3.png" alt="兼课老师"> 
					<img class="p6-4 p6" src="./mobile_web/image/p6-4.png" alt="心理辅导老师"> 
					<img class="p6-5 p6" src="./mobile_web/image/p6-5.png" alt="课程教研专员">
				</div>
			</div>
			<button>
				<a href="javascript:void(0)" onclick="document.getElementById('myForm').scrollIntoView();"></a>
			</button>
		</div>
		<div class="select select8">
			<div>
			<img src="./mobile_web/image/P6-top.jpg" width="100%" height="auto" >
			</div>
		</div>
		<footer>
			<a href="javascript:void(0)" onclick="document.getElementById('myForm').scrollIntoView();">
			<img src="./mobile_web/image/Signed.png"> 
			<span>立即预约</span></a> 
			<a href="tel:021-67677580">
				<img src="./mobile_web/image/tel.png"> 
				<span>
					<i class="translateY"></i>021-67677580
				</span>
			</a>
		</footer>
	</body>
</html>
