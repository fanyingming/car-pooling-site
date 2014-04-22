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
		SessionChecker sessionChecker = new SessionChecker(request);	
		if(!sessionChecker.checkAdministrator()){
			response.sendRedirect("admin_log.jsp");
			return;
		}
		Administrator administrator = (Administrator)session.getAttribute("administrator");
		UserService userService=new UserService();
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
        intRowCount=userService.getUserTotalNum();
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
		List<User> list = userService.listAllUserOrderByUserId(begin, intPageSize ); 
 %>
	<jsp:include page="navi_admin.jsp" flush="true" />
<div class="body">
<div class="body_bg">
	<div class="search">
			
	</div>
	<div>
		<ul class="table title" style="margin-left:30px; width:90%;">
			<li class="t1" style="width:100px; ">编号</li>
			<li class="t2" style="width:100px; ">用户名</li>
			<li class="t3" style="width:150px; ">密码</li>
			<li class="t4" style="width:230px;">邮箱</li>
			<li class="t4" style="width:200px;">邮箱</li>
			<li class="t1" style="width:100px;">操作</li>
		</ul>
		 <%
         	if(list!=null){
        			for(int i=0;i<list.size();i++){
        			User user= (User)list.get(i);
    		 %>
		<ul class="table interleaved_0" style="margin-left:30px;width:90%;">
				<li class="t1" style="width:100px;"><%=user.getUser_id() %></li>
				<li class="t2" style="width:100px; "><%=user.getUser_name() %></li>
				<li class="t3" style="width:150px; "><span class='green'><%=user.getUser_pass() %></span></li>
				<li class="t4" style="width:230px;"><%=user.getUser_pass() %></li>
				<li class="t4" style="width:200px;"><%=user.getUser_phone() %></li>
				<li class='t7' style="width:100px;"><a href="UserServlet?type=delete&&user_id=<%=user.getUser_id() %>&&page=<%=intPage %>">删除</a></li>
		</ul>	
		<%} } %>
		<!--分页代码-->
		<div class='pages'>
			<a class='btn-prev' href="userManage.jsp?page=<%=intPage - 1%>">上一页</a>
			<a class='btn-next' href="userManage.jsp?page=<%=intPage + 1%>">下一页</a>
			<span>共 <span ><%=intPageCount %></span> 页 | 第 <span ><%=intPage %></span> 页|共<span ><%=intRowCount %></span>条记录</span>
		</div>
			
	</div>
<!--
-->
</div>
</div>


        
        

<%@ include file="footer.jsp" %>
</body>
</html>
