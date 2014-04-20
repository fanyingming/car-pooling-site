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
			<div class="postInfo"><a href="javascript:void(0)" title="车主发布长途拼车信息" rel="nofollow">发布拼车</a></div>
			 <div class="menu">
				<a class="x select" href=#">拼车查询</a>
			</div>
		</div>
	</div>
<div class="body">
<div class="body_bg">
	<div class="search">
			<form id="search" action=""><!--	搜索表单		-->
				出发城市：
				<input plugin="start" id="search_start" name="start" value="北京" class="f" type="text" />
				目的城市：
				<input plugin="end" id="search_end" name="end" value="" class="f" type="text" />
				出发时间：
				<input  name="time" value="" class="f" type="text" />
				<a id="to_search" class="x search" href="javascript:void(0)" rel="nofollow">搜索</a>
			</form>
	</div>
	<div class="body_left" style="height:535px;">
        <div style="width:342px;height:425px;float:left;margin:20px;" id="dituContent"></div>
    </div>
	<div class="list">
		<div style="min-height:450px;">
			<div class="my_tabs_index">
			<a><u></u>最新拼车信息</a>
			<span class="ico_type_txt">图释：</span>
			<span class="ico_type_car">车主</span>
			<span class="ico_type_man">乘客</span>
			</div>
			<ul class="table index title">
				<li class="t1">类型</li>
				<li class="t2">出发日期</li>
				<li class="t3">费用</li>
				<li class="t4">车型</li>

				<li class="t5">出发城市</li>
				<li class="t6">目地城市</li>

				<li class="t7">操作</li>
			</ul>
			<!--	从数据库里面读取数据并显示		-->
			<ul class="table index interleaved_0">
				<li class="t1"><span class='ico_type_car'>&nbsp;</span></li>
				<li class="t2">04-18 早上</li>
				<li class="t3"><span class='green'>面议</span></li>
				<li class="t4">轿车</li>

				<li class="t5">平顶山</li>
				<li class="t6">益阳</li>

				<li class='t7'><a class2baidu='details' target='_blank' href='http://www.pcwcn.com/拼车/192078' title='查看详情'>申请加入</a></li>
			</ul>



		</div>


		<div class='pages'>
			<a class='btn-prev' href='#''>上一页</a>
						<a class='btn-next' href='#'>下一页</a>
			<span>共 1 条记录</span>
		</div>
    </div>



<!--
-->
</div></div>
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