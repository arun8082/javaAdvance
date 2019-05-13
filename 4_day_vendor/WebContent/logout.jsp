<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Session id: ${pageContext.session.id} ---logout page
	${pageContext.session.invalidate()}
	<%-- <c:redirect url="index.jsp"></c:redirect> --%>
	<a href="index.jsp">Visit Again</a>
</body>
</html>