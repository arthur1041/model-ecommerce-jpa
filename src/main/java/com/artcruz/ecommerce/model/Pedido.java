package com.artcruz.ecommerce.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	public Pedido() {
		
	}
		
	public Pedido(Integer id, LocalDateTime dataPedido, LocalDateTime dataConclusao, NotaFiscal notaFiscal,
			BigDecimal total, StatusPedido status, Cliente cliente) {
		super();
		this.id = id;
		this.dataPedido = dataPedido;
		this.dataConclusao = dataConclusao;
		this.notaFiscal = notaFiscal;
		this.total = total;
		this.status = status;
		this.cliente = cliente;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@Column(name = "data_pedido")
	private LocalDateTime dataPedido;

	@Column(name = "data_conclusao")
	private LocalDateTime dataConclusao;

	@OneToOne(mappedBy = "pedido")
	private NotaFiscal notaFiscal;

	private BigDecimal total;

	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	@Embedded
	private EnderecoEntregaPedido enderecoEntregaPedido;
	
	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itensPedido;
	
	@OneToOne(mappedBy = "pedido")
	private PagamentoCartao pagamentoCartao;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDateTime getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(LocalDateTime dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public EnderecoEntregaPedido getEnderecoEntregaPedido() {
		return enderecoEntregaPedido;
	}

	public void setEnderecoEntregaPedido(EnderecoEntregaPedido enderecoEntregaPedido) {
		this.enderecoEntregaPedido = enderecoEntregaPedido;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public PagamentoCartao getPagamentoCartao() {
		return pagamentoCartao;
	}

	public void setPagamentoCartao(PagamentoCartao pagamentoCartao) {
		this.pagamentoCartao = pagamentoCartao;
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + ", dataPedido=" + dataPedido + ", dataConclusao="
				+ dataConclusao + ", notaFiscal=" + notaFiscal + ", total=" + total + ", status=" + status
				+ ", enderecoEntregaPedido=" + enderecoEntregaPedido + "]";
	}

}
