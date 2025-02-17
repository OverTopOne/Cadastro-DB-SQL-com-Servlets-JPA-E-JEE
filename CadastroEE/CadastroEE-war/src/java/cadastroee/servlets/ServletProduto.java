package cadastroee.servlets;

import cadastroee.services.ProdutoFacadeLocal;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import cadastroee.model.Produto;

@WebServlet("/ServletProduto")
public class ServletProduto extends HttpServlet {

    @EJB
    private ProdutoFacadeLocal produtoFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Produto> produtos = produtoFacade.findAll();

        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Lista de Produtos</h1>");
        response.getWriter().println("<ul>");
        
        for (Produto produto : produtos) {
            response.getWriter().println("<li>" + produto.getNome() + "</li>");
        }
        
        response.getWriter().println("</ul>");
        response.getWriter().println("</body></html>");
    }
}
