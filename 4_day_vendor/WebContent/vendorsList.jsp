<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="vendors" class="vn.bean.VenOperationBean"
	scope="session"></jsp:useBean>
<body>
	<h4>Welcome ${sessionScope.vendors.logDetails.name}</h4>
	<h4>Vendors List</h4>
	<h4 style="color: brown;">${sessionScope.vendors.statusMsg}</h4>
	<table border="1" style="border-collapse: collapse;width: 90%;text-align: left">
		<tr style="background: black;color:snow">
			<th>Sr.</th>
			<th>Name</th>
			<th>Email</th>
			<th>City</th>
			<th>Phone No</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${sessionScope.vendors.allVendors}" var="vendor">
			<tr>
				<td></td>
				<td>${vendor.name}</td>
				<td>${vendor.email}</td>
				<td>${vendor.city}</td>
				<td>${vendor.cell_no}</td>
				<td><a href='updateVendor.jsp?vid=${vendor.id}'>Update</a> | <a
					href='deleteVendor.jsp?vid=${vendor.id}'>Delete</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="center"><a href='addVendor.jsp'>Add
					New Vendor</a></td>
		</tr>
	</table>
	${sessionScope.vendors.unset()}
</body>
</html>