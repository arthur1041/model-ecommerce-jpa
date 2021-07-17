package com.artcruz.ecommerce.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public NotaFiscal() {
		
	}
	
	public NotaFiscal(Integer id, Pedido pedido, String xml, Date dataEmissao) {
		super();
		this.id = id;
		this.pedido = pedido;
		this.xml = xml;
		this.dataEmissao = dataEmissao;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	
	private String xml;
	
	@Column(name = "data_emissao")
	private Date dataEmissao;

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

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
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
		NotaFiscal other = (NotaFiscal) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "NotaFiscal [id=" + id + ", pedido=" + pedido + ", xml=" + xml + ", dataEmissao=" + dataEmissao + "]";
	}
	
}
