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
                    <td class="table-warning"><a class="link-danger link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover" href="/${rota}/${item.id}/excluir">excluir</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

</div>
</body>
</html>