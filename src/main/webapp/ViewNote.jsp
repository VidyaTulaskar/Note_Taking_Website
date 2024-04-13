<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Bean.*,DAO.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Note Taker</title>
<style>
	html,body{
	    background-color: #B2B5E0;
		padding-top: 50px; 
  		height: 100%;
	}
	.container{
		width: 100%;
		display:flex;
		flex-direction: column;
		align-items: center;
	}
	.success_Msg{
		font-size: 23px;
		color: green;
		margin-bottom:40px;
		font-weight: 600;
	}
	.noteBox{
		margin: 0;
    	padding: 0;
    	width: 100%;
		position: relative;	
		display: inline-flex;
		flex-direction: row;
		flex-wrap: wrap;
		justify-content: space-between;
	}
	.noNotes{
		color: crimson;
		font-size: 20px;
		font-weight: 600;
		margin-bottom: 40px;
	}
	.note{
		width:360px;
		height:auto;
    	background-color: whitesmoke; 
    	padding: 30px;
    	font-size: 16px;
    	text-align: justify;
		margin-bottom:25px;
		transition: all 0.5s ease;   	
	}
	.note:hover{
		box-shadow: 4px 4px 10px rgb(83, 82, 82);
	}
	.ntitle{
		font-size: 17px;
		font-weight:600;
	}
	.ndate{
		color: rgb(0, 0, 128);
		font-size: 14px;
		margin-left:160px;
	}
	.ndesc{
		margin-top:10px;
		margin-bottom:30px;
	}
	.nlink{
		margin-left:60px;
		display: inline-flex;
		flex-direction: row;
			
	}
	.nedit,.ndelete{
		background-color:#9071c9;
		color: white;
		width: 80px;
		text-align: center;
		padding: 10px;
		transition:all 0.3s ease;		
	}
	.nedit:hover{	
		text-decoration: none;
		color:white;
		background-color:#FFA500;
	}
	.ndelete:hover{
		text-decoration: none;
		color:white;
		background-color:crimson;
	}
</style>
</head>
<body>
<div class="container">
<%@ include file="Nav.jsp" %>
<div class="success_Msg">
<%
	String msg = (String)request.getAttribute("msg");
	out.println(msg);
	
%>
</div>
<div class="noNotes">
<%
	ArrayList<NoteBean> al = new ViewNoteDAO().retrieve(ub.getuName());
	if(al.size()== 0)
	{
		out.println("No notes are there for reading....<br/>");
	}
	else
	{
%>
</div>
<div class="noteBox">
<%
		Iterator<NoteBean> it = al.iterator();
		while(it.hasNext())
		{
			NoteBean nb = it.next();
%>
	<div class="note">
		<div class="ntitle"><%= nb.getTitle() %></div>
		<span class="ndate"><%= nb.getDatetime() %></span>
		<div class="ndesc"><%= nb.getNote() %></div>
		<div class="nlink">
			<a class="nedit" href='edit?id=<%= nb.getId()%>'>Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="ndelete" href='delete?id=<%= nb.getId()%>'>Delete</a>
		</div>
	</div>
<%
		}
	}
%>
</div>
</div>
</body>
</html>