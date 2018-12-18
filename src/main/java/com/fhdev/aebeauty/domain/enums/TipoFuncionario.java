package com.fhdev.aebeauty.domain.enums;

public enum TipoFuncionario {
	
	GERENTE(1, "Gerente"),
	CABELEIREIRO(2,"Cabeleireiro"),
	MANICURE(3, "Manicure");
	
	private int codigo;
	private String descricao;
	
	private TipoFuncionario(int codigo, String descricao) {
		
		this.codigo = codigo;
		this.descricao = descricao;
		
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	//Método que retorna um objeto do tipo TipoFuncionario
		public static TipoFuncionario toEnum(Integer codigo) {
			
			if(codigo == null) {
				return null;
			}
			
			for (TipoFuncionario x : TipoFuncionario.values()) {
				
				if(codigo.equals(x.getCodigo())) {
					return x;
				}
			}
			
			throw new IllegalArgumentException("Id inválido: " + codigo);
			
		}

}
