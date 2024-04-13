<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Note Taker</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
  	body { 
  		padding-top: 70px; 
  	}
  	.logo{
		font-family: Papyrus, fantasy;
		font-weight: 600;
	}
	.container{
		width: 100%;
		display:flex;
		flex-direction: column;
		align-items: center;
		
		/*margin-left: 1000px;*/
	}
	.success_Msg{
		font-size: 23px;
		font-weight: 600;
		color: green;
		margin-bottom:40px
		/*margin-bottom:20px;*/
	}
  </style>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
  		<div class="container-fluid">
    		<div class="navbar-header">
      			<a class="navbar-brand logo"  style="color:cyan;" href="#">Note Taker</a>
    	</div>
    	<ul class="nav navbar-nav">
      		<li class="active"><a href="index.html"><span class="glyphicon glyphicon-home"></span> Home</a></li>
      		<li class="disabled"><a href="#"><span class="glyphicon glyphicon-plus"></span> Add Note</a></li>
	  		<li class="disabled"><a href="#"><span class="glyphicon glyphicon-eye-open"></span> Show Notes</a></li>
    	</ul>
    	<ul class="nav navbar-nav navbar-right">
      		<li><a href="register.html"><span class="glyphicon glyphicon-user"></span> Register</a></li>
      		<li><a href="login.html"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    	</ul>
  		</div>
	</nav>
<div class="container">
<div class="success_Msg">
<%
	session.invalidate();
	out.println("Loggout Successfully....<br>");
%>
</div>
<jsp:include page="login.html"/>
</div>
</body>
</html>