package com.tests.artcruz.entitymanager;

import org.junit.Test;

import com.artcruz.ecommerce.model.Produto;
import com.tests.artcruz.GenericTest;

public class CachePrimeiroNivelTest extends GenericTest {

	@Test
	public void verificarCache() {
		Produto produto = entityManager.find(Produto.class, 1); //Busca no banco
		System.out.println(produto.getNome());
		
		System.out.println("--------------------");

		Produto produtoResgatado = entityManager.find(Produto.class, produto.getId()); //Busca na memória
		System.out.println(produtoResgatado.getNome());

	}
	
}
