package com.tests.artcruz.relacionamentos;

import org.junit.Test;

import com.artcruz.ecommerce.model.Pedido;
import com.tests.artcruz.GenericTest;

public class EagerELazyTest extends GenericTest {

	@Test
	public void verificarComportamento() {
		Pedido pedido = entityManager.find(Pedido.class, 1);
		
		System.out.println(pedido.getItensPedido());
	}
	
}
