<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Data Records</h1>
<table border="1">
	<th>StoreId</th>
	<th>Store Name</th>
	<th>Zip Code</th>
	<th>Distance</th>
		<c:forEach items="${requestScope.list}" var="store">
		<tr>
			<td>${store.storeId}</td>
			<td>${store.storeName}</td>
			<td>${store.zipCode}</td>
			<td>${store.distance}</td>
		</tr>
		</c:forEach>
</table>

</body>
</html>