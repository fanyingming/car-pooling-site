<%@ page language="java" import="java.util.*,com.project.javabean.*,
com.project.service.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="width:100%;">
		<div class="head" style="height:125px;padding-bottom:0px;">
			<div style="width:47%;float:left;margin-left:3%;">
				<a href="index.jsp" style="font-size:45px;color:white;font-family:'微软雅黑';">拼车网管理系统</a>
			</div>
			<div style="width:50%;float:left;">
			<%
				if(session.getAttribute("administrator")!=null){
					Administrator administrator=(Administrator)session.getAttribute("administrator");
			%>
			<span style="float:right;"><%=administrator.getAdministrator_name()%>，欢迎！&nbsp;[<a href="AdministratorServlet?type=exit" id="exit-button">退出</a>]</span>   
			<% }else{%>
     		
	  		<%}%>
			</div>
			
	
		</div>
	</div>
</body>
</html>