package com.fhdev.aebeauty.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fhdev.aebeauty.domain.enums.StatusPagamento;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) //Define a criação das tabelas PagamentoCartao e PagamentoBoleto separadamente
public abstract class Pagamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private Integer statusPagamento;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "pedido_id")
	@MapsId //Faz a entidade pagamento herdar o id da entidade pedido
	private Pedido pedido;
	
	public Pagamento() {
	}
	
	public Pagamento(Integer id, StatusPagamento statusPagamento, Pedido pedido) {
		super();
		this.id = id;
		this.statusPagamento = statusPagamento.getCodigo();
		this.pedido = pedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StatusPagamento getEstadoPagamento() {
		return StatusPagamento.toEnum(statusPagamento) ;
	}

	public void setEstadoPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento.getCodigo();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
