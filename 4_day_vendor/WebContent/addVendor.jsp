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
	<h4>Welcome ${sessionScope.vendors.logDetails.name}</h4>
	<h4 align="right" style="margin-right: 100px;">
		<a href="logout.jsp">Logout</a>
	</h4>
	<h4>Registration Form</h4>
	<h4 style="color: brown;">${sessionScope.vendors.statusMsg}</h4>
	<form action="registration.jsp" method="post">
		<table>
			<tr>
				<td><label>Name</label></td>
				<td><input type="text" name="name" value="" /></td>
			</tr>
			<tr>
				<td><label>Email</label></td>
				<td><input type="email" name="email" value="" /></td>
			</tr>
			<tr>
				<td><label>Password</label></td>
				<td><input type="password" name="password" value="" /></td>
			</tr>
			<tr>
				<td><label>City</label></td>
				<td><input type="text" name="city" value="" /></td>
			</tr>
			<tr>
				<td><label>Phone No.</label></td>
				<td><input type="text" name="cell_no" value="" /></td>
			</tr>
			<tr>
				<td><label>Role</label></td>
				<td><input type="text" name="role" value="" /></td>
			</tr>
			<tr>
				<td><label></label></td>
				<td><input type="submit" name="register" value="register" /> <input
					type="reset" name="reset" value="Reset" /><input type="submit"
					value="Back" formaction="vendorsList.jsp" /></td>
			</tr>
		</table>
	</form>
	${sessionScope.vendors.unset()}
</body>
</html>