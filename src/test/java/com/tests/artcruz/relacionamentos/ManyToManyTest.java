package com.tests.artcruz.relacionamentos;

import org.junit.Assert;
import org.junit.Test;

import com.artcruz.ecommerce.model.Categoria;
import com.artcruz.ecommerce.model.Produto;
import com.tests.artcruz.GenericTest;

public class ManyToManyTest extends GenericTest {

	@Test
	public void verificarRelacionamento() {
		Produto produto = entityManager.find(Produto.class, 1);
		Categoria categoria = entityManager.find(Categoria.class, 1);
		
		entityManager.getTransaction().begin();
		
		produto.getCategorias().add(categoria);
		
		entityManager.getTransaction().commit();
	
		Categoria categoriaVerificacao = entityManager.find(Categoria.class, categoria.getId());
		
		Assert.assertFalse(categoriaVerificacao.getProdutos().isEmpty());
	
	}
	
}
