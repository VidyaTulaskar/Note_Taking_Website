<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Note Taker</title>
<style>
	.container{
		width: 100%;
		display:flex;
		flex-direction: column;
		align-items: center;
	}
	.success_Msg{
		font-size: 23px;
		font-weight: 600;
		color: green;
		margin-bottom:40px;
	}	
</style>
</head>
<body>	
<div class="container">
<div class="success_Msg">
<%
	String msg = (String)request.getAttribute("msg");
	out.println(msg);
%>
</div>
<jsp:include page="login.html"/>
</div>
</body>
</html>