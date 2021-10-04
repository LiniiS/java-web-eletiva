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
					<li class="nav-item active"><a class="nav-link" href="#">Menu<span
							class="sr-only">(current)</span></a></li>
				</ul>
			</div>
		</nav>
	</header>
	<main class="container-fluid pt-3">
		<section class="container m-auto p-5" id="menu-cadastro">
			<section class="jumbotron jumbotron-fluid mb-2">
				<div class="container">
					<h1 display-4>Menu de Registros Online</h1>
					<p class="lead">central de cadastros</p>
				</div>
			</section>
			<div class="card-group">
				<div class="card">
					<img src="./img/img-pessoas.jpg" class="card-img-top"
						alt="Várias pessoas atravessando uma rua com prédios ao fundo.">
					<div class="card-body">
						<h5 class="card-title">Clientes</h5>
						<p class="card-text">Cadastro de clientes.</p>
					</div>
					<div class="card-footer">
						<a href="/gerenciador/listaClientes"
							class="col-sm-12 col-md-8 btn btn-cor-especial">Entrar</a>
					</div>
				</div>
				<div class="card">
					<img src="./img/img-frotas.jpg" class="card-img-top"
						alt="Carros em um intenso tráfego nas ruas, visto de frente.">
					<div class="card-body">
						<h5 class="card-title">Frotas</h5>
						<p class="card-text">Cadastro de carros e motos..</p>
					</div>
					<div class="card-footer">
						<a href="/gerenciador/frotas"
							class="col-sm-12 col-md-8 btn btn-cor-especial">Entrar</a>
					</div>
				</div>
				<div class="card">
					<img src="./img/img-terrenos.jpg" class="card-img-top"
						alt="Terrenos verdes e bem delimitados, vista superior com iluminação de fim de tarde.">
					<div class="card-body">
						<h5 class="card-title">Terrenos</h5>
						<p class="card-text">Cadastro de terrenos regulares e
							irregulares</p>
					</div>
					<div class="card-footer">
						<a href="/gerenciador/listaTerrenos"
							class="col-sm-12 col-md-8 btn btn-cor-especial">Entrar</a>
					</div>
				</div>
				<div class="card">
					<img src="./img/img-produtos.jpg" class="card-img-top"
						alt="Produtos dispostos no interior de um mercado, maçãs em primeiro plano dispostas em caixas de madeira.">
					<div class="card-body">
						<h5 class="card-title">Produtos</h5>
						<p class="card-text">Cadastro de Produtos</p>
					</div>
					<div class="card-footer">
						<a href="/gerenciador/listaProdutos"
							class="col-sm-12 col-md-8 btn btn-cor-especial">Entrar</a>
					</div>
				</div>
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