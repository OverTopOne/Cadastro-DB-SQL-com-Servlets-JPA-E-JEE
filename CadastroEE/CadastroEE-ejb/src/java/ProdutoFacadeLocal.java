package cadastroee.ejb;

import cadastroee.entidades.Produto;
import javax.ejb.local;
import java.util.List;


@Local

public interface ProdutoFacadeLocal {
    void incluirProduto(Produto produto);
    void alterarProduto(Produto produto);
    void excluirProduto(Long id);
    Produto buscarProduto(long id);
    List<Produto> listarProdutos();
    
}