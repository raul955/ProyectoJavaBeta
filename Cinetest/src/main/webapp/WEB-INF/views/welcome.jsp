<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lista de categorías</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
<div align="center">

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
<h2>Bienvenido ${user }</h2>


</br></br>

<form method="post" action="welcome1">
<input type="submit" value="BebidasCon" class="btn btn-outline-primary">
<input name="action" value="bebidasConjsp" style="visibility: hidden; display: none;">
</form>

<form method="post" action="welcome2">
<input type="submit" value="BebidasSin" class="btn btn-outline-primary">
<input name="action" value="bebidasSinjsp" style="visibility: hidden; display: none;">
</form>

<form method="post" action="welcome3">
<input type="submit" value="Comida" class="btn btn-outline-primary">
<input name="action" value="comidajsp" style="visibility: hidden; display: none;">
</form>
</br></br>

<a href="/login"><input type="button" value="Volver" class="btn btn-outline-danger"/></a>
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