package br.com.alura.loja.Dao;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class ProdutoDao {

    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar (Produto produto){
        this.em.persist(produto);

    }

    public Produto buscaPorId(Long id){
        return em.find(Produto.class, id);

    }

    public List<Produto> buscarTodos(){
        String jqpl = "SELECT p FROM Produto p ";
        return em.createQuery(jqpl, Produto.class).getResultList();
    }
}
