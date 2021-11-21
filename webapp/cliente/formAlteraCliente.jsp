<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="pt">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel='icon' href='../src/img/icon-touch.png' type='image/x-icon'
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
					<li class="nav-item"><a class="nav-link" href="/gerenciador">Home</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="/gerenciador/menu.jsp">Menu</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/gerenciador/listaClientes">Clientes</a></li>
					<li class="nav-item  active"><a class="nav-link" href="#">Alteração
							de Dados<span class="sr-only">(current)</span>
					</a></li>

				</ul>
			</div>
		</nav>
	</header>
	<main class="container-fluid mx-auto">
		<section class="container" id="header-cadastro">
			<section class="jumbotron jumbotron-fluid mb-2">
				<div class="container">
					<h1 display-4>Cliente: ${cliente.nome}</h1>
					<p class="lead">corrija ou atualize os dados do Cliente</p>
				</div>
			</section>
			<!--formulários -->
			<section class="container-fluid bg-light pt-2 pb-5 mb-5"
				id="formulario-cliente">
				<!--client-side validation-->
				<!-- definir qual ação será chamada ao enviar o formulário -->
				<form action="alteraCliente" method="POST" class="needs-validation"
					novalidate>
					<div class="form-row">
						<div class="form-group col-md-2 mt-2">
							<label class="badge badge-secondary text-wrap text-monospace"
								style="width: 6rem;" for="codigo">Cliente id:
								${cliente.id}</label> <input type="text" class="form-control"
								id="codigo" value="${cliente.id}" name="id" hidden>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="nome">Nome</label> <input type="text"
								class="form-control" id="nome" data-tipo="nome" name="nome"
								required value="${cliente.nome}">
							<div class="invalid-feedback">Informe o nome</div>
						</div>
						<div class="form-group col-md-6">
							<label for="sobrenome">Sobrenome</label> <input type="text"
								class="form-control" id="sobrenome" name="sobrenome" required
								value="${cliente.sobrenome}">
							<div class="invalid-feedback">Informe o sobrenome</div>
						</div>
					</div>

					<div class="form-row">
						<div class="form-group col-md-4">
							<label for="email">Email</label> <input type="email"
								class="form-control" id="email" name="email" required
								value="${cliente.email}">
							<div class="invalid-feedback">Informe o email</div>
						</div>
						<div class="form-group col-md-4">
							<label for="telefone">Telefone</label> <input type="text"
								class="form-control" id="telefone" name="telefone" required
								value="${cliente.telefone }"
								pattern="([0-9]{2,3})?([0-9]{2})([0-9]{4,5})([0-9]{4})">
							<div class="invalid-feedback">Informe o telefone</div>
						</div>
						
						<div class="form-group col-md-4">
							<!-- verificar  a conversão/correção da dt no modelo/banco -->
							<label for="dtNascimento">Data Nascimento</label> <input
								type="date" class="form-control" id="dtNascimento"
								data-tipo="dtNascimento" value="${cliente.dtNascimento}"name="dtNascimento" readonly>

							<div class="invalid-feedback">
								Informe data de nascimento<small> (+18 anos)</small>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="logradouro">Logradouro</label> <input type="text"
							class="form-control" id="logradouro" name="logradouro" required
							value="${cliente.logradouro }">
						<div class="invalid-feedback">Informe a rua, avenida,
							travessa</div>
					</div>
					<div class="form-group">
						<label for="bairro">Bairro</label> <input type="text"
							class="form-control" id="bairro" maxlength="15" name="bairro"
							value="${cliente.bairro }" required>
						<div class="invalid-feedback">Informe o bairro</div>
					</div>

					<div class="form-group">
						<label for="complemento">Complemento</label> <input type="text"
							class="form-control" id="complemento" name="complemento"
							placeholder="Apartamento, bloco, andar">
						<div class="valid-feedback">Campo opcional</div>
					</div>

					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="cidade">Cidade</label> <input type="text"
								class="form-control" id="cidade" required maxlength="30"
								value="${cliente.cidade }" name="cidade">
							<div class="invalid-feedback">Informe a cidade</div>
						</div>
						<div class="form-group col-md-2">
							<label for="estado">Estado</label> <input type="text"
								value="${cliente.estado }" class="form-control" id="estado"
								pattern="([A-Z]{2})" name="estado" required>
							<div class="invalid-feedback">Informe a sigla do estado</div>
						</div>
						<div class="form-group col-md-4">
							<label for="cep">CEP</label> <input type="text"
								class="form-control" id="cep" required value="${cliente.CEP }"
								pattern="([\d]{5}-?[\d]{3})" name="cep">
							<div class="invalid-feedback">Informe o CEP</div>
						</div>
					</div>
					<div class="btn-group" role="group" aria-label="grupo-botoes">
						<button type="submit" class="btn btn-cor-especial">Salvar</button>
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

<!--validação client-side -->
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
<script type="module" src="./js/app.js"></script>

</html>

