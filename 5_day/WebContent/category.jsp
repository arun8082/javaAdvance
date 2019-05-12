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
	<h4>${sessionScope.shop.status}</h4>
	<h3>Welcome ${sessionScope.shop.details.name}</h3>
	<br />
	<%-- ${sessionScope.shop.getAllCategories()} --%>

	<form action="categoryDetails.jsp" method="get">
		<label>Choose category</label>
		<select name="category">
		<option value="">Select Category</option>
			<c:forEach items="${sessionScope.shop.allCategories}" var="item">
				<option value="${item}">${item}</option>
			</c:forEach>
		</select>
		<br/><br/>
		<input type="submit" value="Choose"/>
		<input type="submit" value="Show Cart" formaction="showCart"/>
	</form>
</body>
</html>