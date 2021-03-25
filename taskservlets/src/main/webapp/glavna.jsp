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
		<br>
		<div>
			<h4>Add Manufacturer</h4>
		<form name="form-manufacturer" method="post" action="manufservlet">
			<label for="pib">PIB:</label>
			<input type="text" id="pib" name="pib" placeholder="Enter PIB" />
			
			<label for="mbr">Unique Number:</label>
			<input type="text" id="mbr" name="mbr" placeholder="Enter Unique Number" />
			
			<label for="naziv">Name:</label>
			<input type="text" id="naziv" name="naziv" placeholder="Enter name" />
			<br>
			<label for="adresa">Addres:</label>
			<input type="text" id="adresa" name="adresa" placeholder="Enter Address" />
			
			<label for="city">City:</label>
			<input type="text" id="city" name="city" placeholder="Enter City PTT" />
			
			<input type="submit" value="Add" name="Add" />
		</form>
		<div>
			<table>
				<th>id</th>
				<th>PIB</th>
				<th>Unique Number</th>
				<th>Name</th>
				<th>Address</th>
				<th>City PTT</th>
				<c:forEach items="${manufacturers}" var="m" varStatus="loop">
				<tr>
					<td>${loop.index}</td>
					<td>${m.pib}</td>
					<td>${m.mBr}</td>
					<td>${m.naziv}</td>
					<td>${m.adresa}</td>
					<td>${m.grad.PTT}</td>
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
		<br>
		</div>
		<div>
			<h4>Add Product</h4>
		<form name="form-product" method="post" action="productservlet">
			<label for="id">Id:</label>
			<input type="text" id="id" name="id" placeholder="Id" />
			
			<label for="naziv">Name:</label>
			<input type="text" id="naziv" name="naziv" placeholder="Enter name" />
			
			<label for="cena">Price:</label>
			<input type="text" id="cena" name="cena" placeholder="Enter Price" />
			<br>
			<label for="poreskaStopa">Tax:</label>
			<input type="text" id="poreskaStopa" name="poreskaStopa" placeholder="Enter Tax" />
			
			<label for="mernaJedinica">Unit:</label>
			<input type="text" id="mernaJedinica" name="mernaJedinica" placeholder="Enter Unit" />
			
			<label for="valuta">Currency:</label>
			<input type="text" id="valuta" name="valuta" placeholder="Enter Currency" />
			<br>
			<label for="proizvodjac">Manufacturer:</label>
			<input type="text" id="proizvodjac" name="proizvodjac" placeholder="Enter Manufacturer" />
			
			<input type="submit" value="Add" name="Add" />
		</form>
		<br>
		<div>
			<table>
				<th>id</th>
				<th>Product ID</th>
				<th>Name</th>
				<th>Price</th>
				<th>Tax</th>
				<th>Unit</th>
				<th>Currency</th>
				<th>Manufacturer Name</th>
				<c:forEach items="${products}" var="p" varStatus="loop">
				<tr>
					<td>${loop.index}</td>
					<td>${p.sifra}</td>
					<td>${p.naziv}</td>
					<td>${p.cena}</td>
					<td>${p.poreskaStopa}</td>
					<td>${p.mernaJedinica}</td>
					<td>${p.valuta}</td>
					<td>${p.proizvodjac.naziv}</td>
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
	</div>
</body>
</html>