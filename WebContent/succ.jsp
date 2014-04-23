<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="style-1.css" rel="stylesheet" />
<title>拼车网</title>
</head>
<body>
<jsp:include page="header.jsp" flush="true" />
<div class="body">
<div class="body_bg">
 	   <%
      	if(request.getAttribute("result")!=null){
       %>
      	<div class="search" style="font-family:'微软雅黑';font-size:30px;color:black;margin-top:60px;text-align:center;">
		<span style="color:blue;">
			<%  if(request.getAttribute("result")!=null){
       		%>	 
      			<h2><%=(String)request.getAttribute("result") %></h2>
	      <%} %>
		</span>
	</div>
      <%} %>



	
	
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
	  
	  
	  
	  
</body>
</html>