<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!-- outra forma de utilizar o fluxo sem depender do root /gerenciador que pode ser alterado -->
<c:url value="/menu.jsp" var="linkMenuCadstros" />

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
					<li class="nav-item active"><a class="nav-link" href="#">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link "
						href="${linkMenuCadstros }">Menu</a></li>
				</ul>
			</div>
		</nav>
	</header>

	<main class="container-fluid pt-3">
		<section class="container m-auto" id="figuras">
			<div class="card mb-5 shadow-sm p-3 mb-5 bg-white rounded">
				<figure class="figure">
					<img src="./img/img-pessoas.jpg"
						class="figure-img img-fluid rounded"
						alt="V??rias pessoas atravessando uma rua com pr??dios ao fundo.">
					<figcaption class="figure-caption text-center">Registros
						dos clientes em potencial</figcaption>
				</figure>
			</div>

			<div class="card mb-5 shadow-sm p-3 mb-5 bg-white rounded">
				<figure class="figure">
					<img src="./img/img-frotas.jpg"
						class="figure-img img-fluid rounded"
						alt="Carros em um intenso tr??fego nas ruas, visto de frente.">
					<figcaption class="figure-caption text-center">Toda a
						frota sob controle</figcaption>
				</figure>
			</div>

			<div class="card mb-5 shadow-sm p-3 mb-5 bg-white rounded">
				<figure class="figure">
					<img src="./img/img-terrenos.jpg"
						class="figure-img img-fluid rounded"
						alt="Terrenos verdes e bem delimitados, vista superior com ilumina????o de fim de tarde.">
					<figcaption class="figure-caption text-center">Terrenos
						regulares e irregulares</figcaption>
				</figure>
			</div>

			<div class="card mb-5 shadow-sm p-3 mb-5 bg-white rounded">
				<figure class="figure">
					<img src="./img/img-produtos.jpg"
						class="figure-img img-fluid rounded"
						alt="Produtos dispostos em prateleiras e caixas dentro de uma mercearia, ma????s em primeiro plano e outros produtos ao fundo.">
					<figcaption class="figure-caption text-center">Produtos
						diversos</figcaption>
				</figure>
			</div>
			
			<div class="card mb-5 shadow-sm p-3 mb-5 bg-white rounded">
				<figure class="figure">
					<img src="./img/img-categorias.jpg"
						class="figure-img img-fluid rounded"
						alt="Vis??o superior do interior da se????o de frutas e legumes de um mercado com pessoas entre as bancas de produtos.">
					<figcaption class="figure-caption text-center">Categorias dos
						diversos Produtos</figcaption>
				</figure>
			</div>

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













