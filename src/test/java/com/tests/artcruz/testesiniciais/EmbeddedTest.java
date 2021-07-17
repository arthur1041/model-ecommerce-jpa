package com.tests.artcruz.testesiniciais;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.artcruz.ecommerce.model.EnderecoEntregaPedido;
import com.artcruz.ecommerce.model.Pedido;
import com.artcruz.ecommerce.model.StatusPedido;
import com.tests.artcruz.GenericTest;

public class EmbeddedTest extends GenericTest {

	@Test
	public void analisarMapeamentoObjetoEmbutido() {
		EnderecoEntregaPedido endereco = new EnderecoEntregaPedido();
		
		endereco.setCep("59594-000");
		endereco.setLogradouro("Rua a Vala");
		endereco.setNumero("10");
		endereco.setBairro("Centro");
		endereco.setCidade("Jandacity");
		endereco.setComplemento("Casa");
		endereco.setUf("RN");
		
		Pedido pedido = new Pedido();
		pedido.setDataPedido(LocalDateTime.now());
		pedido.setStatus(StatusPedido.AGUARDANDO);
		pedido.setTotal(new BigDecimal(1000));
		pedido.setEnderecoEntregaPedido(endereco);
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(pedido);
		
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		pedido = entityManager.find(Pedido.class, pedido.getId());
	
		System.out.println(pedido);
		
		Assert.assertNotNull(pedido);
	}
	
}
