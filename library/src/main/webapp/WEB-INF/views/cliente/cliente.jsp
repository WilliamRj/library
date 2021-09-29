<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

<!-- Custom styles for this template -->
<link href="/resources/css/headers.css" rel="stylesheet">

<title>Livraria PW</title>
</head>
<body>

	<!-- Ola Springboot -->
	
<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
  <symbol id="icone" viewBox="0 0 16 16">
  <path d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811V2.828zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"/>
  </symbol> 
</svg>

<main>
  <header class="p-3 bg-dark text-white">
    <div class="container d-flex justify-content-center">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
          <svg class="bi bi-book" width="40" height="32" role="img" fill="currentColor"><use xlink:href="#icone"/></svg>
		<h3 class="float-md-start mb-0">Livraria PW&nbsp;&nbsp;&nbsp;&nbsp;</h3>
        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="/" class="nav-link px-2 text-white">Início</a></li>
          <li><a href="/cliente/cadastro" class="nav-link px-2 text-secondary">Gerenciar Cliente</a></li>
          <li><a href="/livro/cadastro" class="nav-link px-2 text-white">Gerenciar Livro</a></li>
          <li><a href="/autor/cadastro" class="nav-link px-2 text-white">Gerenciar Autor</a></li>
          <li><a href="/categoria/cadastro" class="nav-link px-2 text-white">Gerenciar Categoria</a></li>
          <li><a href="#" class="nav-link px-2 text-white">Alugar</a></li>
        </ul>
      </div>
    </div>
  </header>
</main>

	<div class="container" id="containerInicial">

		<div class="d-flex justify-content-between">
			<h1>Lista de Clientes</h1>
			<h3>
				<a class="btn btn-primary" href='<c:url value="/cliente/cadastro/form" /> ' > Cadastrar cliente</a>
			</h3>
		</div>

		<table class="table table-striped">

			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Endereço</th>
					<th>Telefone</th>
					<th>Email</th>
					<th>#</th>
				</tr>

			</thead>

			<tbody>
			  	 <c:forEach var="cliente" items="${clientes}" >   
						<tr>
							<td> ${cliente.codigo_cliente}  </td>
							<td>${cliente.nome}</td>
							<td>${cliente.endereco}</td>
							<td>${cliente.telefone}</td>
							<td>${cliente.email}</td>
							<td>
							
							<a href='<c:url value="/cliente/cadastro/edit/${cliente.codigo_cliente}" />' >
							    <button class="btn btn-primary" type="button" >Editar</button>
							</a> 
							
							<a href='<c:url value="/cliente/cadastro/delete/${cliente.codigo_cliente}" />' >
							    <button class="btn btn-danger" type="button" >Excluir</button>
							</a>
							
							</td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>





<!-- Optional JavaScript; choose one of the two! -->	
<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>	
</body>
</html>