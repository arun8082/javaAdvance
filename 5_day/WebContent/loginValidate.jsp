<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="shop" class="bs.jbean.BookShopBean" scope="session"/>
<jsp:setProperty property="*" name="shop"/>
<body>
	<h3>Login validate page</h3>
	<jsp:forward page="${sessionScope.shop.validateCustomer()}.jsp"></jsp:forward>
</body>
</html>