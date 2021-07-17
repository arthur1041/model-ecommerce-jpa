package com.tests.artcruz.testesiniciais;

import org.junit.Assert;
import org.junit.Test;

import com.artcruz.ecommerce.model.Cliente;
import com.artcruz.ecommerce.model.SexoCliente;
import com.tests.artcruz.GenericTest;

public class MapeamentoEnumsTest extends GenericTest {
	
	@Test
	public void testarEnum() {
		Cliente cliente = new Cliente();
		cliente.setNome("José Mineiro");
		cliente.setSexo(SexoCliente.MASCULINO);
	
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		cliente = entityManager.find(Cliente.class, cliente.getId());
		
		Assert.assertNotNull(cliente);
		
	}
}
