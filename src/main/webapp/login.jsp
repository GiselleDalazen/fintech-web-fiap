<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">

<style>
h1 {
	font-color: black;
	font-size: 100px;
	align-items: center;
	position: center;
	
</style>



<head>
<link rel="stylesheet" href="resources/css/fintech_index.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Fintech Login</title>
<meta property="og:title" content="Economize com nossa solução">
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

	<c:if test="${not empty err }">
		<div class="alert alert-danger alert-dismissible fade show"
			role="alert">
			<strong>${ err }</strong>
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>

	<div class="d-grid gap-4 col-3 mx-auto m-5">
		<div class="d-grid gap-4">
			<h1><b>Future Planner</b></h1>
		</div>
		<form action="login?action=auth" method="post">
			<div class="mb-3 row">

				<div class="d-grid gap-4">
					<input type="email" class="form-control" name="email"
						id="exampleFormControlInput1" placeholder="E-mail">
				</div>
			</div>
			<div class="mb-3 row">

				<div class="d-grid gap-4">
					<input type="password" class="form-control" name="senha"
						id="inputPassword" placeholder="Senha">
				</div>
			</div>
			<div class="d-flex justify-content-between mb-5">
				<a href="cadastro"><label>Cadastre-se</label></a> <a href="#"><label>Esqueci
						Senha</label></a>
			</div>

			<div class="d-grid gap-4">
				<button type="submit" class="btn btn-success btn-lg">Acessar</button>
			</div>

		</form>
	</div>

	<div class="d-flex justify-content-center ">
		<%--    <img class="img-social" src="resources/img/face.png">--%>
		<%--    <img class="img-social" src="resources/img/insta.png">--%>

		<script type="text/javascript" src="resources/js/jquery-3.6.0.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
			integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>