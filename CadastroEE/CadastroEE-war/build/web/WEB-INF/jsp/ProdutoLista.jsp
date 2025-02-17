<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listagem de Produtos</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>Produtos</h2>
        <a href="ServletProdutoFC?acao=formIncluir" class="btn btn-primary mb-2">Incluir Produto</a>
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
                <%-- Aqui você renderiza a lista de produtos --%>
                <c:forEach var="produto" items="${produtos}">
                    <tr>
                        <td>${produto.id}</td>
                        <td>${produto.nome}</td>
                        <td>${produto.quantidade}</td>
                        <td>${produto.precoVenda}</td>
                        <td>
                            <a href="ServletProdutoFC?acao=formAlterar&id=${produto.id}" class="btn btn-sm btn-primary">Alterar</a>
                            <a href="ServletProdutoFC?acao=excluir&id=${produto.id}" class="btn btn-sm btn-danger">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
