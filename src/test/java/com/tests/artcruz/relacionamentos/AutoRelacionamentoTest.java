package com.tests.artcruz.relacionamentos;


import org.junit.Assert;
import org.junit.Test;

import com.artcruz.ecommerce.model.Categoria;
import com.tests.artcruz.GenericTest;

public class AutoRelacionamentoTest extends GenericTest {

	@Test
	public void verificarRelacionamento() {
		Categoria categoriaPai = new Categoria();
		categoriaPai.setNome("Eletrônicos");

		Categoria categoria = new Categoria();
		categoria.setNome("Celulares");
		categoria.setCategoriaPai(categoriaPai);
		
		entityManager.getTransaction().begin();
		entityManager.persist(categoriaPai);
		entityManager.persist(categoria);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		categoria = entityManager.find(Categoria.class, categoria.getId());
		
		System.out.println(categoria);
		System.out.println(categoria.getCategoriaPai());
		
		Assert.assertNotNull(categoria.getCategoriaPai());
	}
	
}
