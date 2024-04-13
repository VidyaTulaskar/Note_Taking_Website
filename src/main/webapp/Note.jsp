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
		html,body{
    		height: 100%;
    		margin: auto;
		}
  		body{
	 		background-color: #B2B5E0;
  		}
  		.container{
			width: 100%;
			display:flex;
			flex-direction: column;
			align-items: center;
			margin-top: 50px;
		}
  		.login_form{
  			background-color: whitesmoke; 
    		padding: 40px;
			height: 430px;
			font-size: 17px;
			box-shadow: 10px 10px 10px rgb(83, 82, 82);
			margin-bottom: 60px;
			position: relative;
  		}
  		.main_text{
			font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
			color: rgb(0, 0, 128);
			font-size: 30px;
		}
  		input[type="submit"]{
			background-color:#9071c9;
			padding: 8px;
			color: white;
			width: 80px;
			transition:all 1s ease;
		}
		input[type="submit"]:hover{
			background-color:#a28bce;
			box-shadow: 2px 2px 6px black;
		}
		#title{
			margin-bottom: 20px;
		}
		#desc{
			margin-bottom: 15px;
		}
  </style>
</head>
<body>
<div class="container">	
<%@ include file="AddNav.jsp" %>
<form action="add" method="post" class="login_form">
	<span class="main_text"><center><u>Note</u></center></span><br>
	<label for="title">Tile</label>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="title" id="title" style="width: 500px;" required><br/>
	<label for="desc" style="display: inline-block; vertical-align: top;">Description</label>
	&nbsp;<textarea name="note" id="desc" style="width: 500px; height: 150px;" required></textarea><br/>
	<center><input type="submit" value="Save"/></center>
</form>
</div>
</body>
</html>