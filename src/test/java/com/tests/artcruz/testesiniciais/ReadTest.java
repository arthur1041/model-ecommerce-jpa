package com.tests.artcruz.testesiniciais;

import org.junit.Assert;
import org.junit.Test;

import com.artcruz.ecommerce.model.Produto;
import com.tests.artcruz.GenericTest;

public class ReadTest extends GenericTest {

	@Test
	public void findByPkTest() {
		Produto produto = entityManager.find(Produto.class, 1);
		System.out.println(produto);

		Assert.assertNotNull(produto);
	}

	@Test
	public void atualizarReferencia(){
		Produto produto = entityManager.find(Produto.class, 1);
		produto.setNome("Microfone");

		entityManager.refresh(produto); //Atualiza o objeto para o mesmo estado em que está no banco

		Assert.assertEquals("Kindle", produto.getNome());

	}
}
