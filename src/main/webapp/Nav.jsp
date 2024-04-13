<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Bean.UserBean,Bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Note Taker</title>
<link rel="stylesheet" href="style.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
  	body { 
  		padding-top: 70px;
  		background-color: #B2B5E0; 
  	}
  	.user{
  		font-family: Arial;
		margin-top: 15px;
		color: #dfd3f4;
  	}
 	.logo{
		font-family: 'Lobster', cursive;
    	font-weight: 600;
    	font-size: 30px;
	}
  </style>
</head>
<body>
	<%
		UserBean ub = (UserBean)session.getAttribute("ubean");
	%>
	<nav class="navbar navbar-inverse navbar-fixed-top">
  		<div class="container-fluid">
    		<div class="navbar-header">
      			<a class="navbar-brand logo"  style="color: #dfd3f4;" href="#">Note Taker</a>
    		</div>
    	<ul class="nav navbar-nav">
      		<li><a href="index.html"><span class="glyphicon glyphicon-home"></span> Home</a></li>
      		<li><a href="Note.jsp"><span class="glyphicon glyphicon-plus"></span> Add Note</a></li>
	  		<li class="active"><a href="view"><span class="glyphicon glyphicon-eye-open"></span> Show Notes</a></li>
	  		<li><span class="nav navbar-nav user">&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-user"></span><strong> Welcome <%= ub.getfName() %></strong></span></li>
    	</ul>
    	<ul class="nav navbar-nav navbar-right">
      		<li><a href="Logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    	</ul>
  		</div>
	</nav>
</body>
</html>