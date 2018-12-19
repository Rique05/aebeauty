package com.fhdev.aebeauty.domain;

import javax.persistence.Entity;

import com.fhdev.aebeauty.domain.enums.StatusPagamento;

@Entity
public class PagamentoCartao extends Pagamento{ //Não precisa implementar Serializable porque está herdando de Pagamento, que implementa a interface Serializable
	private static final long serialVersionUID = 1L;

	private Integer numeroParcelas;
	
	public PagamentoCartao() {
		
	}

	public PagamentoCartao(Integer id, StatusPagamento statusPagamento, Pedido pedido, Integer numeroParcelas) {
		super(id, statusPagamento, pedido);
		this.numeroParcelas = numeroParcelas;
	}

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}
		
}
