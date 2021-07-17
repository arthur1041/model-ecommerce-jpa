package com.tests.artcruz.testesiniciais;

import java.math.BigDecimal;

import com.artcruz.ecommerce.model.Produto;
import com.tests.artcruz.GenericTest;

import org.junit.Assert;
import org.junit.Test;

public class OperacaoComTransacaoTest extends GenericTest {

    @Test
    public void abrirEFecharATransaction() {

        Produto produto = new Produto();

        entityManager.getTransaction().begin();

        entityManager.persist(produto);
        entityManager.merge(produto);
        entityManager.remove(produto);

        entityManager.getTransaction().commit();
    }

    @Test
    public void inserirPrimeiroRegistro() {
        Produto produto = new Produto();

        produto.setNome("Câmera Canon");
        produto.setDescricao("A melhor definição para suas fotos.");
        produto.setPreco(new BigDecimal(5000));

        entityManager.getTransaction().begin();

        entityManager.persist(produto);

        entityManager.getTransaction().commit();

        entityManager.clear(); // <- Limpando memória do entityManager, para a consulta abaixo vir direto do
                               // banco

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());

        Assert.assertNotNull(produtoVerificacao);
    }

    @Test
    public void removerObjeto() {
        Produto produto = new Produto();

        produto = entityManager.find(Produto.class, 1);

        entityManager.getTransaction().begin();

        entityManager.remove(produto);

        entityManager.getTransaction().commit();

        Produto produtoVerificacao = entityManager.find(Produto.class, 1);

        // entityManager.clear(); <- não precisa pois após remover, o objeto não existe
        // mais na memóra

        Assert.assertNull(produtoVerificacao);
    }

    @Test
    public void atualizarObjeto() {

        Produto produto = new Produto();

        produto.setId(1);
        produto.setNome("abcd");
        produto.setDescricao("xyz");
        produto.setPreco(new BigDecimal(599));

        entityManager.getTransaction().begin();

        entityManager.merge(produto);

        entityManager.getTransaction().commit();

        entityManager.clear(); // <- Limpando memória do entityManager, para a consulta abaixo vir direto do
                               // banco

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());

        Assert.assertNotNull(produtoVerificacao);
    }

    @Test
    public void atualizarObjetoGerenciado() {

        Produto produto = entityManager.find(Produto.class, 1);

        entityManager.getTransaction().begin();

        // entityManager.merge(produto);
        produto.setNome("Objeto gerenciado..."); // <- objeto gerenciado não precisa do merge

        entityManager.getTransaction().commit();

        entityManager.clear(); // <- Limpando memória do entityManager, para a consulta abaixo vir direto do
                               // banco

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());

        Assert.assertNotNull(produtoVerificacao);
    }

    @Test
    public void inseriRegistroComMerge() {
        Produto produto = new Produto();

        produto.setId(4);
        produto.setNome("Câmera Canon");
        produto.setDescricao("A melhor definição para suas fotos.");
        produto.setPreco(new BigDecimal(5000));

        entityManager.getTransaction().begin();

        entityManager.merge(produto);

        entityManager.getTransaction().commit();

        entityManager.clear(); // <- Limpando memória do entityManager, para a consulta abaixo vir direto do
                               // banco

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());

        Assert.assertNotNull(produtoVerificacao);
    }

    @Test
    public void impedirOperacaoUsandoDetach() {

        Produto produto = entityManager.find(Produto.class, 1);

        entityManager.detach(produto);

        entityManager.getTransaction().begin();

        // entityManager.merge(produto);
        produto.setNome("Objeto gerenciado..."); // <- não vai sutir efeito no banco pois o objeto está sendo desanexado
                                                 // do contexto de presistência com o método detach

        entityManager.getTransaction().commit();

        entityManager.clear(); // <- Limpando memória do entityManager, para a consulta abaixo vir direto do
                               // banco

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());

        Assert.assertNotNull(produtoVerificacao);
    }

}