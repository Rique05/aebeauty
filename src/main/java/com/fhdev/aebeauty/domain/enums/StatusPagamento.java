package com.fhdev.aebeauty.domain.enums;

public enum StatusPagamento {
	
	PENDENTE(1, "Pendente"),
	PAGO(2, "Pago"),
	CANCELADO(3, "Cancelado");
	
	private int codigo;
	private String descricao;
	
	private StatusPagamento(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	//Método que retorna um objeto do tipo StatusPagamento
		public static StatusPagamento toEnum(Integer codigo) {
			
			if(codigo == null) {
				return null;
			}
			
			for (StatusPagamento x : StatusPagamento.values()) {
				
				if(codigo.equals(x.getCodigo())) {
					return x;
				}
			}
			
			throw new IllegalArgumentException("Id inválido: " + codigo);
			
		}

}
