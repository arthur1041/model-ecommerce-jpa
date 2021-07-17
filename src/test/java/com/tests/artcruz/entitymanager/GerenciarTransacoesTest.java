package com.tests.artcruz.entitymanager;

import org.junit.Test;

import com.artcruz.ecommerce.model.Pedido;
import com.artcruz.ecommerce.model.StatusPedido;
import com.tests.artcruz.GenericTest;

public class GerenciarTransacoesTest extends GenericTest{

	@Test
	public void abrirFecharCancelarTransacao() {
		Pedido pedido = entityManager.find(Pedido.class, 1);
		
		entityManager.getTransaction().begin();
		pedido.setStatus(StatusPedido.PAGO);
		
		if(pedido.getPagamentoCartao() != null) {
			entityManager.getTransaction().commit();
		} else {
			entityManager.getTransaction().rollback();
		}
		
//		entityManager.getTransaction().begin();
//		
//		entityManager.getTransaction().rollback();
//		
//		entityManager.getTransaction().commit();
	}
	
}
