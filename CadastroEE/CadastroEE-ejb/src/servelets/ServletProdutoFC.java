package cadastroee.servlets;

import cadastroee.ejb.ProdutoFacadeLocal;
import cadastroee.entidades.Produto;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

public class ServletProdutoFC extends HttpServlet {

    @EJB
    private ProdutoFacadeLocal facade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String destino = "ProdutoLista.jsp";

        if ("listar".equals(acao)) {
            List<Produto> listaProdutos = facade.listarProdutos();
            request.setAttribute("produtos", listaProdutos);
        } else if ("formIncluir".equals(acao) || "formAlterar".equals(acao)) {
            destino = "ProdutoDados.jsp";
            if ("formAlterar".equals(acao)) {
                Long id = Long.parseLong(request.getParameter("id"));
                Produto produto = facade.buscarProduto(id);
                request.setAttribute("produto", produto);
            }
        } else if ("excluir".equals(acao)) {
            Long id = Long.parseLong(request.getParameter("id"));
            facade.excluirProduto(id);
            List<Produto> listaProdutos = facade.listarProdutos();
            request.setAttribute("produtos", listaProdutos);
        } else if ("alterar".equals(acao) || "incluir".equals(acao)) {
            Produto produto = new Produto();
            produto.setNome(request.getParameter("nome"));
            produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
            produto.setPreco(Double.parseDouble(request.getParameter("preco")));

            if ("alterar".equals(acao)) {
                Long id = Long.parseLong(request.getParameter("id"));
                produto.setId(id);
                facade.alterarProduto(produto);
            } else {
                facade.incluirProduto(produto);
            }

            List<Produto> listaProdutos = facade.listarProdutos();
            request.setAttribute("produtos", listaProdutos);
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
