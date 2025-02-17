<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Produto</title>
    <!-- Incluir a biblioteca do Bootstrap -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h2>Cadastro de Produto</h2>
        <form action="ServletProdutoFC" method="post">
            <input type="hidden" name="acao" value="${param.acao != null ? param.acao : 'incluir'}">
            <c:if test="${param.acao == 'alterar'}">
                <input type="hidden" name="id_produto" value="${produto.id_produto}">
            </c:if>

            <div class="form-group">
                <label for="nome_produto">Nome do Produto</label>
                <input type="text" class="form-control" id="nome_produto" name="nome_produto" value="${produto != null ? produto.nome_produto : ''}" required>
            </div>

            <div class="form-group">
                <label for="quantidade">Quantidade</label>
                <input type="number" class="form-control" id="quantidade" name="quantidade" value="${produto != null ? produto.quantidade : ''}" required>
            </div>

            <div class="form-group">
                <label for="preco_venda">Preço de Venda</label>
                <input type="number" class="form-control" id="preco_venda" name="preco_venda" step="0.01" value="${produto != null ? produto.preco_venda : ''}" required>
            </div>

            <button type="submit" class="btn btn-primary">
                <c:choose>
                    <c:when test="${param.acao == 'alterar'}">Alterar</c:when>
                    <c:otherwise>Incluir</c:otherwise>
                </c:choose>
            </button>
            <a href="ProdutoLista.jsp" class="btn btn-secondary ml-2">Voltar</a>
        </form>
    </div>

    <!-- Incluir o JavaScript do Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
