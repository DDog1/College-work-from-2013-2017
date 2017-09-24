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
		<form action="addResult.jsp" method="get">
			Book Name<input type = "text" name="bookName" required><br>
			Author<input type = "text" name="author" required><br>
			Publish Date<input type = "text" name="publishDate" required><br>
			ISBN<input type = "text" name="isbn" required><br>
			Description<input type = "text" name="description" required><br>
			Price<input type = "number" name="price" required><br>
			<input type="submit" value="Submit"><input type="reset" value="Reset">
		</form>
</body>
</html>