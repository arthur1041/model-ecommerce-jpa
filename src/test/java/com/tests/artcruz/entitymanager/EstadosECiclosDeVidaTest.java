package com.tests.artcruz.entitymanager;

import org.junit.Test;

import com.artcruz.ecommerce.model.Categoria;
import com.tests.artcruz.GenericTest;

public class EstadosECiclosDeVidaTest extends GenericTest{

	@Test
	public void analisarEstados() {
		Categoria novaCategoria = new Categoria(); //Estado novo
		
		Categoria categoriaGerenciadoMerge = entityManager.merge(novaCategoria); //Obtém o retorono gerenciado
		
		Categoria categoriaGerenciada = entityManager.find(Categoria.class, 1); //Estado gerenciado
		
		entityManager.remove(categoriaGerenciada); //Passando para o estado removed
		
		entityManager.persist(categoriaGerenciada); //Passando de volta para o estado gerenciado
		
		entityManager.detach(categoriaGerenciada); //Desanexando (mesma coisa de um estado novo)
	}
	
}
