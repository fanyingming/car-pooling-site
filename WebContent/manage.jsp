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
</head>
<body>
<%
		CarpoolingService carpoolingService=new CarpoolingService();
	    int intPageSize; //一页显示的记录
        int intRowCount; //记录总数
        int intPageCount; //总页
        int intPage; //待显示页
        //设置一页显示的记录
        intPageSize = GlobalData.intPageSize_manage;
    		//取得待显示页
        String strPage = request.getParameter("page");
        if (strPage == null) {//表明在QueryString中没有page这一个参数，此时显示第一页数
            intPage = 1;
        } else {//将字符串转换成整
            intPage = java.lang.Integer.parseInt(strPage);
            if (intPage < 1) {
                intPage = 1;
            }
        }
        intRowCount=carpoolingService.getCarpoolingTotalNum();
        //记算总页
        intPageCount = (intRowCount + intPageSize - 1) / intPageSize;
   	 //调整待显示的页码
        if (intPage > intPageCount && intPageCount>0) {
            intPage = intPageCount;
        }
        if(intPageCount==0){
       		intPage=1;
        		intPageCount=1;
        }
        int begin=(intPage - 1) * intPageSize ;
		List<Carpooling> list = carpoolingService.listAllCarpoolingOrderByCarpoolingId(begin, intPageSize ); 
 %>
	<div style="width:100%;">
		<div class="head" style="height:125px;padding-bottom:0px;">
			<div style="width:47%;float:left;margin-left:3%;">
				<a href="index.jsp" style="font-size:45px;color:white;font-family:'微软雅黑';">拼车网管理系统</a>
			</div>
			<div style="width:50%;float:left;">
				<div class="logArea" >
					<a href="log.jsp">登录</a>
				</div>
				<div class="logArea">
					<a href="log.jsp">注册</a>
				</div>
			</div>
			
			 <div class="menu">
				<a class="x select" href="manage.jsp">拼车信息管理</a>
				<a class="x " href="messageManage.jsp">留言管理</a>
				<a class="x " href="userManage.jsp">用户管理</a>
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
		<%
         	if(list!=null){
        			for(int i=0;i<list.size();i++){
        				Carpooling carpooling= (Carpooling)list.get(i);
    		 %>
		<ul class="table interleaved_0" style="margin-left:30px;width:95%;">
				<li class="t1" style="width:130px;"><span class='ico_type_car'>&nbsp;</span></li>
				<li class="t2" style="width:130px;"><%=carpooling.getDate() %></li>
				<li class="t3" style="width:130px;"><span class='green'>面议</span></li>
				<li class="t4" style="width:130px;"><%=carpooling.getCar_type() %></li>

				<li class="t5" style="width:130px;"><%=carpooling.getSource() %></li>
				<li class="t6" style="width:130px;"><%=carpooling.getDestiny() %></li>

				<li class='t7' style="width:130px;"><a class2baidu='details' target='_blank' href="CarpoolingServlet?type=delete&&carpooling_id=<%=carpooling.getCarpooling_id() %>&&page=<%=intPage %>" >删除</a></li>
		</ul>	
		<%} } %>
		<!--分页代码-->
		<div class='pages'>
			<a class='btn-prev' href="manage.jsp?page=<%=intPage - 1%>">上一页</a>
			<a class='btn-next' href="manage.jsp?page=<%=intPage + 1%>">下一页</a>
			<span>共 <span ><%=intPageCount %></span> 页 | 第 <span ><%=intPage %></span> 页|共<span ><%=intRowCount %></span>条记录</span>
		</div>
			
			
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