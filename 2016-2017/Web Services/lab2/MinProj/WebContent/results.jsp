<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@page import = "smallNumbers.SmallestNumber" %>
	<% 
		int input1 = Integer.parseInt(request.getParameter("input1"));
		int input2 = Integer.parseInt(request.getParameter("input2"));
		int input3 = Integer.parseInt(request.getParameter("input3"));
		SmallestNumber sn = new SmallestNumber();
		int small = sn.getSmallestNumber(input1, input2, input3);
		System.out.print("small number: "+small);
	%>
	
	<h1>Small number: <% out.print(small); %></h1>
	<a href = "index.jsp">Back to index</a>
	
</body>
</html>