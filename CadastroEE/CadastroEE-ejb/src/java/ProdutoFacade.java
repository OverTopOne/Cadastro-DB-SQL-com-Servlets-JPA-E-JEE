package cadastroee.ejb;


import cadastroee.entidades.Produto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.util.List;


@Stateless

public class ProdutoFacade implements ProdutoFacadeLocal {


    @PersistenceContext(unitName = "CadastroPU")

    private EntityManager em;


    @Override

    public void alterarProduto(Produto produto) {
        em.merge(produto);

    }


    @Override

    public Produto buscarProduto(long id) {
        return em.find(Produto.class, id);

    }



    @Override

    public List<Produto> listaProdutos() {
        return em.createQuery("SELECT p FROM produto p", Produto.class).getResultList();
        
    }
}