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
	if(!sessionChecker.checkUser())
		response.sendRedirect("log.jsp");

  	Carpooling carpooling=(Carpooling)request.getAttribute("carpooling");
  	int leaved_num = 0;
  	if(carpooling==null){
  		response.sendRedirect("log.jsp");
  	}
  	if( carpooling!=null ){
  		leaved_num = carpooling.getTotal_passangers() - carpooling.getJoined_passangers();
  	}
  	
  	
  %>
	<jsp:include page="header.jsp" flush="true" />
<div class="body">
<div class="body_bg">
	<div class="search">
		拼车详细信息
	</div>

	<div class="body_left" style="height:535px;">
		<div style="width:342px;height:425px;float:left;margin:20px;" id="dituContent"></div>
	   
	</div>
	<div class="list">
		<div class="tr to_line">出发城市：<span><%=carpooling.getSource()%></span><div><img src="blue/to_line.gif" /></div>目的城市：<span><%=carpooling.getDestiny()%></span></div>
		<div class="tr time">出发时间：<span><%=carpooling.getDate()%></span></div>
		<div class="hr"></div>

		<div class="tr ml4">
			<div class="t32"><span>总路程约：</span><%=carpooling.getDistance()%>公里</div>
			<div class="t32"><span>汽油费约：</span><span class='money'><%=carpooling.getGasoline_fee()%> 元</span></div>
			<div class="t32"><span>路桥费约：</span><span class='money'><%=carpooling.getRoad_fee()%> 元</span></div>
		</div>
		<div class="tr ml4">
			<div class="t32"><span>可容纳人数：</span><%=carpooling.getTotal_passangers()%> 人</div>
			<div class="t32"><span>已报名人数：</span><%=carpooling.getJoined_passangers()%> 人</div>
			<div class="t32"><span>剩余人数：</span><%=leaved_num %> 人</div>
		</div>
		<div class="tr ml4">
			<div class="t32"><span>汽车类型：</span><%=carpooling.getCar_type()%></div>
			<div class="t32"><span>费用方式：</span><span class='green'>面议</span></div>
		</div>
		<div class="tr ml4">
			<span class="ico_type_car">车主留言：</span>
			<div class="content">
				<div style="margin:0px;width:70%;float:left;">
				<%=carpooling.getIntro()%>
				</div>
				<div style="margin:0px;width:30%;float:left;">
					<div class="postInfo" style="width:164px;"><a href="CarpoolingServlet?type=join&&carpooling_id=<%=carpooling.getCarpooling_id()%>" >申请加入</a></div>
				</div>
			</div>
		</div>
		<div class="tr op">
			<a href='javascript:void(0)'><u></u>拼车留言</a>
			
		</div>
		<div>
		<form name="form2" method="post" action="MessageServlet?type=add&&carpooling_id=<%=carpooling.getCarpooling_id()%>" >
			<textarea cols=40 rows=8 name="message_content" style="background-color:BFCEDC;margin-left:15px;width:550px;" id="messageArea"></textarea>
			 <input type="submit" id="Button1" value="发表留言" style="width:80px; height:40px;margin-top:0px;font-size:14px;line-height:40px;float:right;margin-right:10px;" />
		</form>
		</div>

	</div><!--   end of list-->
</div>
</div>


<%@ include file="footer.jsp" %>

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
