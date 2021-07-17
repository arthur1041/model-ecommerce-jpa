package com.tests.artcruz.relacionamentos;

import org.junit.Assert;
import org.junit.Test;

import com.artcruz.ecommerce.model.PagamentoCartao;
import com.artcruz.ecommerce.model.Pedido;
import com.artcruz.ecommerce.model.StatusPagamento;
import com.tests.artcruz.GenericTest;

public class OneToOneTest extends GenericTest {

	@Test
	public void verificarRelacionamento() {
		Pedido pedido = entityManager.find(Pedido.class, 1);
		
		PagamentoCartao pagamentoCartao = new PagamentoCartao();
		pagamentoCartao.setNumero("1234");
		pagamentoCartao.setStatus(StatusPagamento.PROCESSANDO);
		pagamentoCartao.setPedido(pedido);
		
		entityManager.getTransaction().begin();
		entityManager.persist(pagamentoCartao);
		entityManager.getTransaction().commit();

		entityManager.clear();
		
		Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
		Assert.assertNotNull(pedidoVerificacao);
	}
	
}
