package br.com.alura.loja.Dao;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.math.BigDecimal;
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

    public List<Produto> buscarPorNome(String nome){
        String jqpl = "SELECT p FROM Produto p WHERE p.nome = :nome ";
        return em.createQuery(jqpl, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Produto> buscarPorNomeDaCategoria(String nome){
        String jqpl = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome ";
        return em.createQuery(jqpl, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public BigDecimal buscarPrecoDoProdutoComNome(String nome){
        String jqpl = "SELECT p.preco FROM Produto p WHERE p.nome = :nome ";
        return em.createQuery(jqpl, BigDecimal.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }

}
