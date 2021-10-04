<!DOCTYPE html>
<html lang="pt">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel='icon' href='../img/icon-touch.png' type='image/x-icon'
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

<link rel="stylesheet" href="../css/style.css">
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
					<li class="nav-item"><a class="nav-link"
						href="/gerenciador">Home</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/gerenciador/menu.jsp">Menu</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/gerenciador/listaTerrenos">Terrenos</a></li>
					<li class="nav-item"><a class="nav-link  active" href="#">Novo Terreno<span
							class="sr-only">(current)</span></a></li>
					
				</ul>
			</div>
		</nav>
	</header>

	<main class="container-fluid mx-auto">
		<section class="container" id="header-cadastro">
			<section class="jumbotron jumbotron-fluid mb-2">
				<div class="container">
					<h1 display-4>Cadastro de Terrenos</h1>
					<p class="lead">todos os cadastros em um só lugar</p>
				</div>
			</section>
			<!--formulÃ¡rios -->
			<section class="container-fluid bg-light pt-2 pb-5 mb-5"
				id="formulario-terreno">
				<!--client-side validation-->
				<form action="/gerenciador/terrenos" method="POST"
					class="needs-validation" novalidate>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="latitude">Latitude</label> <input type="text"
								class="form-control" id="posicaoY" data-tipo="latitude"
								placeholder="-20,483" required
								pattern="([+-]?(([1-8]?[0-9])(\.[0-9]{1,6})?|90(\.0{1,6})?)"
								name="latitude">
							<div class="invalid-feedback">Informe posição em Y</div>
						</div>
						<div class="form-group col-md-6">
							<label for="longitude">Longitude</label> <input type="text"
								class="form-control" id="posicaoY" data-tipo="longitude"
								placeholder="-54,123" required
								pattern="([+-]?((([1-9]?[0-9]|1[0-7][0-9])(\.[0-9]{1,6})?)|180(\.0{1,6})?)"
								name="longitude">
							<div class="invalid-feedback">Informe a posição em X</div>
						</div>
					</div>

					<div class="form-row">
						<div class="form-group col-md-4">
							<label for="alturaMax">Altura máxima</label> <input type="number"
								class="form-control" id="alturaMax" data-tipo="alturaTerreno"
								placeholder="3" required name="alturaMax">
							<div class="invalid-feedback">Informe a altura em metros</div>
						</div>
						<div class="form-group col-md-4">
							<label for="alturaMin">Altura mínima</label> <input type="number"
								class="form-control" id="alturaMin" data-tipo="alturaTerreno"
								placeholder="1" required name="alturaMin">
							<div class="invalid-feedback">Informe a altura em metros</div>
						</div>
						<div class="form-group col-md-4">
							<label for="cotas">Cotas</label> <input type="number"
								class="form-control" id="cotas" data-tipo="cotaTerreno"
								placeholder="2" required name="cotasTerreno">
							<div class="invalid-feedback">
								Informe a quantidade de cotas unitárias
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="quantidade">Quantidade</label> <input type="number"
							class="form-control col-2" id="quantidade" placeholder="5" required
							name="qtdeTerreno">
						<div class="invalid-feedback">Informe a quantidade de
							terrenos</div>
					</div>

					<div class="btn-group" role="group" aria-label="grupo-botoes">
						<button type="submit" class="btn btn-cor-especial">Cadastrar</button>
						<button class="btn btn-dark" type="reset">Limpar</button>
					</div>
				</form>
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

<!--validaÃ§Ã£o client-side -->
<script>
	// Example starter JavaScript for disabling form submissions if there are invalid fields
	(function() {
		'use strict';
		window.addEventListener('load', function() {
			// Fetch all the forms we want to apply custom Bootstrap validation styles to
			var forms = document.getElementsByClassName('needs-validation');
			// Loop over them and prevent submission
			var validation = Array.prototype.filter.call(forms, function(form) {
				form.addEventListener('submit', function(event) {
					if (form.checkValidity() === false) {
						event.preventDefault();
						event.stopPropagation();
					}
					form.classList.add('was-validated');
				}, false);
			});
		}, false);
	})();
</script>
<script type="module" src="js/app.js"></script>

</html>