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
	<c:if test="${user != 'abc'}">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<jsp:setProperty property="*" name="vendors" />
	<c:redirect url="${sessionScope.vendors.deleteVendor()}.jsp"></c:redirect>
</body>
</html>