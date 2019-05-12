<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4></h4>
	<h4>Login</h4>
	<h4 style="color: brown;">${sessionScope.vendors.statusMsg}</h4>

	<form action="authenticateLogin.jsp" method="post">
		<table>
			<tr>
				<td><label>Email</label></td>
				<td><input type="email" name="email" value="" /></td>
			</tr>
			<tr>
				<td><label>Password</label></td>
				<td><input type="password" name="password" value="" /></td>
			</tr>
			<tr>
				<td><label></label></td>
				<td><input type="submit" name="login" value="login" /> <input
					type="reset" name="reset" value="Reset" /></td>
			</tr>
		</table>
	</form>
	${sessionScope.vendors.unset()}
</body>
</html>