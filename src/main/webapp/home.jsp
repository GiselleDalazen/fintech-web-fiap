<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>

<%--    <link rel="stylesheet" href="resources/css/fintech.css">--%>
<title>Fintech Future Planner</title>
<meta property="og:title" content="Economize com nossa solução">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body
	style="background-color: #85FFBD; background-image: linear-gradient(45deg, #85FFBD 0%, #FFFB7D 100%);">

	<c:if test="${not empty msg }">

		<div class="alert alert-success alert-dismissible fade show"
			role="alert">
			<strong>${ nameAttr }</strong> ${ msg }
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>

	<c:if test="${not empty msgErr }">
		<div class="alert alert-danger alert-dismissible fade show"
			role="alert">
			<strong>${ msgErr }</strong>
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>

	<header style= background-color:#198754;
		class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
		<a href="/"
			class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
			<svg class="bi me-2" width="40" height="32">
				<use xlink:href="#bootstrap"></use></svg> <span style=color:#FFFFFF class="fs-4" >Future Planner</span>
		</a>

		<ul  class="nav nav-pills">
			<li  class="nav-item"><a style=--bs-nav-link-color:#FFFFFF href="mailto:giselledias.joinville@gmail.com" class="nav-link">Fale
					conosco</a></li>
			<li class="nav-item"><a style=--bs-nav-link-color:#FFFFFF href="about.jsp" class="nav-link">About</a></li>
		</ul>

	</header>


	<div class="d-grid gap-4 col-3 mx-auto">
		<h1 class="title">Bem vindo ao Future Planner!</h1>
		<p class="subtitle">Seu controle financeiro na palma da sua mão:</p>
		
		<a class="btn btn-success btn-lg" href="despesa-servlet" role="button">Despesas</a>
		<a class="btn btn-success btn-lg" href="receita-servlet" role="button">Receitas</a> 
		<a class="btn btn-success btn-lg" href="investimento-servlet" role="button">Investimentos</a> 
		<a class="btn btn-success btn-lg" href="objetivo-servlet" role="button">Objetivos</a>
		<a class="btn btn-success btn-lg" href="conta-servlet" role="button">Conta</a>
	</div>
	<script type="text/javascript" src="resources/js/jquery-3.6.0.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>