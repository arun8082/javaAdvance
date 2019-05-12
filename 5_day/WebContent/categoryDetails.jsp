<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<jsp:setProperty property="*" name="shop" />
<body>
	<h3>Category Details page</h3>
	<h3>Welcome ${sessionScope.shop.details.name}</h3>
	<br />
	<h3>Choosed category ${sessionScope.shop.category}</h3>
	<form action="addToCart0.jsp" method="get">
		<table border="1" style="border-collapse: collapse;">
			<tr>
				<th></th>
				<th>Title</th>
				<th>Author</th>
				<th>Price</th>
			</tr>
			<c:forEach items="${sessionScope.shop.booksListByCategory}"
				var="book">
				<tr>
					<td><input type="checkbox" name="bookId" value="${book.id}" /></td>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td align="right">${book.price}</td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="submit" value="Add To Cart" /></td>
			</tr>
		</table>
	</form>
</body>
</html>