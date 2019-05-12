<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="err_handler.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int a = 12234;
		int b = 0;
		int result = a / b;
	%>
	<h4>
		Result:
		<%=result%></h4>
</body>
</html>