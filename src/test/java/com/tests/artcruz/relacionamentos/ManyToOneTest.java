package com.tests.artcruz.relacionamentos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.artcruz.ecommerce.model.Cliente;
import com.artcruz.ecommerce.model.Pedido;
import com.artcruz.ecommerce.model.StatusPedido;
import com.tests.artcruz.GenericTest;

public class ManyToOneTest extends GenericTest {

	@Test
	public void verificarRelacionamento() {
		Cliente cliente = entityManager.find(Cliente.class, 1);

		cliente.setNome("Mario");
		
		Pedido pedido = new Pedido();
		pedido.setStatus(StatusPedido.AGUARDANDO);
		pedido.setDataPedido(LocalDateTime.now());
		pedido.setCliente(cliente);
		pedido.setTotal(BigDecimal.TEN);
		
		entityManager.getTransaction().begin();
		entityManager.persist(pedido);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		pedido = entityManager.find(Pedido.class, pedido.getId());
		cliente = entityManager.find(Cliente.class, cliente.getId());
		
		System.out.println("---------------------");
		System.out.println(pedido.getCliente());
		System.out.println(cliente.getPedidos());
	
		
		Assert.assertNotNull(pedido.getCliente());
	}
	
}
