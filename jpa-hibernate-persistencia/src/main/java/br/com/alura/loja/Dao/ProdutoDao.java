package br.com.alura.loja.Dao;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

public class ProdutoDao {

    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar (Produto produto){
        this.em.persist(produto);

    }
}
