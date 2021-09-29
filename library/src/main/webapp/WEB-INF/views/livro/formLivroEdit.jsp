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
          <li><a href="/cliente/cadastro" class="nav-link px-2 text-white">Gerenciar Cliente</a></li>
          <li><a href="/livro/cadastro" class="nav-link px-2 text-secondary">Gerenciar Livro</a></li>
          <li><a href="/autor/cadastro" class="nav-link px-2 text-white">Gerenciar Autor</a></li>
          <li><a href="#" class="nav-link px-2 text-white">Alugar</a></li>
        </ul>
      </div>
    </div>
  </header>
</main>

<div class="container" id="containerInicial">


		<h2>Editar o livro: ${livro.titulo_livro}</h2>

		<form action='<c:url value="/livro/salvar" /> ' method="post">
		
		<input type="hidden" name="codigo_livro" value="${livro.codigo_livro}" >

			<div class="form-group">
			
				<label for="titulo_livro">Título</label> 
				
				<input
					type="text" class="form-control" id="titulo_livro"
					placeholder="Informe o titulo do livro" name="titulo_livro" value="${livro.titulo_livro}" required>
			
			</div>
			
			<!--  Colocado Dropdown de acordo com Autor Cadastrado
			<div class="form-group">
			
				<label for="autor_livro">Autor</label> 
				
				<input
					type="text" class="form-control" id="autor_livro"
					placeholder="Informe o autor do livro" name="autor_livro" value="${livro.autor_livro}" required>
			
			</div>
			-->
			
			<div class="form-group">
			
				<label for="autor_livro">Autor</label> <br>
				
			<select id="autor_livro" class="form-control" name="autor_livro" required>
    			<option value="${livro.autor_livro}">${livro.autor_livro}</option>
    			<c:forEach var="autor" items="${autores}" >
    				<c:set var = "Autoraux1" value = "${livro.autor_livro}"/>
    				<c:set var = "Autoraux2" value = "${autor.nome} ${autor.sobrenome}"/>
    				<c:if test="${Autoraux1 != Autoraux2}"> 
    					<option value="${autor.nome} ${autor.sobrenome}">${autor.nome} ${autor.sobrenome}</option>
    				</c:if>
    			</c:forEach>
  			 </select>
  			 
  			 </div>

			<div class="form-group">
			
				<label for="categoria_livro">Categoria</label> 
				
				<input
					type="text" class="form-control" id="categoria_livro"
					placeholder="Informe a categoria do livro" name="categoria_livro" value="${livro.categoria_livro}" required>
			
			</div>
			
			<div class="form-group">
			
				<label for="data_publicacao">Data de Publicação</label> 
				
				<input
					type="date" class="form-control" id="data_publicacao"
					placeholder="Informe a data de publicação" name="data_publicacao" value="${livro.data_publicacao}" required>
			
			</div>
			
			<hr>
			 
			<input type="submit" class="btn btn-primary" value="Salvar" />
			
			<a  class="btn btn-secondary" href='<c:url value="/livro/cadastro/" />' >			
			  	<i class="fa fa-chevron-circle-left" aria-hidder="true" ></i>			
				 Voltar
			 </a>


		</form>

	</div>



<!-- Optional JavaScript; choose one of the two! -->	
<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>	
</body>
</html>