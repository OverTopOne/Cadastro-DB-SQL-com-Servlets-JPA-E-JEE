<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Lista de Produtos</title>
    <!-- Inclusão do Bootstrap -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1>Lista de Produtos</h1>
        <a href="ServletProdutoFC?acao=formIncluir" class="btn btn-primary m-2">Incluir Novo Produto</a>
        <table class="table table-striped">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Quantidade</th>
                    <th>Preço</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="produto" items="${produtos}">
                    <tr>
                        <td>${produto.id}</td>
                        <td>${produto.nome}</td>
                        <td>${produto.quantidade}</td>
                        <td>${produto.preco}</td>
                        <td>
                            <a href="ServletProdutoFC?acao=formAlterar&id=${produto.id}" class="btn btn-primary btn-sm">Alterar</a>
                            <a href="ServletProdutoFC?acao=excluir&id=${produto.id}" class="btn btn-danger btn-sm">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
