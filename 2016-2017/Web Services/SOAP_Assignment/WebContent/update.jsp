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
		int index = Integer.parseInt(request.getParameter("index"));
		CRUD manager = new CRUD();
		Vector<Book> books = new Vector<Book>();
		books = manager.display();
		Book t = books.elementAt(index);
	%>
		<form action="updateResult.jsp" method="get">
			Index<input type = "text" name="index" value="<% out.print(index); %>" required><br>
			Book Name<input type = "text" name="bookName" value="<% out.print(t.getBookName()); %>" required><br>
			Author<input type = "text" name="author" value="<% out.print(t.getAuthor()); %>" required><br>
			Publish Date<input type = "text" name="publishDate" value="<% out.print(t.getPublishDate()); %>" required><br>
			ISBN<input type = "text" name="isbn" value="<% out.print(t.getIsbn()); %>" required><br>
			Description<input type = "text" name="description" value="<% out.print(t.getDescription()); %>" required><br>
			Price<input type = "number" name="price" value="<% out.print(t.getPrice()); %>" required><br>
			<input type="submit" value="Submit"><input type="reset" value="Reset">
		</form>
	<%
		out.print("<a href='display.jsp'>Display</a>");
	%>
</body>
</html>