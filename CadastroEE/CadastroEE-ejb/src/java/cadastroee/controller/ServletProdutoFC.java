package cadastroee.controller;

import cadastroee.services.ProdutoFacadeLocal;
import cadastroee.model.Produto;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletProdutoFC extends HttpServlet {

    @EJB
    private ProdutoFacadeLocal produtoFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String destino = null;

        if ("listar".equals(acao)) {
            request.setAttribute("produtos", produtoFacade.listarProdutos());
            destino = "ProdutoLista.jsp";
        } else if ("formIncluir".equals(acao)) {
            // Redirecionar para o formulário de inclusão
            destino = "ProdutoDados.jsp";
        } else if ("formAlterar".equals(acao)) {
            // Buscar o produto para edição
            Long id = Long.parseLong(request.getParameter("id"));
            Produto produto = produtoFacade.buscarProduto(id);
            request.setAttribute("produto", produto);
            destino = "ProdutoDados.jsp";
        } else if ("incluir".equals(acao)) {
            // Incluir um novo produto
            String nome = request.getParameter("nome");
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            double preco = Double.parseDouble(request.getParameter("preco"));

            Produto produto = new Produto();
            produto.setNome(nome);
            produto.setQuantidade(quantidade);
            produto.setPreco(preco);

            produtoFacade.incluirProduto(produto);

            // Redirecionar para a lista de produtos
            request.setAttribute("produtos", produtoFacade.listarProdutos());
            destino = "ProdutoLista.jsp";
        } else if ("alterar".equals(acao)) {
            // Alterar um produto existente
            Long id = Long.parseLong(request.getParameter("id"));
            Produto produto = produtoFacade.buscarProduto(id);

            String nome = request.getParameter("nome");
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            double preco = Double.parseDouble(request.getParameter("preco"));

            produto.setNome(nome);
            produto.setQuantidade(quantidade);
            produto.setPreco(preco);

            produtoFacade.alterarProduto(produto);

            // Redirecionar para a lista de produtos
            request.setAttribute("produtos", produtoFacade.listarProdutos());
            destino = "ProdutoLista.jsp";
        } else if ("excluir".equals(acao)) {
            // Excluir um produto
            Long id = Long.parseLong(request.getParameter("id"));
            produtoFacade.excluirProduto(id);

            // Redirecionar para a lista de produtos
            request.setAttribute("produtos", produtoFacade.listarProdutos());
            destino = "ProdutoLista.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
