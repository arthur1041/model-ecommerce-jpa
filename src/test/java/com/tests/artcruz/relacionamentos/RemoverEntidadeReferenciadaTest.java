package com.tests.artcruz.relacionamentos;

import org.junit.Assert;
import org.junit.Test;

import com.artcruz.ecommerce.model.ItemPedido;
import com.artcruz.ecommerce.model.Pedido;
import com.tests.artcruz.GenericTest;

public class RemoverEntidadeReferenciadaTest extends GenericTest {
	
	@Test
	public void removerEntidadeRelacionada() {
		Pedido pedido = entityManager.find(Pedido.class, 1);
		
		Assert.assertFalse(pedido.getItensPedido().isEmpty());
		
		entityManager.getTransaction().begin();
		
		for (ItemPedido item : pedido.getItensPedido()) {
			entityManager.remove(item);
		}
		entityManager.remove(pedido);
		
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		pedido = entityManager.find(Pedido.class, pedido.getId());
		
		Assert.assertNull(pedido);
	}
	
}
