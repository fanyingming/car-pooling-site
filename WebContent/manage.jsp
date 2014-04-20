<%@ page language="java" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>拼车网</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" href="style-1.css" rel="stylesheet" />
</head>
<body>
	<div style="width:100%;">
		<div class="head" style="height:125px;padding-bottom:0px;">
			<div style="width:47%;float:left;margin-left:3%;">
				<a href="index.html" style="font-size:45px;color:white;font-family:'微软雅黑';">拼车网管理系统</a>
			</div>
			<div style="width:50%;float:left;">
				<div class="logArea" >
					<a href="log.html">登录</a>
				</div>
				<div class="logArea">
					<a href="log.html">注册</a>
				</div>
			</div>
			
			 <div class="menu">
				<a class="x select" href="manage.html">拼车信息管理</a>
				<a class="x " href="messageManage.html">留言管理</a>
				<a class="x " href="userManage.html">用户管理</a>
			</div>
		</div>
	</div>
<div class="body">
<div class="body_bg">
	<div class="search">
			
	</div>
	<div>
		<ul class="table title" style="margin-left:30px; width:95%;">
			<li class="t1" style="width:130px;">类型</li>
			<li class="t2" style="width:130px;">出发日期</li>
			<li class="t3" style="width:130px;">费用</li>
			<li class="t4" style="width:130px;">车型</li>

			<li class="t5" style="width:130px;">出发城市</li>
			<li class="t6" style="width:130px;">目地城市</li>

			<li class="t7" style="width:130px;">操作</li>
		</ul>
		<ul class="table interleaved_0" style="margin-left:30px;width:95%;">
				<li class="t1" style="width:130px;"><span class='ico_type_car'>&nbsp;</span></li>
				<li class="t2" style="width:130px;">04-18 早上</li>
				<li class="t3" style="width:130px;"><span class='green'>面议</span></li>
				<li class="t4" style="width:130px;">轿车</li>

				<li class="t5" style="width:130px;">平顶山</li>
				<li class="t6" style="width:130px;">益阳</li>

				<li class='t7' style="width:130px;"><a class2baidu='details' target='_blank' href='#' title='查看详情'>删除</a></li>
		</ul>	
			
			
			
	</div>
<!--
-->
</div>
</div>
<div class="foot">
	<span>&#169; 2011-2013 <a href="#">拼车网</a> &nbsp; </span>
    <span>
    	<a rel="nofollow" href="#">关于我们</a> |
		<a href="#">合作伙伴</a> |
   
	</span>
</div>

        
        

<div class="foot">
    <span>
    	<a href="#">联系我们</a> |
        <a href="#">关于我们</a> |
    
	</span>
  
</div>
</div>
</body>
</html>