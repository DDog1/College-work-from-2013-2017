<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@page import = "maths.Hypotenuse" %>
	<% 
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		Hypotenuse h = new Hypotenuse();
		double result = h.getHypotenuse(a, b);
		System.out.print("Hypotenuse: "+result);
	%>
	
	<h1>Hypotenuse: <% out.print(result); %></h1>
	<a href = "index.jsp">Back to index</a>
	
</body>
</html>