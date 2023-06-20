<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Future Planner: Objetivos</title>
    <meta property="og:title" content="Economize com nossa solução">
</head>
<header style= background-color:#198754;
        class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
    <a href="/"
       class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
        <svg class="bi me-2" width="40" height="32">
            <use xlink:href="#bootstrap"></use></svg> <span style=color:#FFFFFF class="fs-4" >Future Planner</span>
    </a>

    <ul  class="nav nav-pills">

        <li  class="nav-item"><a style=--bs-nav-link-color:#FFFFFF href="home.jsp" class="nav-link">Home</a></li>
        <li  class="nav-item"><a style=--bs-nav-link-color:#FFFFFF href="mailto:giselledias.joinville@gmail.com" class="nav-link">Fale
            conosco</a></li>

        <li class="nav-item"><a style=--bs-nav-link-color:#FFFFFF href="about.jsp" class="nav-link">About</a></li>
    </ul>

</header>

<body>
<c:if test="${not empty msg }">

    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong>${ nameAttr }</strong> ${ msg }
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>

<c:if test="${not empty err }">
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <strong>${ err }</strong>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>


<div class="d-grid gap-4 col-3 mx-auto">
    <h1 class="title">Cadastrar Objetivo</h1>


    <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#multiCollapseExample1"
            aria-expanded="false" aria-controls="multiCollapseExample1">Novo Objetivo
    </button>

    <!-- MODAL -->
    <div class="collapse multi-collapse" id="multiCollapseExample1">
        <div class="card card-body">
            <form class="row g-3 needs-validation was-validated" novalidate=""
                  action="objetivo-servlet" method="post">

                <div class="d-grid gap-4 mb-3">
                    <input type="text" name="descricao" class="form-control" placeholder="Nome">
                    <div class="invalid-feedback">
                        Nome do Objetivo
                    </div>
                </div>
                <div class="d-grid gap-4 mb-3">
                    <input type="number" name="valor" class="form-control" placeholder="Valor">
                    <div class="invalid-feedback">
                        Valor do objetivo
                    </div>
                </div>

                <div class="d-grid gap-4">
                    <button type="submit" class="btn btn-success btn-lg">Cadastrar</button>
                </div>

            </form>
        </div>
    </div>
    <!-- FIM MODAL -->
</div>

<div class="d-grid gap-4 col-3 mx-auto mt-4">
    <h4 class="title">Meus Objetivos</h4>
    <table class="table table-striped table-bordered table-gray">
        <tr>
            <th colspan="2" class="table-active">Id</th>
            <th colspan="2" class="table-active">Descrição</th>
            <th colspan="2" class="table-active">Valor</th>
        </tr>
        <c:forEach var="objetivo" items="${ listaObjetivos }">
            <tr>
                <td colspan="2" class="table-active">${objetivo.codigo}</td>
                <td colspan="2" class="table-active">${objetivo.descricao}</td>
                <td colspan="2" class="table-active">${objetivo.valor}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<script type="text/javascript" src="resources/js/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
