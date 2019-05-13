<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:setProperty property="*" name="vendors" />
<body>
	<c:if test="${sessionScope.vendors.authenticateLogin() == 'vendorsList'}">
		<c:set var="user" value="abc" scope="session"/>
	</c:if>
	<c:redirect url="${sessionScope.vendors.authenticateLogin()}.jsp" />
</body>
</html>