<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel='icon' href='./img/icon-touch.png' type='image/x-icon'
	sizes="16x16" />
<title>Aline - Registros Online</title>
<!-- css imports-->

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css2?family=Style+Script&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<header>
		<!--navbar-->
		<nav class="navbar navbar-expand-lg navbar-dark" id="navbar-especial">
			<a class="navbar-brand" id="fonte-marca-especial" href="#">A-RegiOn</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/gerenciador">Home</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/gerenciador/menu.jsp">Menu</a></li>
					<li class="nav-item active"><a class="nav-link" href="#">Terrenos<span
							class="sr-only">(current)</span></a></li>
					<li class="nav-item"><a class="nav-link "
						href="terreno/formCadastroTerrenos.jsp">Novo Terreno</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<main class="container-fluid pt-3">
		<section class="container m-auto p-5" id="menu-terrenos">
			<section class="jumbotron jumbotron-fluid mb-2">
				<div class="container">
					<h1 display-4>Terrenos</h1>
					<p class="lead">central de registros</p>
				</div>
			</section>
			<section id="pesquisa-terrenos">
				<nav class="navbar navbar-light bg-light">
					<form action="listaTerrenos" method="POST" class="form-inline"
						id="pesquisa-terreno">
						<input class="form-control mr-sm-2" type="search" name="pesquisa"
							placeholder="Pesquisa por cotas" aria-label="Search">
						<button class="btn btn-cor-especial my-2 my-sm-0" type="submit">Pesquisar</button>
					</form>
				</nav>
			</section>
			<section class="table-responsive" id="lista-terrenos">
				<table class="table table-sm mt-3">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Latitude</th>
							<th scope="col">Longitude</th>
							<th scope="col">Cotas</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${terrenos}" var="terreno" varStatus="count">
							<tr>
								<th scope="row">${terreno.id}</th>
								<td>${terreno.latitude}</td>
								<td>${terreno.longitude}</td>
								<td>${terreno.cotasTerreno}</td>
								<td class="text-center">
									<div class="btn-group btn-group-sm" role="group"
										aria-label="botões em grupo">
										<a href="/gerenciador/exibeTerreno?id=${terreno.id}"
											type="button" class="btn btn-cor-especial">Editar</a> <a
											href="/gerenciador/removeTerreno?id=${terreno.id}"
											type="button" class="btn btn-dark">Remover</a>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</section>
		</section>
	</main>
	<footer class="fixed-bottom" id="footer-especial">
		<section class="icones-contato text-center">
			<a class="btn m-0" href="#!" role="button"> <i id="btn-git"
				class="fab fa-github"></i> <small class="text-muted">Aline |
					Registros Online @2021</small>
			</a>
		</section>
	</footer>
</body>
<!--scripts-->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
	integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
	crossorigin="anonymous"></script>
</html>