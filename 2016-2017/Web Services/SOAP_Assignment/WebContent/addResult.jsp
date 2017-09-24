<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@page import = "soapCRUD.CRUD" %>
	<%@page import = "soapCRUD.Book" %>
	<% 
		String bookName = request.getParameter("bookName");
		String author = request.getParameter("author");
		String publishDate = request.getParameter("publishDate");
		String isbn = request.getParameter("isbn");
		String description = request.getParameter("description");
		double price = Double.parseDouble(request.getParameter("price"));
		CRUD manager = new CRUD();
		String result = manager.addBook(bookName, author, publishDate, isbn, description, price);
		manager.saveXmlFile();
		out.print(""+result);
		out.print("<a href='display.jsp'>Display</a>");
	%>
</body>
</html>