<%@ page language="java" import="java.util.*,com.project.javabean.*,
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
	String result="";
	String user_name="";
	boolean flag=false;
	if(request.getAttribute("result")!=null){
		result=(String)request.getAttribute("result");
		flag=true;
		user_name=(String)request.getAttribute("user_name");
	}
	//Administrator administrator = (Administrator)session.getAttribute("administrator"); 
 %>
	<jsp:include page="header_admin.jsp" flush="true" />
	
	<div class="body" style="height:500px;">
		<div class="body_bg">
			<div style="width:49%;margin:0px;float:left;border-right:1px solid;border-right-color:#77eeff;height:400px;">
				<form name="form1" method="post" action="AdministratorServlet?type=login" style="padding:30px;margin:auto;text-align:center;">
				<p style="width:100%;font-family:'微软雅黑';font-size:30px;">请管理员登录</p>
				<div class="logItem">用户名：
					<input type="text" name="user_name" class="myInput" style="
						width: 250px;
						background: none;
						border: 1px solid;
						border-color: #22a3ff;
						height: 40px;" 
						value="admin"
						/>
				</div>
				<div class="logItem">密码&nbsp;&nbsp;&nbsp;：
					<input type="password" name="user_pass" class="myInput" style="
						width: 250px;
						background: none;
						border: 1px solid;
						border-color: #22a3ff;
						height: 40px;" 
						value="123456";
						/>
				</div>
				<input type="submit" class="postInfo" style="margin-right:73px;" value="确认登录" />
				<%
				if(flag){
  	   			%>
      			<span style="color:#EA0000;font-size:18px;float:right;margin-right:80px;margin-left:10px;">*<%=result %>!!!</span>
       			<% } %>
				</form>
				
  	   				
			</div>
			
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
