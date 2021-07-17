package com.tests.artcruz.entitymanager;

import com.artcruz.ecommerce.model.Pedido;
import com.artcruz.ecommerce.model.StatusPedido;
import com.tests.artcruz.GenericTest;

public class FlushTest extends GenericTest {

	public void chamarFlush() {
		try {
			entityManager.getTransaction().begin();
			
			Pedido pedido = entityManager.find(Pedido.class, 1);
			pedido.setStatus(StatusPedido.PAGO);
			
			entityManager.flush(); //Forçar enviar update
			
			if(pedido.getPagamentoCartao() == null) {
				throw new RuntimeException();
			}
			
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw e;
		}
	} 
	
}
