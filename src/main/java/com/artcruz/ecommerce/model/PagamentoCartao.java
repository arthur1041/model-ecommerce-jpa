package com.artcruz.ecommerce.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pagamento_cartao")
public class PagamentoCartao implements Serializable {

	private static final long serialVersionUID = 1L;

	public PagamentoCartao() {
		
	}
	
	public PagamentoCartao(Integer id, Pedido pedido, StatusPagamento status, String numero) {
		super();
		this.id = id;
		this.pedido = pedido;
		this.status = status;
		this.numero = numero;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	
	@Enumerated(EnumType.STRING)
	private StatusPagamento status;
	
	private String numero;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public StatusPagamento getStatus() {
		return status;
	}

	public void setStatus(StatusPagamento status) {
		this.status = status;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PagamentoCartao other = (PagamentoCartao) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "PagamentoCartao [id=" + id + ", pedido=" + pedido + ", status=" + status + ", numero=" + numero + "]";
	}
	
}
