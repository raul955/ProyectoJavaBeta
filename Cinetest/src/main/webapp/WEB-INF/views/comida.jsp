<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Comida</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-light bg-light">
        <a class="navbar-brand" href="pagina.html"></a>
        <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavId">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="nav-link" href="/welcome">Home</a>
                </li>               
                <li class="nav-item">
                    <a class="nav-link" href="/login">Salir</a>
                </li>
            </ul>
            <form action=carromato method="Post" style="float: right">
                    <button class="btn btn-success" type="submit" name="Vcarromato" style="float: right">Ver Carrito</button>
            </form>
        </div>
    </nav></br></br>

	<div align="center" class="row justify-content-center">
		<div class="col-auto">
			<h2>Comida</h2>

			<table id="tablaC" border="1px" class="mt-5 table table-striped table-inverse table-responsive table-center table-bordered text-center">
				<tr>
					<td style="height: 28px; width: 150px;">Codigo Producto</td>
					<td style="height: 28px; width: 150px;">Nombre</td>
					<td style="height: 28px; width: 150px;">Descripcion</td>
					<td style="height: 28px; width: 150px;">Peso</td>
					<td style="height: 28px; width: 150px;">Stock</td>
					<td style="height: 28px; width: 150px;">Categoría</td>
					<td style="height: 28px; width: 150px;">Unidades</td>
					<td style="height: 28px; width: 150px;">Acción</td>
				<tr>
					<c:forEach items="${listaPel}" var="info">
					<form action=comida method="POST">
						<tr>
							<td><input type="text" readonly="readonly" name="codProd" value="${info.codProd}"/></td>
							<td><input type="text" readonly="readonly" name="nombre" value="${info.nombre}"/></td>
							<td><input type="text" readonly="readonly" name="descripcion" value="${info.descripcion}"/></td>
							<td><input type="text" readonly="readonly" name="peso" value="${info.peso}"/></td>
							<td><input type="text" readonly="readonly" name="stock" value="${info.stock}"/></td>
							<td><input type="text" readonly="readonly" name="categoria" value="${info.categoria}"/></td>
							<td><input type="number" name="unidades" required min=1 max="${info.stock}"></td>
							<td><button class="btn btn-success" type="submit" name="comprar">Comprar</button></td>
						</tr>
					</form>
					</c:forEach>
			</table>
			</br> 
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