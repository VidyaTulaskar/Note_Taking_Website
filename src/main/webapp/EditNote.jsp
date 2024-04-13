<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Bean.NoteBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Note Taker</title>
<style>
		html,body{
    		height: 100%;
    		margin: auto;
    		display: flex;
   		 	align-items: center;
		}
		.container{
			width: 100%;
			display:flex;
			flex-direction: column;
			align-items: center;
	}
		.edit_form{
  			background-color: whitesmoke; 
    		padding: 40px;
			height: 400px;
			font-size: 17px;
			box-shadow: 10px 10px 10px rgb(83, 82, 82);
			margin-left:370px;
  		}
  		.main_text{
			font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
			color: rgb(0, 0, 128);
			font-size: 30px;
		}
  		input[type="submit"]{
			background-color:#9071c9;
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
<%@ include file="Nav.jsp" %>
<%
	NoteBean nb = (NoteBean)request.getAttribute("nbean");
%>
<form action="update" method="post" class="edit_form">
	<span class="main_text"><center><u>Edit Note</u></center></span><br>
	<input type="hidden" name="id" value=<%= nb.getId() %>>
	<label for="title">Title</label>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="title" type="text" name="title" style="width: 500px;" value="<%=nb.getTitle()%>" required><br/>
	<label for="desc" style="display: inline-block; vertical-align: top;">Description</label>
	<textarea id="desc" name="note" style="width: 500px; height: 150px;" required><%=nb.getNote()%></textarea><br/>
	<center><input type="submit" value="Save"/></center>
</form>
</div>
</body>
</html>