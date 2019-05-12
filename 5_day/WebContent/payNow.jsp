<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome ${sessionScope.shop.details.name}</h3>
	<form action="payNow.jsp" method="get">
		<table>
			<tr>
				<td>Title</td>
				<td>Author</td>
				<td>Price</td>
			</tr>
			<c:forEach items="${sessionScope.shop.cartListDetails}" var="book">
				<tr>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td>${book.price}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3" align="right">Total ${sessionScope.shop.calculateTotal()}</td>
			</tr>
			<tr>
				<td><input type="submit" value="PayNow" /></td>
				<td><input type="submit" value="Continue" formaction="category.jsp"/></td>
			</tr>
		</table>
	</form>
</body>
</html>