package com.fhdev.aebeauty.domain.enums;

//Implementação sofisticada de um tipo enumerado (StatusAgenda)
public enum StatusAgenda {
	
	ABERTA(1, "Aberta"),
	PENDENTE(2, "Pendente"),
	FINALIZADA(3, "Finalizada"),
	CANCELADA(4, "Cancelada");
	
	private int codigo;
	private String descricao;
	
	private StatusAgenda(int codigo, String descricao) {
		
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	//Método que retorna um objeto do tipo StatusAgenda
	public static StatusAgenda toEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		
		for (StatusAgenda x : StatusAgenda.values()) {
			
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + codigo);
		
	}
	
}
