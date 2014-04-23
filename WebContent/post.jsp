<%@ page language="java" import="java.util.*,com.project.javabean.*,com.project.util.*,
com.project.service.*" pageEncoding="utf-8"%>
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
<%
	SessionChecker sessionChecker = new SessionChecker(request);
	if(!sessionChecker.checkUser()){
		response.sendRedirect("log.jsp");
		return;
	}
 %>
	<jsp:include page="header.jsp" flush="true" />
<div class="body">
	<div class="body_bg">
		<div class="search">
			发布拼车信息
		</div>
		<form name="form1" method="post" action="CarpoolingServlet?type=add" >
		<div>
			<div class="body_left" style="height:535px;">
				<div style="width:342px;height:425px;float:left;margin:20px;" id="dituContent"></div>    
			</div>
			<div class="list">
				<div class="tr ml4"><span class="ico_type_car" />拼车信息：</div>
				
				<div class="tr to_line">
					<div style="width:50%;float:left;margin:0px;">
						<div style="margin:0px">
						出发城市：<input type="text" name="source" />
						</div>
						<div style="margin:0px">
						出发时间：<input type="text" name="date" />
						</div>
						<div style="margin:0px">
						总路程约：<input type="text" name="distance" />公里
						</div>
						<div style="margin:0px">
						可容纳人数：<input type="text" name="total_passangers" />
						</div>
					</div>
					<div style="width:50%;float:left;margin:0px;">
						<div style="margin:0px">
						目的城市：<input type="text" name="destiny" />
						
						</div>
						<div style="margin:0px">
						汽油费约：<input type="text" name="gasoline_fee" />元
						</div>
						<div style="margin:0px">
						路桥费约：<input type="text" name="road_fee" />元
						</div>
						<div style="margin:0px">
						汽车类型：<input type="text" name="car_type" />
						</div>
					</div>
					
				</div>
				<div class="hr"></div>
				<div class="tr ml4"><span class="ico_type_car" />附加介绍：</div>
			</div>
			<div>
				<textarea cols=40 rows=8 name="intro" style="background-color:BFCEDC;margin-left:15px;width:550px;" id="messageArea"></textarea>
				 <input type="submit" id="Button1" value="发布信息" style="width:80px; height:40px;margin-top:0px;font-size:14px;line-height:40px;float:right;margin-right:30px;" />
			</div>
		</div>
		</form>

	</div>
</div>
<%@ include file="footer.jsp" %>

<script type="text/javascript">
var cpro_id = "u1102181";
</script>
<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>
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
