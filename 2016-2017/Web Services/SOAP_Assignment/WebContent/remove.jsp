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
	<% 
		int index = Integer.parseInt(request.getParameter("index"));
		CRUD manager = new CRUD();
		String result = manager.remove(index);
		manager.saveXmlFile();
		out.print(""+result);
		out.print("<a href='display.jsp'>Display</a>");
	%>
</body>
</html>