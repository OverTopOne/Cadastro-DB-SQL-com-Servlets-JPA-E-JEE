<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Produto</title>
    <!-- Inclusão do Bootstrap -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1>${produto != null ? 'Alterar Produto' : 'Incluir Novo Produto'}</h1>
        <form action="ServletProdutoFC" method="post">
            <input type="hidden" name="acao" value="${produto != null ? 'alterar' : 'incluir'}" />
            <c:if test="${produto != null}">
                <input type="hidden" name="id" value="${produto.id}" />
            </c:if>
            <div class="mb-3">
                <label for="nome" class="form-label">Nome</label>
                <input type="text" class="form-control" id="nome" name="nome" value="${produto != null ? produto.nome : ''}" required />
            </div>
            <div class="mb-3">
                <label for="quantidade" class="form-label">Quantidade</label>
                <input type="number" class="form-control" id="quantidade" name="quantidade" value="${produto != null ? produto.quantidade : ''}" required />
            </div>
            <div class="mb-3">
                <label for="preco" class="form-label">Preço</label>
                <input type="number" class="form-control" id="preco" name="preco" value="${produto != null ? produto.preco : ''}" required />
            </div>
            <button type="submit" class="btn btn-primary">${produto != null ? 'Alterar' : 'Incluir'}</button>
        </form>
    </div>
</body>
</html>
