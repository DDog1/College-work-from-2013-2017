<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<%@page import = "soapCRUD.CRUD" %>
	<%@page import = "soapCRUD.Book" %>
	<%@page import="java.util.Vector"%>
	<% 
		CRUD manager = new CRUD();
		Vector<Book> books = new Vector<Book>();
		books = manager.loadXmlFile();
		//manager.saveXmlFile();
	%>
	
	<h1>Display: Books<% out.print(""); %></h1>
	<table>
		<tr>
			<th>Book Name</th><th>Author</th><th>Publish Date</th><th>ISBN</th><th>Description<th>Price</th><th>Options</th>
			<%
			int index=0;
			for(Book temp:books){
				out.print("<tr>");
				out.print("<td>"+temp.getBookName()+"</td>");
				out.print("<td>"+temp.getAuthor()+"</td>");
				out.print("<td>"+temp.getPublishDate()+"</td>");
				out.print("<td>"+temp.getIsbn()+"</td>");
				out.print("<td>"+temp.getDescription()+"</td>");
				out.print("<td>"+temp.getPrice()+"</td>");
				
				out.print("<td><a href='remove.jsp?index="+index+"'>Remove</a>");
				out.print("<a href='update.jsp?index="+index+"'>Update</a></td>");
				out.print("</tr>");
				index++;
			}
			%>
		</tr>
	</table>
<a href="add.jsp">Add</a>
<a href="display.jsp">Display</a>
</body>
</html>