<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4><strong>Err Message: </strong>${pageContext.exception.message}</h4>
<h4><strong>Err Message: </strong><%= exception.getMessage()%></h4>

<h4><strong>Err status: </strong>${pageContext.errorData.statusCode}</h4>
<h4><strong>Err status: </strong><%= pageContext.getErrorData().getStatusCode()%></h4>

<h4><strong>Err cause: </strong>${pageContext.exception.cause}</h4>
<h4><strong>Err cause: </strong><%= pageContext.getException().getCause() %></h4>

<h4><strong>Err URI: </strong>${pageContext.errorData.requestURI}</h4>
<h4><strong>Err URI: </strong><%= pageContext.getErrorData().getRequestURI() %></h4>

<h4><strong>Err Throwable: </strong>${pageContext.errorData.throwable}</h4>

</body>
</html>