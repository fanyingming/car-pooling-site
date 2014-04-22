<%@ page language="java" import="java.util.*,com.project.javabean.*,com.project.util.*,
java.util.Map.Entry,com.project.service.*" pageEncoding="utf-8"%>
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
		LogService logService = new LogService();
		UserService userService = new UserService();
		CarpoolingService carpoolingService = new CarpoolingService();
		int log_num = logService.getLogTotalNum();
		int user_num= userService.getUserTotalNum();
		int carpooling_num = carpoolingService.getCarpoolingTotalNum();
		TreeMap<String,Integer> sourceMaps   = logService.getCarpoolingSources();
		TreeMap<String,Integer> destinyMaps  = logService.getCarpoolingDestinies();
		int source_num = sourceMaps.size();
		int destiny_num= destinyMaps.size();
%>

	<jsp:include page="navi_admin.jsp" flush="true" />
<div class="body">
<div class="body_bg">
	<div style="width:60%;margin:auto;padding:20px;font-size:20px;margin-top:50px;">
	<table class="tongjiTable">
		<tr class="table_head">
			<td class="table_left">信息类别</td>
			<td class="table_right">信息统计</td>
		</tr>
		<tr>
			<td class="table_left">访问人次</td>
			<td class="table_right"><a href="#"><%=log_num %></a>人次</td>
		</tr>
		<tr>
			<td class="table_left">注册用户</td>
			<td class="table_right"><a href="#"><%=user_num %></a>人</td>
		</tr>
		<tr>
			<td class="table_left">申请拼车人数</td>
			<td class="table_right"><a href="#"><%=carpooling_num %></a>人</td>
		</tr>
		<tr>
			<td class="table_left">出发地点统计</td>
			<td class="table_right">
				<%  Iterator <Entry<String,Integer>>  it  =  sourceMaps.entrySet().iterator();  
				while(it.hasNext()){
					Entry<String, Integer> en = it.next();
					String source= en.getKey();
					int value = en.getValue(); 
				%>
					<%=source%><a href="#"><%=value %></a>个
					<br>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class="table_left">到达地点统计</td>
			<td class="table_right">
				<%  Iterator <Entry<String,Integer>>  it1  =  destinyMaps.entrySet().iterator();  
				while(it1.hasNext()){
					Entry<String, Integer> en = it1.next();
					String destiny= en.getKey();
					int value = en.getValue(); 
				%>
					<%=destiny%><a href="#"><%=value %></a>个
					<br>
				<%} %>
				
			</td>
		</tr>
	</table>
	
			
	</div>
</div>
</div>
<%@ include file="footer.jsp" %>

</body>
</html>
