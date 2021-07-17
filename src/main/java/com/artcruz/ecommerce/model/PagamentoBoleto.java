package com.artcruz.ecommerce.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pagamento_boleto")
public class PagamentoBoleto implements Serializable {

	private static final long serialVersionUID = 1L;

	public PagamentoBoleto() {
		
	}
	
	public PagamentoBoleto(Integer id, Pedido pedido, StatusPagamento status, String codigoBarras) {
		super();
		this.id = id;
		this.pedido = pedido;
		this.status = status;
		this.codigoBarras = codigoBarras;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Pedido pedido;
	
	@Enumerated(EnumType.STRING)
	private StatusPagamento status;
	
	@Column(name = "codigo_barras")
	private String codigoBarras;

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

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
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
		PagamentoBoleto other = (PagamentoBoleto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "PagamentoCartao [id=" + id + ", pedido=" + pedido + ", status=" + status + ", codigoBarras=" + codigoBarras + "]";
	}
	
}
