<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Mantenimiento</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
</head>
<body>

	<div align="center" class="row justify-content-center">
		<div class="col-auto">
			<h2>Mantenimiento</h2>

			<table id="tablaMantenimiento" border="1px" class="mt-5 table table-striped table-inverse table-responsive table-center table-bordered text-center">
				<tr>
					<td style="height: 28px; width: 150px;">Director</td>
					<td style="height: 28px; width: 150px;">Titulo</td>
					<td style="height: 28px; width: 150px;">Fecha</td>
					<td style="height: 28px; width: 150px;">ID</td>
				<tr>
					<c:forEach items="${listaPel}" var="info">
						<tr>
							<td>${info.nombre }</td>
							<td>${info.director }</td>
							<td>${info.fecha }</td>
							<td>${info.id }</td>
						</tr>
					</c:forEach>
			</table>
			</br> <a href="/nuevaPelicula"><input type="button"
				value="Nueva Pelicula" class="btn btn-outline-primary" /></a> </br> </br> <a
				href="/modificarPelicula"><input type="button"
				value="Modificar Película" class="btn btn-outline-primary" /></a> </br> </br> 
				
				<a href="/borrarPelicula"><input type="button"
				value="Borrar Película" class="btn btn-outline-primary" />
				</a> </br> </br> <a
				href="/welcome"><input type="submit" value="Volver"
				class="btn btn-outline-danger" /></a> </br> </br>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>