<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Glavna Forma</title>
</head>
<body>
	<h2>Main Form</h2>
	<div>
	<h4>Add city</h4>
		<form name="form-city" method="post" action="cityservlet">
			<label for="PTT">PTT:</label>
			<input type="text" id="PTT" name="PTT" placeholder="Enter PTT" />
			
			<label for="naziv">Name:</label>
			<input type="text" id="naziv" name="naziv" placeholder="Enter name" />
			
			<input type="submit" value="Add" name="Add" />
		</form>
		<br>
		<div>
			<table>
				<th>id</th>
				<th>PTT Number</th>
				<th>City Name</th>
				<c:forEach items="${cities}" var="c" varStatus="loop">
				<tr>
					<td>${loop.index}</td>
					<td>${c.PTT}</td>
					<td>${c.naziv}</td>
					<c:url value="/cityservlet" var="urlDelete">
						<c:param name="index" value="${loop.index}"></c:param>
					</c:url>
					<td>
						<a href="${urlDelete}">delete</a href>
					</td>
				</tr>
			</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>