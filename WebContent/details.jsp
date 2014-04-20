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
<script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
</head>
<body>
	<div style="width:100%;">
		<div class="head" style="height:125px;padding-bottom:0px;">
			<div style="width:47%;float:left;margin-left:3%;">
				<a href="index.html" style="font-size:45px;color:white;font-family:'微软雅黑';">拼车网</a>
			</div>
			<div style="width:50%;float:left;">
				<div class="logArea" >
					<a href="log.jsp">登录</a>
				</div>
				<div class="logArea">
					<a href="log.jsp">注册</a>
				</div>

			</div>		
		</div>
	</div>
<div class="body">
<div class="body_bg">
	<div class="search">
		拼车详细信息
	</div>

	<div class="body_left" style="height:535px;">
		<div style="width:342px;height:425px;float:left;margin:20px;" id="dituContent"></div>
	   
	</div>
	<div class="list">
		<div class="tr to_line">出发城市：<span>平顶山</span><div><img src="blue/to_line.gif" /></div>目的城市：<span>长沙</span></div>
		<div class="tr time">出发时间：<span>2014-04-18 早上(6:00-11:00)</span></div>
		<div class="hr"></div>

		<div class="tr ml4">
			<div class="t32"><span>总路程约：</span>811.0公里</div>
			<div class="t32"><span>汽油费约：</span><span class='money'>515 元</span></div>
			<div class="t32"><span>路桥费约：</span><span class='money'>340 元</span></div>
		</div>
		<div class="tr ml4">
			<div class="t32"><span>可容纳人数：</span>7 人</div>
			<div class="t32"><span>已报名人数：</span>2 人</div>
			<div class="t32"><span>剩余人数：</span>5 人</div>
		</div>
		<div class="tr ml4">
			<div class="t32"><span>汽车类型：</span>轿车</div>
			<div class="t32"><span>费用方式：</span><span class='green'>面议</span></div>
		</div>
		<div class="tr ml4">
			<span class="ico_type_car">车主留言：</span>
			<div class="content">
				<div style="margin:0px;width:70%;float:left;">
				
				回娘家走亲戚<br/>联系我时，请说是在拼车网上看到的，谢谢！
				</div>
				<div style="margin:0px;width:30%;float:left;">
					<div class="postInfo" style="width:164px;"><a href="javascript:void(0)" >申请加入</a></div>
				</div>
			</div>
		</div>
		<div class="tr op">
			<a href='javascript:void(0)'><u></u>拼车留言</a>
			
		</div>
		<div>
			<textarea cols=40 rows=8 name=text style="background-color:BFCEDC;margin-left:15px;width:550px;" id="messageArea"></textarea>
			<button style="width:80px; height:40px;margin-top:0px;font-size:14px;line-height:40px;float:right;margin-right:10px;">发表留言</button>
		</div>

	</div><!--   end of list-->
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

<script type="text/javascript">
    //创建和初始化地图函数：
    function initMap(){
        createMap();//创建地图
        setMapEvent();//设置地图事件
        addMapControl();//向地图添加控件
    }
    
    //创建地图函数：
    function createMap(){
        var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
        var point = new BMap.Point(116.403875,39.91168);//定义一个中心点坐标
        map.centerAndZoom(point,11);//设定地图的中心点和坐标并将地图显示在地图容器中
        window.map = map;//将map变量存储在全局
    }
    
    //地图事件设置函数：
    function setMapEvent(){
        map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
        map.enableScrollWheelZoom();//启用地图滚轮放大缩小
        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
        map.enableKeyboard();//启用键盘上下左右键移动地图
    }
    
    //地图控件添加函数：
    function addMapControl(){
        //向地图中添加缩放控件
	var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
	map.addControl(ctrl_nav);
        //向地图中添加缩略图控件
	var ctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:1});
	map.addControl(ctrl_ove);
        //向地图中添加比例尺控件
	var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
	map.addControl(ctrl_sca);
    }
    
    
    initMap();//创建和初始化地图
</script>

</body>
</html>
