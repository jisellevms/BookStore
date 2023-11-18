<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <meta charset="ISO-8859-1">
    <title>BookStore</title>
    <link rel="icon" href="https://topprodutor.com.br/wp-content/uploads/2019/05/Book-PNG-Clipart-300x300.png">
</head>
<body>
<nav class="navbar navbar-expand-sm " style="background-color: #e69e19;">
    <div class="container-fluid">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link active" href="/">
                    <img src="https://topprodutor.com.br/wp-content/uploads/2019/05/Book-PNG-Clipart-300x300.png"
                         width="27px" height="27px">
                    BookStore</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/vendedor/lista">Vendedores</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/produto/lista">Produtos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/livrofisico/lista">Livros Fisicos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/livrodigital/lista">Livros Digitais</a>
            </li>
        </ul>
        <c:if test="${not empty listagem}">
            <form class="d-flex" action="/${rota}/pesquisar"><input class="form-control me-2" type="text"
                                                                    name="campoBusca" placeholder="Search">
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
        </c:if>
    </div>
</nav>

<div class="container mt-3">
    <span class="badge bg-primary">Vendedor: ${qtdVendedor}</span>
    <span class="badge bg-secondary">Produto: ${qtdProdutos}</span>
    <span class="badge bg-info">Livros Fisicos: ${qtdLivroFisico}</span>
    <span class="badge bg-success">Livros Digitais: ${qtdLivroDigital}</span>
    <c:if test="${not empty listagem}">
        <h2>BookStore</h2>
        <p>Gestão de vendas de produtos:</p>
        <table class="table table-hover">
            <thead class="table-dark">
            <tr>
                <th>${titulo}</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${listagem}">
                <tr>
                    <td class="table-warning">${item}</td>
                    <td class="table-warning"><a
                            class="link-danger link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"
                            href="/${rota}/${item.id}/excluir">excluir</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <hr>
    <c:if test="${empty listagem}">
        <form action="/informacao/incluir" method="post">
            <div class="row">
                <div class="col"><input type="text" class="form-control" placeholder="Entre com o campo" name="campo">
                </div>
                <div class="col"><input type="text" class="form-control" placeholder="Entre com a descrição"
                                        name="descricao"></div>
                <div class="col">
                    <button class="btn btn-primary" type="submit">Cadastrar</button>
                </div>
            </div>
        </form>
        <hr>
        <c:if test="${not empty informacoes}">
            <table class="table table-hover">
                <thead class="table-dark">
                <tr>
                    <th>Informações:</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${informacoes}">
                    <tr>
                        <td class="table-success">${item}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </c:if>
    <c:if test="${not empty objeto}">
        <hr>
        <div class="alert alert-success">
            <strong>Sucesso!</strong>
                ${objeto}
        </div>
    </c:if>

</div>
</body>
</html>