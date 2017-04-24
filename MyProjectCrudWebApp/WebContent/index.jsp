<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Web Application</title>
<center><h1>Welcome to the Application</h1></center>
</head>
<body>
<!-- <table border="1">
	<td><a href="AllStores">All Stores</a></td>
</table> -->
<form action="ServiceController" method="get">
<table>
<tr>
	<td> Enter StoreId   :</td> 
	<td><input type="text" name="storeid"></td>
</tr>

<tr>
	<td>Enter StoreName : </td>
	<td><input type="text" name="storename"></td>
</tr>

<tr>
	<td>Enter ZipCode	: </td>
	<td><input type="text" name="zipcode"></td>
</tr>

<tr>
	<td>Enter Distance	: </td>
	<td><input type="text" name="distance"></td>
</tr>

<tr>
<td colspan="2">
	<button type="submit" name="Add"    value="Add">Add</button>
	<button type="submit" name="Update" value="Update">Update</button>
	<button type="submit" name="Delete" value="Delete">Delete</button>
	<button type="submit" name="Search" value="Search">Search</button>
	<button type="submit" name="SearchAll" value="SearchAll">SearchAll</button>
</td>
</tr>
</table>
<table>
<tr>
	<td>Enter Range	:</td>
	<td><input type="number" name="range"></td>
</tr>
<tr>
	<td colspan="2">
	<button type="submit" name="Find"    value="Find">Find</button>
	
	</td>
</tr>
</table>

</form>

</body>
</html>